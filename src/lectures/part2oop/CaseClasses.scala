package lectures.part2oop

object CaseClasses extends App {
  /*
      equals, hashCode, toString
   */

  // Case Classes create a lot of defaults for us

  case class Person(name: String, age: Int)

  // This does several things
  val jim = new Person("Jim", 43)

  // 1. class params are promoted to fields (no val needed)
  println(jim.name)

  // 2. A sensible toString
  println(jim)

  // 3. equals and hashcode implemented out of the box (memberwise equality)
  val jim2 = new Person("Jim", 43)
  println(jim == jim2)

  // 4. Default copy methods

  val jimJr = jim.copy(age = 3)
  println(jimJr)

  // 5. Default companion objects
  val thePerson = Person
  val mary = Person("Mary", 23) // uses Person object's apply() method

  // 6. Serializable (great for network models... Akka)

  // 7. Extractor Patterns = can be used in pattern matching!!:):)

  case object UnitedKingdom { // does not get a companion object bc it is already an object
    def name: String = "The UK of GB and NI"
  }
}
