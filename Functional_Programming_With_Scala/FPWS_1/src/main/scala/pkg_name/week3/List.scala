package week3

import java.util.NoSuchElementException


trait List[T]
{
  def isEmpty: Boolean
  def head : T
  def tail : List[T]

}
//adding val makes it also a field of the class
class Cons[T](val head:T ,val tail:List[T]) extends List[T]
{
  def isEmpty = false
}

class Nil[T] extends List[T]
{
  def isEmpty:Boolean = true
  def head:Nothing = throw new NoSuchElementException("Nil Head")
  def tail:Nothing= throw new NoSuchElementException("Nil Head")
}




//def singleton[T](elem:T) = new Cons[T](elem,new Nil[T])
//we can then write
// singleton[Int](1) or singleton[Boolean](true)
//like classes functions can have type parameters

