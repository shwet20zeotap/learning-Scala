package week3

class Rational(x: Int, y: Int) {
  require(y!=0,"denominator must be nonzero")
  def this (x:Int) = this(x,1)
  def numer:Int = x
  def denom:Int = y

  @scala.annotation.tailrec
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  def add(that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )
  def toString(enter: Rational): Unit =
    println(enter.numer + "/" + enter.denom)

  def neg: Rational = new Rational(-numer, denom)

  def unary_- :Rational = new Rational(-numer,denom)

  def sub(that: Rational) = add(that.neg)

  def less(that: Rational) = numer * that.denom < that.numer * denom

  def <(that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = if (this.less(that)) that else this

  def max1(that: Rational) = if (this<that) that else this


}