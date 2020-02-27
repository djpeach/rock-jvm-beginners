trait MyList {
  val head: Int
  val tail: MyList
  val isEmpty: Boolean
  def add(el: Int): MyList

  protected def printElements: String
  override def toString: String = s"[ $printElements ]"
}

object Empty extends MyList {
  val head = throw new NoSuchElementException("Head of empty list")
  val tail = throw new NoSuchElementException("Tail of empty list")
  val isEmpty = true

  def add(el: Int) = new Cons(el)

  protected def printElements = ""
}

class Cons(h: Int, t: MyList = Empty) extends MyList {
  val head = h
  val tail = t
  val isEmpty = false

  def add(el: Int) = new Cons(el, this)

  protected def printElements =
    if (!tail.isEmpty) s"$head, ${tail.printElements}"
    else s"$head"
}