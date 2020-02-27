package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // anonymous class
  val funnyAnimal = new Animal {
    override def eat: Unit = println("munch munch")
  }

  // Compiler will do

  class AnonymousClasses$$anon$1 extends Animal {
    override def eat: Unit = println("munch munch")
  }

  println(funnyAnimal.getClass())
  println(new AnonymousClasses$$anon$1().getClass())

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help?")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println("Hi my name is Jim, how can I be of service")
  }

}
