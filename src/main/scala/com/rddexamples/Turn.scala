package com.rddexamples

class Kgf {

  var i = 10
  var j = 20
  var q = i + j

  def add(): Unit = {
    println("KFG --> " + q)
    // Mixed Identifier
    var num_+ = 20;
    println("Mixed Identifier num_+ --> " + num_+)
  }
  def _wloop(): Unit ={

    var x = 5
    while(x<=4){
      println("val of x --> "+x)
      x = x + 1
    }
  }
  def _dowhile(): Unit ={
    var i = 8
    do{
      println(i+ " In boundary")
     i = i-1
    }
    while(i>0);
    {
      println(i +" val of i is beyond boundary")
    }
  }

  def _floop(): Unit = {
    //FOR Loop
    var y = 0
    for (y <- 0 to 7) {
      println(y + "val of Y")
    }
  }

  def _nestedloop(): Unit ={

    var a = 5
    var b = 0

    while( a < 7){
      b = 0
      while(b < 7){
        println("val of a -->" +a ,"val of b is --> " +b)
        b = b+1
      }
      println("-----------")
      a = a+1
      println("val of a Become"+a)
    }

  }
}

object Turn {

  def main(args: Array[String]): Unit = {
    val ob = new Kgf()
    //ob.add()
    //ob._wloop()
    // ob._dowhile()
     //ob._floop()
      //ob._nestedloop()

// ******  Tuples ************************//

    var name = (15, "rajesh" ,true)
    /*println(name._1)
    println(name._2)
    println(name._3)*/

    //pattern match of tuples
   /* var (a,b,c) = (100,"Kumar",false)
    println(a)
    println(b)
    println(c)*/

    /**Iterating over tuples*/

   //name.productIterator.foreach{i=>println(i)}
    //name.productIterator.foreach(i=>println(i))

    /***converting tuple to string*/
    //println(name.toString())

    /*** swap tuple*/
    val name1 = ("Foreverhit","KGF")
    println(name1.swap)


  }
}
