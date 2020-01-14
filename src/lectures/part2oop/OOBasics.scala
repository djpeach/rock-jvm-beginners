package lectures.part2oop

object OOBasics extends App {

  val person = new Person("Dan", 23)
  println(person)
  // println(person.name) // will fail bc name is a constructor parameter, not a class member
  println(person.age) // will compile bc age is a constructor param AND a class member bc of the val keyword
  println(person.score)
  person.greet("Rachel")
  person.greet()
}

class Person(name: String, val age: Int) {
  val score = 13

  def greet(name: String) = println(s"${this.name} says Hi, $name")

  def greet() = println(s"$name says Hi!") // implicitly refers to ${this.name}
}
