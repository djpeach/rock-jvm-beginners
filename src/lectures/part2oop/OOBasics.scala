package lectures.part2oop

import java.time.Year

object OOBasics extends App {

  val person = new Person("Dan", 23)
  println(person)
  // println(person.name) // will fail bc name is a constructor parameter, not a class member
  println(person.age) // will compile bc age is a constructor param AND a class member bc of the val keyword
  println(person.score)
  person.greet("Rachel")
  person.greet()

  val counter = new Counter()
  println(counter.inc().currCount)
}

class Person(name: String, val age: Int) {
  val score = 13

  def greet(name: String) = println(s"${this.name} says Hi, $name")

  def greet() = println(s"$name says Hi!") // implicitly refers to ${this.name}
}

/*
Novel and Writer

Writer: first name, last name, year
  - method fullname

Novel: name, year of release, author
  - authorAge
  - isWrittenBy(author)
  - copy (new year of release) => new instance of Novel
 */

/*
Counter Class
  - receive in value
  - currCount
  - increment/decrement Counter => new instance of Counter
  - overload inc/dec to receive an amount
 */

class Writer(firstName: String, lastName: String, val birthYear: Int) {
  def fullName: String = firstName + " " + lastName
}

class Novel(title: String, releaseYear: Int, author: Writer) {
  val authorAge = Year.now.getValue - author.birthYear

  def isWrittenBy(author: Writer) = this.author == author

  def copy(releaseYear: Int) = new Novel(title, releaseYear, author)
}

class Counter(val currCount: Int = 0) {
  def inc(by: Int = 1) = new Counter(currCount+by)
  def dec(by: Int = 1) = new Counter(currCount-by)
}
