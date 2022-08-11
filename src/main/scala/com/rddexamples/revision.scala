package com.rddexamples
import org.apache.spark.{SparkConf, SparkContext}

object revision {

  def main(args:Array[String]): Unit={

    val conf = new SparkConf()
    conf.setMaster("local")
    conf.setAppName("Test APP")

    val sc = new SparkContext(conf)
    val rdd1 = sc.parallelize(Array(2,3,6,7,9))
    /*val rdd2 = rdd1.map(a => (a*a))
    println(rdd2.collect().mkString(","))*/

    /*val rdd2 = rdd1.flatMap(n => Array(n*2,n+2))
    println(rdd2.collect().mkString(","))*/

    /*val rdd3 = rdd1.filter( z =>(z%2!=0))
    println(rdd3.collect().mkString(","))*/

    //Declare a list in scala
   // val df = sc.parallelize(Array(2,3,5))
    val df = List(2,3,6)
    val z = df.map(a => (a*3))
   // println(z.collect().mkString(","))
    println(z)






  }

}
