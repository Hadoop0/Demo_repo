package com.rddexamples

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.{SparkSession, functions}
import org.apache.spark.sql.functions.{col, lit, row_number, _}
import org.apache.spark.storage.StorageLevel
import org.apache.spark.sql.expressions
import shapeless.syntax.std.tuple.unitTupleOps
import org.apache.spark.sql.expressions.WindowSpec
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.RelationalGroupedDataset



object Interview {

  def main (args:Array[String]) : Unit={

    val spark = SparkSession.builder().appName("Dlake1").master("local[2]").getOrCreate()
    //val spark =  SparkSession.builder().appName("sample").master("local[1]").getOrCreate()
    //val data = spark.read.textFile("D:\\Learnings\\Bigdata_Classes\\readfiles\\countryzip.txt")
    val data2 = spark.read.csv("D:\\Learnings\\Bigdata_Classes\\readfiles\\countryzip.txt")

    val csv1 = spark.read.format("csv").option("header","true").load("D:\\Learnings\\Bigdata_Classes\\readfiles\\countryzip.txt")
    //csv1.show()

    //csv1.select("no","country").where("no=1").show()
    //csv1.select("city","zip","country").filter(col("country")==="US").show()
    import spark.implicits._
    //csv1.select("city","zip").filter($"country"==="US").show()
    //csv1.select("city","zip").where(col("country")==="US").show()
    //csv1.select("no","city").filter($"country"==="US").sort(desc("no")).show()

    //csv1.filter(col("no")<50).withColumn("ID",lit(50)).show()
    //csv1.select("country","city").filter(col("no")>9).withColumn("ID010",lit(col("zip"))).show()
    //csv1.withColumnRenamed("no","ID").select("ID","city").show()
   // csv1.agg(max("no")>60000).select("no","city").show()
   //csv1.select("no","country").withColumn("I-ID",col("no")+1).show
   // val z = csv1.select("zip","city","no").withColumnRenamed("no","SNO").filter(col("zip")<1000).show()

  //csv1.sort("no").show()
  //csv1.orderBy("no").show(3)
    // csv1.select("country","no").orderBy("no").show(4)
    //csv1.sort(desc("no")).show(8)

    val csv_con = spark.read.format("csv").option("header","true").load("D:\\Learnings\\Bigdata_Classes\\readfiles\\continent.csv")
     // csv_con.show()
      //csv_con.groupBy(col("continent"))
      //csv_con.select(col("population")).show()
      //  csv_con.groupBy(col("continent")).agg(sum(col("population"))).show()
    //csv_con.agg(max(col("population")).alias("maxi")).show( )
    //csv_con.filter(col("continent")==="Asia").agg((max(col("population"))).alias("maxii")).show()

    val coll = List(1,2,4,6,1,11,4)




  }

}
