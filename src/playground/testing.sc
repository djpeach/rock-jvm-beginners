class Person
trait CanWalk

class Dan extends CanWalk with Person

val e: String = throw new RuntimeException