package lectures.part1basics

object Functions extends App {

  def aFunc(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunc("hello", 3)) // "hello 3"

  // Parameterless functions can be called without params

  def noParamsFunc(): Int = 42
  println(noParamsFunc())
  println(noParamsFunc)

  // Loops in functional language (recursion)
  // Compiler can deduce type of functions, but not recursive functions
  // this is due to reduction rules.

  def repeat(s: String, n: Int): String = {
    if (n == 1) s
    else s + repeat(s, n-1)
  }

  println(repeat("hello-", 3)) // "hello-hello-hello-

  def sideEffects(s: String): Unit = {
    println(s)
  }

  def funcWithHelper(n: Int): Int = {
    def helper(a: Int, b: Int):Int = {
      a + b
    }

    helper(n, n-1) // return type of helper is the return type of parent func, so this resolves correctly
  }

  /*
  1. Greeting for kids: (name, age) => "Hi, my name is $name and I am $age years old"
  2. Factorial function 1 * 2 * 3 * ... * n
  3. Fibonacci function
    f(1) = 1
    f(2) = 1
    f(n) = f(n - 1) + f(n - 2)
  4. Tests if number is prime
   */

  def greet(name: String, age: Int) = s"Hi, my name is $name, and I am $age years old"

  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else n * factorial(n - 1)
  }

  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  def isPrime(n: Int): Boolean = {

    @scala.annotation.tailrec
    def helper(x: Int): Boolean = {
      if (x == 1) true
      else if (n % x == 0) false
      else helper(x - 1)
    }

    helper(scala.math.sqrt(n).toInt)
  }

  println(isPrime(7))

}
