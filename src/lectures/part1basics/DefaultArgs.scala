package lectures.part1basics

object DefaultArgs extends App {

  @scala.annotation.tailrec
  def trFact(n: Int, acc: Int = 1): Int = // instead of creating helper func, we just pass a default arg to acc param
    if (n <= 1) acc
    else trFact(n-1, n*acc)

  // This will not stop the dev from passing in what they want, they can pass in a value to override the default

  def savePicture(format: String = "jpg", width: Int, height: Int): Unit = println("saving picture")
  // default args should come last, or all other params need to be named

  // savePicture(1920, 1080) // Will fail bc the compiler thinks we are trying to override format
  savePicture(height = 1080, width = 1920) // naming allows us to pass in any order DO THIS ALWAYS
}
