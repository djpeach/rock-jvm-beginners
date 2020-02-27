package lectures.part2oop

object AbstractDataTypes extends App {
  // abstract classes

  abstract class Animal {
    val creatureType: String // abstract val
    def eat(): Unit // abstract method
  }

  // val animal = new Animal // will fail bc cannot instantiate abstract classes

  class Dog extends Animal {
    override val creatureType: String = "canine"
    override def eat(): Unit = println("crunch crunch")
  }

  trait Coldblooded
  trait Carnivore { // No constructor parameters
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat" // can have implementations
  }

  class Crocodile extends Animal with Carnivore with Coldblooded { // can extend with multiple traits but only 1 class
    override val creatureType: String = "croc"

    override def eat(): Unit = println("nom nom")

    override def eat(animal: Animal): Unit = println(s"I am a $creatureType, and I am eating a ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)
}
