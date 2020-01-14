package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2 // an EXPRESSION
  println(x)

  println(2 + 3 * 4)
  // math operators + - * / & | ^ << >> >>> (right shift with zero extension)

  // bool operators == <= >= > < !=
  // logical operators ! && ||

  var myVar = 2
  myVar += 3 // also -= *= /= %=

  // Instruction vs Expression
  /*
  Instruction -> Tell the computer to do something

  Expression -> Has a value and/or a type
   */

  // if expression (not control flow, but a value)
  // evaluates to a value, does not control a program flow

  val aCond = true
  val aCondVal = if (aCond) 5 else 3 // like a ternary expression (python)
  println(aCondVal)

  // DONT USE LOOPS
  // Indicative of imperative code, whereas Scala encourages functional code
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  val aWeirdValue = (myVar = 3)
  print(aWeirdValue) // Will be a Unit -> ()

  // while loop is actually an expression returning Unit

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }

  // CodeBlocks are expressions, whose type is the type of their last expression

  // val anotherValue = z + 1 // Will not compile bc 'z' is scoped to the aCodeBlock val

  // 1. difference between "hello world" vs println("hello world") ->
      // types are different. String vs Unit. Unit has a side-effect of printing
  // 2. what is the value of...

  val someValue = {
    2 < 3
  } // Boolean

  val someOtherValue = {
    if (someValue) 239 else 986
    42
  } // 42, not 239 or 986, bc 42 is the value of the last expression in the code block. The if expression is irrelevant
}
