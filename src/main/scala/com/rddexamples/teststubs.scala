package com.rddexamples

import org.apache.spark.{SparkConf, SparkContext}

object teststubs {

  def main (args:Array[String]): Unit ={

    val conf = new SparkConf()
    conf.setMaster("local")
    conf.setAppName("Application")

    val sc = new SparkContext(conf)
    val rdd1 = sc.parallelize(Array("a","b","c"))
    val rdd2 = rdd1.map(z=>(z,4))
    println(rdd2.collect().mkString(","))

    //filter

    val rdd3= sc.parallelize(Array(22,33,12,43,32))
    val rdd4 = rdd3.filter(z=>(z%2!=0))
    println(rdd4.collect().mkString(","))

    //flatmap
    val rdd5 = rdd3.flatMap(n=> Array(n,n*2,n+2))
    println(rdd5.collect().mkString(","))

  //Groupby
    val rddx1 = sc.parallelize(Array("Apple","Orange","Banana","Owl","Onion","Anjer"))
    val grpby1 = rddx1.groupBy(n=>n.charAt(1))
    println(grpby1.collect().mkString(","))

    //GroupbyKey
    val xk = sc.parallelize(Array(('B',5),('B',4),('A',3),('A',2),('A','1')))
    val xy = xk.groupByKey()
    println(xy.collect().mkString(","))

    //MapPartitions:-
    val xm = sc.parallelize(Array(1,2,3,4),2)
    def f(i:Iterator[Int]) = {(i.sum,"sum").productIterator}
    val ym = xm.mapPartitions(f)
    val xOut = xm.collect()
    val yout = ym.collect()
  }
}
