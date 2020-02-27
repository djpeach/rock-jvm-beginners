package exercises

class Node(val value: Int, val next: Option[Node])

class MyOwnList(val head: Option[Node] = None, val tail: Option[Node] = None) {
/*
  Singly-linked list
  head = first element of list
  tail = remainder of list
  isEmpty = is this list empty
  add(int) => new list with element added
  toString() => string representation of list.
 */

  val isEmpty = head match {
    case Some(x) => false
    case _ => true
  }

  def add(el: Int): MyOwnList = {
    new MyOwnList(Some(new Node(el, head)))
  }

  override def toString: String = {
    def helper(curNode: Option[Node], str: String = "["): String = curNode match {
      case Some(node) => {
        helper(head.get.next, str + s"${node.value}, ")
      }
      case None => {
        if (str.length > 1) {
          str.take(str.length - 2) + "]"
        } else {
          str + "]"
        }
      }
    }

    helper(head)
  }
}

object Driver extends App {
  val l1 = new MyOwnList
  println(l1)
  val l2 = l1.add(2)
  val l3 = l2.add(2)
  println(l3)
}

abstract class MyList[+A]{
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: MyTransformer[A, B]): MyList[B]
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]
  def ++[B >: A](list: MyList[B]): MyList[B]
}

object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException
  override def tail: MyList[Nothing] = throw new NoSuchElementException
  override def isEmpty: Boolean = true
  override def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  override def printElements: String = ""

  override def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
  override def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
  override def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty
  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h
  override def tail: MyList[A] = t
  override def isEmpty: Boolean = false
  override def add[B >: A](element: B): MyList[B] = new Cons(element, this)
  override def printElements: String =
    if (t.isEmpty) "" + h
    else h + ", " + t.printElements

  override def filter(predicate: MyPredicate[A]): MyList[A] = {
    if (predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  override def map[B](transformer: MyTransformer[A, B]): MyList[B] = {
    new Cons(transformer.transform(h), t.map(transformer))
  }

  override def ++[B >: A](list: MyList[B]): MyList[B] = {
    new Cons(h, t ++ list)
  }

  override def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] = {
    transformer.transform(h) ++ t.flatMap(transformer)
  }
}

trait MyPredicate[-T] {
  def test(elem: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(elem: A): B
}

object ListTest extends App {
//  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
//  println(list.tail.tail.head)
//  println(list.add(4).head)
//  println(list.isEmpty)
//  println(list)

  val listOfInts: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))

  println(listOfInts.toString)
  println(listOfStrings.toString)
}
