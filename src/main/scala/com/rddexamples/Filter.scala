package com.rddexamples

import org.apache.spark.{SparkConf, SparkContext}

object Filter {

  def main(args:Array[String]): Unit ={

    val conf = new SparkConf()
    conf.setMaster("local")
    conf.setAppName("First Application")
    val sc = new SparkContext()

    val rdd1 = sc.parallelize(Array("a","b","c"))
    val rdd2 = rdd1.map(z=>(z,1))
    println(rdd1.collect().mkString(","))
    println(rdd2.collect().mkString(","))

    val rdd3 = sc.parallelize(Array(40,35,61,20,28,17,76))
    val rdd4 = rdd3.filter(z =>z%2 == 0)
    println(rdd3.collect().mkString(","))
    println(rdd4.collect().mkString(","))

   /* val rdd1 = sc.parallelize(Array(33,22,43,56,23,98,10))
    val rdd2 = rdd1.filter(z=>(z%2 ==0))
    println(rdd1.collect().mkString(","))
    println(rdd2.collect().mkString(","))*/

  }

}
