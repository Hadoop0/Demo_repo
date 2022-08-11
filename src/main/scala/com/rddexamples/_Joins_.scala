package com.rddexamples
import org.apache.spark.sql.functions._
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.catalyst.plans.LeftOuter
import org.apache.spark.sql.functions.{col, lit}
//spark.sql.crossJoin.enabled=true

object _Joins_ {

  def main(args: Array[String]): Unit = {

  val spark = SparkSession.builder().appName("Joins_Test").master("local[2]").getOrCreate()

    //val csvdata = spark.read.format("csv").option("header",true).load("D:\\Learnings\\Bigdata_Classes\\readfiles\\test.txt")
    val csvdata = spark.read.option("header",true).csv("D:\\Learnings\\Bigdata_Classes\\readfiles\\test.txt")
    val sal = spark.read.option("header",true).csv("D:\\Learnings\\Bigdata_Classes\\readfiles\\sal.txt")
   // csvdata.join(sal,csvdata("id")===sal("id")).select(csvdata("name"),sal("sal")).show()
    /*csvdata.join(sal,csvdata("id")===sal("id"),"LeftOuter").select(csvdata("id"),csvdata("name"),sal("sal")).show()*/
    // ?? csvdata("id"),csvdata("name"),sal("sal")) ---- How to get two or more col from same table instead csvdata("id"),csvdata("name") from above command

    //csvdata.join(sal,csvdata("id")===sal("id"),"Inner").filter(sal("sal")>=3000).select(csvdata("name"),sal("sal")).show()
    //csvdata.join(sal,csvdata("id")===sal("id"),"Inner").where(sal("sal")>=3000).show()

   /*  csvdata.join(sal,csvdata("mgrid")===sal("id")).groupBy(csvdata("mgrid")).agg(sum("sal").alias("sum of empl"))
       .select(csvdata("id"),csvdata("name")).show()      */ // Group by not working

   val gb =  csvdata.join(sal,csvdata("mgrid")===sal("id")).groupBy(csvdata("mgrid")).agg(sum("sal").alias("SUM"))


   csvdata.join(gb,csvdata("id")===gb("mgrid"),"inner").select(csvdata("name"),gb("SUM")).show()
    // Not working from different output



  }

}
