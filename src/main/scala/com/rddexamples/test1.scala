package com.rddexamples

import scala.util.matching.Regex
import org.apache.spark.{SparkConf, SparkContext}

object test1 {

  def main(args:Array[String]): Unit ={

    val conf = new SparkConf()
    conf.setMaster("local")
    conf.setAppName("First Application")

    val sc = new SparkContext(conf)

    val pattern = new Regex("(S|s)cala")
    val str = "Scala string"
    println((pattern findAllIn str).mkString(","))

    //Coleaces :

    //val xc = sc.parallelize(Array(1,2,3,4,5,6,7,8,9,10),4)
    val xc = sc.parallelize(Array(1,2,3,44,1,2,3,9,10),4)
    val yc = xc.coalesce(2)

    val zc = xc.collect()
    // val ac = yc.glom().collect()

    println(zc.mkString(" ,"))
    println(xc.getNumPartitions)
    println(yc.getNumPartitions)

    //  println(ac.mkString(" ,"))

  }

}
