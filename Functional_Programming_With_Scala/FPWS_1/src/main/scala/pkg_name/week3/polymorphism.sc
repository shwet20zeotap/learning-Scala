object polymorphism{
  /*cons-lists
  a fundamental DS in many FL is the immutable
  linked list
  it is constructed with two building blocks
  1. Nil the empty list
  2. cons a cell contaning an element and the remainder of the list
  trait IntList
  class Cons(val head :T, val tail:IntList) extends IntList
  class Nil extends IntList

   */



  //we can generalize using a type parameter T
  // e.g val head :T, or val tail:List[T]

  trait List[T]
  class Cons[T](val head :T, val tail:List[T]) extends List[T]
  class Nil[T] extends List[T]

  //type parameters are written in square brackets





}