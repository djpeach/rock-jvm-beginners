package lectures.part1basics

import sun.jvm.hotspot.runtime.PerfMemory.PerfDataEntryVisitor

object StringOps extends App {

  val str: String = "Hello I am learning Scala"

  println(str.charAt(1)) // e
  println(str.substring(7, 11)) // I am
  println(str.split(" ").toList) // Seq("Hello", "I", "am", "learning", "Scala")
  println(str.startsWith("Hello")) // true
  println(str.replace(" ", "-")) // Hello-I-am-learning-Scala
  println(str.toLowerCase()) // hello i am learning scala
  println(str.toUpperCase()) // HELLO I AM LEARNING SCALA
  println(str.length()) // 25
  println("45".toInt) // Int -> 45
  println('a' +: str :+ 'z') // aHello I am learning Scalaz
  println(str.reverse) // alacS gninrael ma I olleH
  println(str.take(2)) // He

  val name = "David"
  val age = 12
  val greeting = s"Hello, I am $name, and I am $age years old" // s-interpolated string
  val greeting2 = s"Hello, I am $name, and I will be turning ${age + 1} years old" // (can evaluate expressions)

  println(greeting)
  println(greeting2)

  val price = 1.2f
  val cashierPrompt = f"That will be $$$price%2.2f" // f-interpolated string (formatting)
  // -> They can check for type correctness (eg, %d for int, etc)

  println(cashierPrompt)

  println(raw"This is a \n newline") // This is a \n newline
  val escaped = "This is a \n newline"
  println(raw"$escaped") // This is a
                            // newline

}
