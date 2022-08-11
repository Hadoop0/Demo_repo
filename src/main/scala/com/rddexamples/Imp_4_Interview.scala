package com.rddexamples

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.{SparkSession, functions}
import org.apache.spark.sql.functions.{asc, col, concat, count, countDistinct, current_timestamp, dense_rank, explode, explode_outer, lit, max, row_number, spark_partition_id, split, window}
import org.apache.spark.sql.types._
import org.apache.spark.sql.Row
import org.apache.spark.sql.expressions.WindowSpec
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions
import org.apache.spark.sql.functions.explode
import org.apache.spark.sql.functions.struct

object Imp_4_Interview {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("Interview").master("local[2]").getOrCreate()

   // val sal1 = spark.read.textFile("D:\\Learnings\\Bigdata_Classes\\readfiles\\sal.txt")
    val sal1 =  spark.read.format("csv").option("header",true).load("D:\\Learnings\\Bigdata_Classes\\readfiles\\sal11.txt")
    //sal1.show()
    //sal1.agg(max("sal"))
   // sal1.groupBy("id").agg(max("sal")).sort("sal").show

    /*val json = spark.read.format("json").load("D:\\Learnings\\Bigdata_Classes\\readfiles\\json\\sample2.json")
    json.show()*/

    val ex =  spark.read.format("csv").option("header",true).load("D:\\Learnings\\Bigdata_Classes\\readfiles\\explode.txt")

    //ex.withColumn("new_salary",explode(split(col("sal"),","))).groupBy(col("id")).agg(max(col("new_salary"))).sort("id")

   //val ex2 = ex.withColumn("new_salary",explode(split(col("sal"),","))).select("id","name","new_salary").show

   /*ex.withColumn("new_salary",explode(split(col("sal"),",")))
        .withColumn("rank",dense_rank().over("new_salary").desc()).where(col("rank")===2).show() */


    val dup =  spark.read.format("csv").option("header",true).load("D:\\Learnings\\Bigdata_Classes\\readfiles\\dup.txt")
    //dup.show()
    //dup.dropDuplicates(col("sal")).show
    //dup.drop(col("sal")).show()
    //dup.dropDuplicates().show
   //dup.distinct().select(col("id")).show


    /*  Drop first and sencond name coloums and concatinate*/
     /*val dop =  spark.read.format("csv").option("header",true).load("D:\\Learnings\\Bigdata_Classes\\readfiles\\drop.txt")
        dop.withColumn("Full_Name",concat(col("fn"),lit(" "),col("ln"))).drop("fn","ln")
      .select("id","Full_Name","sn","location").show */


    /* Clumzy data */
    val clu =  spark.read.format("csv").option("header",true).load("D:\\Learnings\\Bigdata_Classes\\readfiles\\clumzy.txt")
    //clu.show()
    //clu.withColumn("newcol",functions.regexp_replace(clu.col("name"), "[^a-zA-Z0-9]", "")).show()

    /* Clumzy data */
  //  clu.withColumn("newcol",functions.regexp_replace(clu.col("name"), "[^a-zA-Z]", "")).show()


    import org.apache.spark.sql.functions._
    var js = spark.read.json("D:\\Learnings\\Bigdata_Classes\\readfiles\\json\\sample2.json")
   //js.withColumn("timestamp",current_timestamp()).show()

    /*val gender = spark.read.format("csv").option("header",true).load("D:\\Learnings\\Bigdata_Classes\\readfiles\\gender.txt")
    StructType(StructField("class",StringType,true),StructField("malecount",IntegerType,true),StructField("femalecount",IntegerType,true))
   gender.printSchema() */

    var blanklines:Int =0
    spark.sparkContext.textFile("D:\\Learnings\\Bigdata_Classes\\readfiles\\json\\sample2.json",4)
      .foreach{  line =>
        if(line.length() ==0) blanklines +=1
      }
    println(s"Blank Lines=$blanklines")
    /// Accumulator
    var blanklines = spark.sparkContext.accumulator()
    spark.sparkContext.textFile("D:\\Learnings\\Bigdata_Classes\\readfiles\\json\\sample2.json",4)
      .foreach{  line =>
        if(line.length() ==0) blanklines +=1
      }
    println(s"Blank Lines=$blanklines")





  }

}
