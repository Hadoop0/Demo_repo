package com.rddexamples

import scala.collection.immutable._


object _List {

  def main(args: Array[String]): Unit = {

    val name1: List[Int] = List(1, 3, 4, 5, 9, 10)
    var name2 = List("Pradeep", "Ravi", "Rakesh", "Suresh")

    println("List1 :")
    println(name1)

    //Display using loop for list2
    println("List 2 :")
    /* for(mylist <- name2){
      println(mylist)
       }*/

      /** To get head of the list <list.head> **/
      println("Head of the list "+name2.head)

    /** To get tail of the list <list.tail> **/
      println("tail of the list"+name2.tail)

    /** To get boolean value of the list <list.isEmpty> **/
      println("List is empty --> "+name2.isEmpty)

    /** To fill number of time with given value of the list <list.reverse> **/
      println("fill number of time is with "+ List.fill(3)(name2))
    /** To reverse the List */
      println("Reverse string -->"+ name2.reverse)

    //****  ARRAY *********////////////////////////////

    var mylist = Array(1.2,2.2,3,4.5,66,8,9.5)
    for( j <- mylist){
     // println(j)
    }
    /** sum all array elements */
    var total = 0.0

    /*for (x <- mylist){
      total += x
    }
    println(total)*/

    for (x <- 0 to (mylist.length-1)){
    // println(mylist(x))
      //total += mylist(x)
      total += mylist(x)
    }
    println("Sum of array is " + total)

    /* find largest element */
    var max = mylist(0)

     for (x <- 1 to (mylist.length-1)) {
              if (mylist(x) > max)
                  max = mylist(x)
    }
       println("MAX NUmber --> "+max)
    import Array._

    /** Creating Array  with range*/
    var myList1 = range(10,20,2)
    var myList2 = range (5,10)

    for ( x <-myList1){
      println(" "+x)
    }
  println()
    for(x <- myList2){
      println(" "+x)
    }
 ////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////
    /** Return type */
  add(3,4)

  }
  def add( a:Int, b:Int): Int={
    var sum = a + b
    println("add function "+sum)
    sum
  }


}
