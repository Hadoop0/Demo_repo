package com.rddexamples

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions
import org.apache.spark.sql.functions.{col, lit, max}
import org.apache.spark.sql.expressions

object _Iterator {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("New world").master("local[2]").getOrCreate()

    //var data = spark.read.format("text").load("D:\\Learnings\\Bigdata_Classes\\readfiles\\Salary.txt")
    var sal = spark.read.format("csv").option("header", true).load("D:\\Learnings\\Bigdata_Classes\\readfiles\\Salary.txt")
    //sal.show()
    // sal.groupBy("grade").agg(max("sal")).show()
    val lst = List(2, 3, 56, 8, 3)
    //val rdd1 = spark.sparkContext.parallelize(lst)
      var max = 0
    for( x <- 0 to lst.length-1){
      //println(x)
        if (lst(x) > max)
          max = lst(x)
   }
    println(max)
    println("Highest number --> "+lst.max)
    println(lst.length)

    /** MAP Key-Value pair */
    var colors = Map(("x",123),("y",112),("z",101))

    println(" keys color "+colors.keys)
    println("values color" + colors.values)
    println("is colors empty "+colors.isEmpty)


  }

}
