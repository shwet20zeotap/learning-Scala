object collec
{
  val nums = Vector(1,2,3,-4)
  //we can perform all the same functions on vectors as on lists
  //except cons, for that we have

  val x = 9
  x +: nums // creates a list with leading element as x, followed by all the elements of nums
  nums :+ x // creates a list with trailing element as x, preceded by all elements of xs

  //vectors are immutable

  //base class of List and Vector is Seq, the class of all sequences

  //Seq class itself is a subclass of Iterable

  val xs:Array[Int] = Array(1,2,3)
  xs map(x=>2*x)

  val ys:String ="Hello World"
  ys.filter(_.isUpper)

  val r:Range = 1 until 5 //1,2,3,4
  val s:Range = 1 to 5 //1,2,3,4,5

  ys.exists(c => c.isUpper)
  ys.forall(c => c.isUpper)

  val pairs = List(1,2,3) zip ys
  pairs.unzip

  ys flatMap(c => List('.',c))

  xs.sum
  xs.max

  val n1 = List(1,2,3,4,5,6,7)
  val n2 = List("a","b","c","d","e","f","g")

  n1 flatMap(x => n2 map (y=>(x,y)))

  //scalar product

  def scalarProduct(xs:Vector[Double], ys:Vector[Double]):Double =
    (xs zip ys).map(xy => xy._1*xy._2).sum


  /*pattern matching function way

  def scalarProduct(xs:Vector[Double], ys:Vector[Double]):Double =
  (xs zip ys).map(case (x,y) => x*y).sum
  */

  def isPrime(n:Int):Boolean = (2 until n).forall(d => n%d!=0)

  isPrime(13)

  












}
