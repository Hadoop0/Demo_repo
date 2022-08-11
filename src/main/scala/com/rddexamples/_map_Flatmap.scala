package com.rddexamples
import org.apache.spark.{SparkContext,SparkConf}
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession



object _map_Flatmap {

  def main(args: Array[String]): Unit = {

     val spark = SparkSession.builder().appName("mapflat").master("local[3]").getOrCreate()

    val j = spark.sparkContext.textFile("D:\\Learnings\\Bigdata_Classes\\readfiles\\countryzip.txt")
    // j.foreach(println)
   //j.flatMap(i => i.split(",")).map(z => (z,1)).reduceByKey(_+_).collect().foreach(println)

    //p.flatMap(a => a.split(" ")).map(a => (a, 1)).reduceByKey(_ + _).filter(_._2 > 10).foreach(println)

   /*
   Two underscores in '_._2' are different.
First '_' is for placeholder of anonymous function; Second '_2' is member of case class Tuple.
Something like:
case class Tuple3 (_1: T1, _2: T2, _3: T3) {...}
    */

  //j.flatMap(i => i.split(",")).map(z => (z,1)).reduceByKey(_ + _).filter(_._2 > 3) .foreach(println)

   //Other way with out using _ .
  // j.flatMap(i => i.split(",")).map(z => (z,1)).reduceByKey((a,b) => a+b).filter{case (a,b)  => b>3}.foreach(println)

    // Below two are used to read length of each word in a file and give out put as (word_name, length_number)
 val count = j.flatMap(i => i.split(",")).map(y => y -> y.length).collect().foreach(println)
  //  val co = j.flatMap(_.split(",")).map(y => y -> y.length).collect().foreach(println)


  //j.collect().foreach(println)


  }

}
