package com.rddexamples

import org.apache.spark.{SparkConf, SparkContext}
object RDDDemo1 {
  def main(args:Array[String]): Unit ={

    val conf = new SparkConf()
    conf.setMaster("local")
    conf.setAppName("First Application")

    val sc = new SparkContext(conf)
    val rdd1 = sc.parallelize(Array("a","b","h","e","t"))
    val rdd2 = rdd1.map(z=>(z,1))
    println(rdd1.collect().mkString(" , "))
    println(rdd2.collect().mkString(" , "))
  }

}
