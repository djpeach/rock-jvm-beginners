package lectures.part2oop

object Exceptions extends App {
  val x: String = null
//  println(x.length) // throws exception NullPtrException

//  val thrower: Nothing = throw new NullPointerException // throws exception NullPtrException manually
//  val thrower2: String = throw new NullPointerException // throws exception NullPtrException manually

  // exceptions are classes and come from Java
  // throwable classes extend from the Throwable Class
  // Exception and Error are the major Throwable subtype

  // Exception - something went wrong with program (null ptr, etc)
  // Error - something went wrong with system (stack overflow, etc)

  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No Int for you!")
    else 42

  val potentialFail: AnyVal = try { // is an AnyVal bc we do not know the final resolved value of the blocks
    println(getInt(true))
  } catch {
    case e: NullPointerException => println(s"caught NullPointer Exception: ${e.getLocalizedMessage}")
    // would crash w/o matching exception
    case e: RuntimeException => println(s"caught Runtime Exception: ${e.getLocalizedMessage}")
  } finally {
    println("did it work?")
  }

  class MyException extends Exception

  val exception = new MyException

//  throw exception // will throw our own custom exception
}
