import  math.Ordering
object lists_ {
  val fruit = List("apples", "oranges", "pears")
  val nums = List(1, 2, 3, 4)
  /*
  Difference between lists and arrays
  1. lists are immutable - the elements of a list cannot be changed
  2. lists are recursive, while arrays are flat
   */
  val diag3 = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
  //like arrays, lists are homogenous

  val fruits: List[String] = List("apples", "oranges", "pears")
  val numss: List[Int] = List(1, 2, 3, 4)
  val diag33: List[List[Int]] = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
  val empty: List[Nothing] = List()
  /*
  all lists are constructed from -
  1. the empty list Nil and
  2. the construction operation :: pronounced cons

  x::xs xs gives a new list with the first element x, followed by the elements of xs

  For example :
  fruit = "apples"::("oranges"::("pears"::Nil))
   */
  val fruit1 = "apples" :: ("oranges" :: ("pears" :: Nil))

  // A::B::C is interpreted as A::(B::C)
  val nums2 = 1 :: 2 :: 3 :: 4 :: 5 :: Nil
  println(nums2)


  //head - the first element of the list
  //tail - the list composed of all the elements except the first
  //isEmpty - 'true' if the list is empty, 'false' otherwise
  fruit1.tail.head

  //1::2::xs //list starting with 1 and then 2 and then some variable xs


  //insertion sort

  def iSort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => insert(y, iSort(ys))
  }

  def insert(x: Int, xs: List[Int]): List[Int] =
    xs match {
      case List() => List(x)
      case y :: ys => if (x <= y) x :: xs else y :: insert(y, xs)
    }

  fruit1.length //gives the length of list
  fruit1.last // the last element of the list, exception if its empty
  fruit1.init // list containing all elements except last , exception if list is empty
  fruit1 take 2 // a list consisting of first 2 elements , the whole list if n>length of list
  fruit1 drop 2 //the rest of the collection after taking 2 elements
  fruit1(2) // the element at index 2 of the list , same as xs apply n


  /*
  creating new lists
   */
  val new_l: List[String] = fruit1 ++ fruits //combine two lists
  fruit1.reverse // reverse a list

  fruit1 updated(2, "Hello") //contains same elements as fruit1 except
  // at index 2 where it contains "hello"
  //not applicable for index greater than length-1

  /*
  Finding elements
   */

  new_l indexOf "apples" //returns index of first element in xs equal to x, or
  //-1 if x does not appear in xs
  new_l contains "apples" // same as xs indexOf x>=0

  def removeAt(n: Int, xs: List[Int]) = (xs take n) ::: (xs drop n + 1)

  /*
  Pairs and Tuples
   */

  def merge1(xs: List[Int], ys: List[Int]): List[Int] =
    xs match {
      case Nil =>
        ys

      case x :: xs1 =>
        ys match {
          case Nil =>
            xs
          case y :: ys1 =>
            if (x < y) x :: merge1(xs1, ys)
            else y :: merge1(xs, ys1)

        }
    }


  // splitAt returns two sublists , the elements up the given index
  //and the elements from that index
  // the lists are returned in a pair

  // a pair in scala in (x,y)
  val pair = ("answer", 42) // the type is String:Int
  val (label, value) = pair
  // can be triplets

  // they can also be written as

  val label1 = pair._1
  val value1 = pair._2


  //making sort more general

  def msort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] =
        (xs, ys) match {
          case (Nil, ys) => ys
          case (xs, Nil) => xs
          case (x :: xs1, y :: ys1) =>
            if (lt(x, y)) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
        }

      val (fst, snd) = xs splitAt n
      merge(msort(fst)(lt), msort(snd)(lt))
    }
  }

  val nums1 = List(2, -4, 5, 7, 1)
  msort(nums1)((x: Int, y: Int) => x < y)
  msort(fruit1)((x: String, y: String) => x.compareTo(y) < 0)

  //there is already a class in the Standard library that represents orderings
  // scala.math.Ordering[T]

  def msort1[T](xs: List[T])(ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] =
        (xs, ys) match {
          case (Nil, ys) => ys
          case (xs, Nil) => xs
          case (x :: xs1, y :: ys1) =>
            if (ord.lt(x, y)) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
        }

      val (fst, snd) = xs splitAt n
      merge(msort1(fst)(ord), msort1(snd)(ord))
    }
  }

  msort1(nums)(Ordering.Int)


  //implicit parameter
  def msort2[T](xs: List[T])(implicit ord: Ordering[T]): List[T] =
  {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] =
        (xs, ys) match {
          case (Nil, ys) => ys
          case (xs, Nil) => xs
          case (x :: xs1, y :: ys1) =>
            if (ord.lt(x, y)) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
        }

      val (fst, snd) = xs splitAt n
      merge(msort2(fst), msort2(snd))
    }
    msort2(nums)
  }


}

