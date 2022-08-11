package com.rddexamples
import org.apache.spark.sql.{SparkSession, functions}
import org.apache.spark.sql.functions.{col, lit}
import org.apache.spark.sql.types._
import org.apache.spark.sql.Row




object _Struct_ {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("Struct_").master("local[*]").getOrCreate()
    val data = spark.read.format("csv").load("D:\\\\Learnings\\\\Bigdata_Classes\\\\readfiles\\\\test.txt")

   // data.show()
    val schema = StructType(
      List(
      StructField("Number_ID",IntegerType,true),
      StructField("Name",StringType,true),
      StructField("Mgr_Id",IntegerType,true)
    )
    )
    println(schema)

   // val rdd1 = spark.sparkContext.parallelize(data)  How to merge schema with a data frame ??
   // val rdd2 = spark.createDataFrame(rdd1,schema)




  }

}
