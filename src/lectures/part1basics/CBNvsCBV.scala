package lectures.part1basics

object CBNvsCBV extends App {

  // Call-by-Name vs Call-by-Value

  def callByValue(x: Long): Unit = {  // CBV evaluates the value when called
    println(s"by value: $x")
    println(s"by value: $x")
  }

  def callByName(x: => Long): Unit = { // CBN evaluates the value every time it is used
    println(s"by name: $x")
    println(s"by name: $x")
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())

  def inifinite(): Int = 1 + inifinite()
  def printFirstOnly(x: Int, y: => Int): Unit = println(x)
  def printSecondOnly(x: Int, y: => Int): Unit = println(y)

  printFirstOnly(34, inifinite()) // will not try to evaluate infinite -> Success
  printSecondOnly(34, inifinite()) // will try to evaluate infinite -> Fail

}
