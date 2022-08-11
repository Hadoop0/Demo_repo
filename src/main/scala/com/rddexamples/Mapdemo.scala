package com.rddexamples

import org.apache.spark.{SparkConf, SparkContext}


object Mapdemo
{

  def main(args:Array[String]): Unit = {

    val conf = new SparkConf()
    conf.setMaster("local")      // yarn or Mesos
    conf.setAppName("First Application")


    //map
    val sc = new SparkContext(conf)  // Driver code is sparkcontext
    val rdd1 = sc.parallelize(Array("a","b","c"))
    val rdd2 = rdd1.map(z=>(z,1))
    println(rdd1.collect().mkString(","))
    println(rdd2.collect().mkString(","))

    //filter
    val rdd3 = sc.parallelize(Array(33,22,43,56,23,98,10))
  val rdd4 = rdd3.filter(z=>(z%2 ==0))
  println(rdd3.collect().mkString(","))
  println(rdd4.collect().mkString(","))

    //flatmap
   val rdd5 = sc.parallelize(Array(1,3,4,8,99,201))
    val rdd6 = rdd5.flatMap(n=> Array(n*2,n+1)).collect().mkString(",")
    println(rdd6)

    //Groupby
    val x = sc.parallelize(Array("Banana","Apple","Orange","ORLS","Boost"))
    val y = x.groupBy(n=> n.charAt(0))
    println(y.collect().mkString(","))

    //GroupbyKey
    val kx = sc.parallelize(Array(('B',5),('B',4),('A',1),('A',2),('A',1)))
    val yk = kx.groupByKey()
    println(yk.collect().mkString(","))



    //MapPartitions:- issue
    val xm = sc.parallelize(Array(1,2,3,4),2)
    def f(i:Iterator[Int]) = {(i.sum,"sum").productIterator}
    val ym = xm.mapPartitions(f)
    val xOut = xm.collect()
    val yout = ym.collect()


// union
    val xJ = sc.parallelize(Array(("a",1),("b",2),("c",3)))
    val yj = sc.parallelize(Array(("a",3),("a",4),("b",5)))
    val zJ = xJ.join(yj)

    println(zJ.collect().mkString(","))

    //Reducekey -- issue with +
   //val rdd15 = Array("one,1","two,1","three,1","two,1","three,1","two,1")
  //  val rdd15 = Array("one","two","three","two","three","two","one")
   //val wordpairrdd = sc.parallelize(rdd15).map(rdd15 => (rdd15,1))   =  (one,1)
//,("two",1) ,()  val countwithreduce = wordpairrdd.reduceByKey(_+_)
  // println(countwithreduce.collect().mkString(","))

//join

    val h = sc.parallelize(Array(("a",1),("b",2),("c",3)))
    val i = sc.parallelize(Array(("a",2),("b",3),("c",4)))
    val zi = h.join(i)
    val xi = h.leftOuterJoin(i)
    //println(zi.collect().mkString(","))
    println(zi.collect().mkString(","))



  }

}
