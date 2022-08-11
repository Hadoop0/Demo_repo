package com.rddexamples

import org.apache.spark.sql.{SparkSession, functions}
import org.apache.spark.sql.functions.{col, lit}
import org.apache.spark.sql.functions._
import org.apache.spark.storage.StorageLevel
import org.apache.spark.sql.expressions
import org.apache.spark.sql.functions.row_number



object Parquetclass {

  def main (args: Array[String]): Unit={

  // val spark =  SparkSession.Builder().appName("sample").master("Local[2]").getOrCreate()

    val spark =  SparkSession.builder().appName("sample").master("local[1]").getOrCreate()

  val data = spark.read.parquet("D:\\Learnings\\Bigdata_Classes\\readfiles\\read_parquet")
  //data.select("id","first_name").where("id=1").show()
 data.show(50)
  //data.select("id","first_name","gender").filter(col("country")==="China").show()
    import spark.implicits._
    //data.select("id","first_name","gender").filter($"country" ==="China").show()
    //data.select("id","first_name").where("id=1").show()
   //data.select("id","gender").filter($"country"==="China" and $"gender"==="Male").sort(desc("id")).show

    //data.filter(col("id")===1).withColumn("ID1",lit(100)).show()
    //data.select("id").filter(col("id")=== 1).withColumnRenamed("id","SNO").show()
  //data.agg(max("registration_dttm")).show()
    //data.show()
    val o = data.select("id","first_name","last_name","email").withColumnRenamed("id","SNO")
     // .withColumn("NextID",col("SNO")+1)
    //o.select("SNO","NextID","first_name").show()


    //Joins
    //select * from sales a join service b on (a.id = b.id)
    spark.conf.set("spark.sql.autoBroadcastJoinThreshold", -1)
    data.join(o,data("id")===o("SNO")).select(o("last_name"),data("first_name")).show()
    //data.join(o,data("id")===o("SNO"),"left").select(o("last_name"),data("first_name")).show()
    //data.join(o,data("id")===o("SNO"),"right").select(o("last_name"),data("first_name")).show()
   // data.join(o,data("id")===o("SNO"),"full").select(o("last_name"),data("first_name")).show()
  //data.withColumn("NewCol",when(col("id")>100,"Morethan100").otherwise("lessthan100")).sort(desc("id")).show
    o.cache().collect()
    //o.persist()

  /* CASE WHEN THEN
      data.withColumn("NewCol",when(col("id")<=100,"Lessthn 100")
      .when(col("id")>=101 && col("id")<200,"Val btw 101 and 200" )
      .otherwise("val more thn 201"))
      //.where("id>100")
      .filter(col("id")===1).show()
      //.sort(desc("id")).show */

    //select sum(salary) from emp;
  // data.agg(max(col("salary")).alias("Max_Sal")).show()
    //select country,max(salary) as maxsal from emp where id>100 group by country;
    //data.groupBy("country").agg(max("salary").alias("maxsal")).sort(desc("maxsal")).show()
    //data.groupBy("country").agg(max("salary")).where("id>100")
/*
   //val csvdata = spark.read.format("csv").option("header",true).load("D:\\Learnings\\Bigdata_Classes\\readfiles\\test.txt")
    //val csvdata = spark.read.option("header",true).csv("D:\\Learnings\\Bigdata_Classes\\readfiles\\test.txt")
   //csvdata.show()
    //val j = csvdata
    //csvdata.join(j,csvdata("id")===j("mgrid"),"left").select(csvdata("id"),j("name")).show()  --> not working
*/
    val sal = spark.read.format("csv").option("header",true).load("D:\\Learnings\\Bigdata_Classes\\readfiles\\Salary.txt")
   // sal.show()
   sal.agg(max(col("sal")).alias("maxi")).show( )
    //sal.agg(max("sal")).where("country=Ind").show()
    //sal.groupBy("country").agg(max("sal")).show()
    //sal.groupBy("country").agg(max("sal")).where("country===Ind").show()   --> not working
    //sal.groupBy("country").agg(max("sal")).filter(col("country")==="Ind").show()

    //val lines = io.Source.stdin.getLines
   // data.show()
   // data.groupBy("country").agg(max("salary")).filter(col("country")==="Canada").show()



    val scanner = new java.util.Scanner(System.in)
    print("Where do you live? ")

    val input = scanner.nextLine()
    //print(s"I see that you live in $input")




  }

}
