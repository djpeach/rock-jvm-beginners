package playground

import java.util.function.Predicate

trait MyPredicate[A] {
  def test(el: A): Boolean
}

trait MyTransformer[A, B] {
  def transform(el: A): B
}

trait MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](el: B): MyList[B]
  def ++: [B >: A] (el: B): MyList[B]

  def printElements: String
  override def toString: String = s"[$printElements]"

  def filter[B >: A](p: MyPredicate[B]): MyList[B]
}

object Empty extends MyList[Nothing] {
  override def head = throw new NoSuchElementException("Head of empty list")
  override def tail = throw new NoSuchElementException("Tail of empty list")
  override def isEmpty = true

  override def add[B >: Nothing](el: B) = new Cons[B](el)
  override def ++: [B >: Nothing](el: B) = new Cons[B](el)

  override def printElements = " Nil "
  override def filter[B >: Nothing](p: MyPredicate[B]): MyList[B] = Empty
}

class Cons[A](h: A, t: MyList[A] = Empty) extends MyList[A] {
  override def head: A = h
  override def tail: MyList[A] = t
  override def isEmpty = false

  override def add[B >: A](el: B) = new Cons[B](el, this)
  override def ++: [B >: A](el: B) = new Cons[B](el, this)

  override def printElements: String =
    if (!tail.isEmpty) s"$head, ${tail.printElements}"
    else s"$head"

  override def filter[B >: A](p: MyPredicate[B]): MyList[B] = {
    println(head)
    if (p.test(head)) head ++: tail.filter(p)
    else tail.filter(p)
  }
}

object Week04 extends App {
  val ints: MyList[Int] = 1 ++: 2 ++: 3 ++: 4 ++: 5 ++: 6 ++: 7 ++: 8 ++: Empty

  println(ints)

  val evens: MyList[Int] = ints.filter(new MyPredicate[Int] {
    override def test(t: Int): Boolean = t % 2 == 0
  })

  println(evens)
}

class Animal
class Cat extends Animal
class Tiger extends Cat
class Dog extends Animal

class Zoo[+T] {
  def add[B >: T](a: B) = new Zoo[T]()
}

object ZooTest extends App {
  val a: Animal = new Cat()
  val z: Zoo[Animal] = new Zoo[Cat]
  z.add(new Dog())
}
