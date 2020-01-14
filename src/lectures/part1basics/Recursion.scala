package lectures.part1basics

object Recursion extends App {

  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n - 1) // creates call stack frame to store computation until recursive call returns
  }

  // This can crash if the stack space runs out of memory. To avoid this, use tail, recursion
  // In tail recursion, we pass the state to the function itself so that a callstack frame does not need to be stored.

  def factorialV2(n: Int): Int = {

    @scala.annotation.tailrec // makes sure your function is actually tail recursive
    def factHelper(x: Int, acc: Int):Int = {
      if (x <= 1) acc
      else factHelper(x-1, acc * x) // This instantly computes and passes the state to the recursive call
    }

    // A new call stack frame does not need to be created and stored!

    factHelper(n, 1)
  }


  /*
  1. String concat n times with tail recursion
  2. isPrime that is tailRec
  3. fibonacci that is tailRec

  ALL RECURSIVE FUNCTIONS CAN BE TAIL RECURSIVE
   */

  def concatString(s: String, n: Int): String = {

    @scala.annotation.tailrec
    def helper(x: Int, sAcc: String): String =
      if (n <= 0) sAcc
      else helper(x - 1, sAcc + s)

    helper(n, "")
  }

  def isPrime(n: Int): Boolean = {

    @scala.annotation.tailrec
    def helper(x: Int): Boolean =
      if (x <= 1) true
      else if (n % x == 0) false
      else helper(x-1)

    helper(scala.math.sqrt(n).toInt)
  }

  println(isPrime(2003))
  println(isPrime(629))

  def fibonacci(n: Int): Int = {

    @scala.annotation.tailrec
    def helper(x: Int, acc1: Int, acc2: Int): Int = {
      if (x >= n) acc1
      else helper(x+1, acc1 + acc2, acc1)
    }

    helper(1, 1, 0)
  }

  println(fibonacci(10))

}
