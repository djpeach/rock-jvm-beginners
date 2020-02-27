package lectures.part2oop

import playground.{Cinderella, PrinceCharming}
// can also import playground._
// can also import playground.{Cinderella => Princess} (helpful with versioning of same classes)

object PackagingAndImports extends App {

  // can access classes in same package
  val writer = new Writer("Dan", "Peach", 2018)

  // importing or using fully-qualified-name (FQN)
  val princess = new Cinderella
  val another = new playground.Cinderella

  // packages in hierarchy
  // matching folder structure

  // package objects (Scala) -> Global stuff
  sayHi
  println(SPEED_OF_LIGHT)

  // imports
  val prince = new PrinceCharming

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, math., etc
  // scala.Predef - Nothing (???)



}
