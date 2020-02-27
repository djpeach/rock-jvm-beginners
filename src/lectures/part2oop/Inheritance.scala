package lectures.part2oop

object Inheritance extends App {

  class Animal {
    val creatureType = "wild creature"
    final def method = println("doing stuff") // cannot be overridden (final)
    def eat = println("nom nom nom")
    private def eat2 = println("nom nom nom") // not accessible by subclasses
    protected def eat3 = println("nom nom nom") // accessible by subclasses but not other objects and classes
  }

  // Single class inheritance
  class Cat extends Animal {
    def crunch = {
      eat3
      println("crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  class Person(name: String, age: Int)
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age) // pass in params the super class has

  sealed class Dog extends Animal { // Can be extended in this file, but not in other files
    override val creatureType: String = "domestic"
    override def eat3: Unit = {
      super.eat3 // calling super class method
      println("crunch, crunch")
    } // override and remove protected modifier
  }

  final class Duck(override val creatureType: String) extends Animal { // Cannot extend class Duck (final)
    override def eat3: Unit = println("Quack, nom nom")
  }

  val dog = new Dog
  dog.eat3
  println(dog.creatureType)

  val duck = new Duck("water fowl")
  println(duck.creatureType)

  val unknownAnimal: Animal = new Duck("water fowl")
  duck.eat3 // polymorphism
}
