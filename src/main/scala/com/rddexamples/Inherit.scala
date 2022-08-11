package com.rddexamples

class pets{

  var dog: String = "Labra"
}
class rats{
  var rat: String = "Rathulk"
}
class wild extends pets{

  var total_A : Int = 99

  def count(): Unit ={
    println (" dogs -->"  +dog, "total aninamls"+total_A)
  }
}

object Inherit {

  def main(args: Array[String]): Unit ={
    var ob = new wild()
    ob.count()




  }

}
