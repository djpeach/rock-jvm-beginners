package lectures.part2oop

object MethodNotations extends App {

  // infix notation

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // infix / operator notation, works with methods w/one param

  val tom = new Person("Tom", "Fight Club")
  println(mary hangOutWith tom) // hangOutWith acts like a operator
  println(mary + tom) // can actually define and use an operator
  println(mary.+(tom))
  println(1.+(2)) // same as 1 + 2
  println(!mary) // same as mary.unary_!

  // --- prefix notation

  val x = -1 // same as 1.unary_-
  // prefix only works with - + ~ !

  // postfix notation
  println(mary isAlive) // paramaterless method
  println(mary()) // same as mary.apply()

  println((mary + "the Rockstar")())
  println(+mary.age)
  println(mary learnsScala)
  println(mary(5))

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! :String = name.reverse
    def isAlive = true
    def apply(): String = s"${name} loves to watch ${favoriteMovie}"
    def +(str: String) = new Person(s"${name} ${str}", favoriteMovie)
    def unary_+ = new Person(name, favoriteMovie, age + 1)
    def learns(str: String) = s"${name} learns ${str}"
    def learnsScala = learns("Scala")
    def apply(n: Int) = s"${name} watched ${favoriteMovie} ${n} times"
  }

  /*
      - Overload + operator
      mary + "the rockstar" => new Person("Mary the rockstar")
      - Add age and + prefix method to increment age
      - learns method that takes String => "${name} learns ${str}"
        - learnsScala method that calls learns with "Scala", use in postfix notation
      - Overload apply() to receive number and return "${name} watched "${movie} ${n} times"
   */
}