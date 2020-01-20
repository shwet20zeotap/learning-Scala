import week3._

object exercise3
{
  @scala.annotation.tailrec
  def nth[T](n:Int, xs:List[T]): Unit =
  {
    if(xs.isEmpty) throw new IndexOutOfBoundsException
    if(n==0) xs.head
    else nth(n-1,xs.tail)
  }

  val list = new Cons(1,new Cons(2,new Cons(3,new Nil)))
  nth(2,list)
  nth(-8,list)
}