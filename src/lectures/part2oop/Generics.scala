//package lectures.part2oop
//
//object Generics extends App {
//  class MyList[A] {
//
//  }
//
//  object MyList { // objects cannot be parameterized
//    def empty[A]: MyList[A] = new MyList[A]
//  }
//
//  class MyMap[K, V]
//  trait CanFly[T]
//
//  val listOfIntegers = new MyList[Int]
//  val listOfStrings = new MyList[String]
//  val emptyListOfIntegers = MyList.empty[Int]
//
//  // variance problem
//
//  class Animal
//  class Cat extends Animal
//  class Dog extends Animal
//  class Doberman extends Dog
//  class Pitbull extends Dog
//
//  // Does a List[Cat] extend List[Animal] ????
//
//  class CovariantList[+A] // yes (co-variance)
//  val animal: Animal = new Cat // same as ...
//  val animalList: CovariantList[Animal] = new CovariantList[Cat] // co variant list
//
//  // Can I add a new dog to this co-variant list? animalList.add(new Dog) ??? HARD QUESTION
//
//  class InvariantList[A] // no (invariant)
//  //  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat] // Will fail to compile
//  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]
//
//  class Trainer[-A] // hell no! (contra-variant)
//  val trainer: Trainer[Cat] = new Trainer[Animal] // reverses the relationship
//
//  // bounded types
//  // controlling the subclasses and superclasses that can be used with a generic class
//
//  class Cage[A <: Animal](animal: A) // making sure every type A will always be some type of Animal
//  val cage = new Cage(new Dog)
//
//  class CatSizedCage[A >: Cat](animal: A) // Has to be a super type of cat (no subclasses)
//
//  class Car
////  val carCage = new Cage(new Car) // will fail bc a Car is not an Animal
//
//  class MyCoVariantList[-A] {
//    def add[B <: A](element: B): MyCoVariantList[B] = new MyCoVariantList[B]
//  }
//
//  val cats: MyCoVariantList[Cat] = new MyCoVariantList[Animal]
//  val catsAndDogs = cats.add(new Doberman)
//
//  println(catsAndDogs)
//}
