package lectures.part2oop

object Objects extends App {

  // Scala object is a Singleton Instance
  // COMPANION object
  object Person { // type + only instance
    // "static" level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    def from(mom: Person, dad: Person) = new Person("Bobbie") // factory method
    def apply(mom: Person, dad: Person) = new Person("Bobbie") // use apply to mock a constructor
  }

  class Person(val name: String) {
    // instance level functionality
  }

  println(Person.N_EYES)
  println(Person.canFly)

  val mary = Person
  val john = Person
  println(mary == john) // true, actually point to the same Person instance

  val p1 = new Person("Mary")
  val p2 = new Person("John")
  println(p1 == p2) // false, `new` instantiates

  println(Person(p1, p2).name) // calls companion object's apply()

  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit <- must have this signature
  // This can replace `extends App`

}
