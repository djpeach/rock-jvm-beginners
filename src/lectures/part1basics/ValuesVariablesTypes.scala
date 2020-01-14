package lectures.part1basics

object ValuesVariablesTypes extends App {
  val x: Int = 42 // == val x = 42, because the compiler can infer the type.
  println(x)

  // x = 2 WILL NOT COMPILE
  // VALS ARE IMMUTABLE

  // ; are not needed unless two statements are on the same line

  val aBool: Boolean = false // can be true or false
  val aChar: Char = 'a' // single chars in single quotes
  val anInt: Int = x // 4 bytes
  val aShort: Short = 12 // 2 bytes
  val aLong: Long = 13L // 8 bytes, use an L to force the compiler to use 8 bytes
  val aFloat: Float = 2.0f // 4 bytes, use an f to force compiler to use 4 bytes
  val aDouble: Double = 2.0 // 8 bytes

  var myVar: Int = 4 // variables can be reassigned
  myVar = 8
}
