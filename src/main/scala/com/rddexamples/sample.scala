package com.rddexamples

import org.apache.spark.sql.SparkSession

import org.apache.spark.storage.StorageLevel
import org.apache.spark.sql.{SparkSession,functions}
import org.apache.spark.sql.functions.{col,lit}
import org.apache.spark.sql.functions._
import org.apache.spark.storage.StorageLevel
import org.apache.spark.sql.expressions
import org.apache.spark.sql.functions.row_number


object sample {


  def main(args: Array[String]):Unit= {
    val l = List(1, 2, 3, 4, 5)
    val s = new SparkSession.Builder().appName("sample").master("local[2]").getOrCreate()

    //val r = s.sparkContext.parallelize(l)
    val p = s.sparkContext.textFile("D:\\Learnings\\Bigdata_Classes\\Hive_oochi.txt")
    val j = s.sparkContext.textFile("D:\\Learnings\\test1.txt")
    val k = s.sparkContext.textFile("D:\\Learnings\\test2.txt")



    //p.foreach(println)
    //println(p.count())
    //p.takeSample(true,3,4).foreach(println)
    //p.take(2).foreach(println)
    //p.takeOrdered(20).foreach(println)
    //p.saveAsTextFile("Downloads\\scalasavefile.txt")  --- Failed
    //p.flatmap(a =>a.split(""))
    //p.filter{case(a,b,c) => b == "Hemanth"}
    //p.flatMap(a => a.split(" "))
    //p.flatMap(a => a.split(" ")).foreach(println)

    //p.flatMap(a => a.split(" ")).map(a => (a, 1)).reduceByKey(_ + _).filter(_._2 > 10).foreach(println)
    p.flatMap(a =>a.split(" ")).map(a =>(a,1))

    //val o = j.union(k).foreach(println)
   //val h = j.intersection(k).foreach(println)
   //j.distinct()
 //val i = p.flatMap(a => a.split(" ")).map(a => (a,1)).reduceByKey((a,b) => a+b).filter{case (a,b) => b>3}.sortByKey()
 //i.coalesce(2).foreach(println)

   val ar = List(1,2,3,4,5,90)
   val r = s.sparkContext.parallelize(ar,1)
   val z = r.repartition(10).foreach(println)
   val zi =  r.map(a => (a,1)).foreach(println)
   // val zx =  r.map(a => (a,1)).reduce(_.1>2)foreach(println)




  }


}
