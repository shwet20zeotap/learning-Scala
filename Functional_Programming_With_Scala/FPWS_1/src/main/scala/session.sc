
def sqrt(x: Double):Double = {

  def abs(x: Double) = if (x < 0) -x else x

  def isGoodEnough(guess: Double, x: Double) =
    abs(guess * guess - x) < 0.01

  def improve(guess: Double, x: Double) =
    (guess + x / guess) / 2


  @scala.annotation.tailrec
  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)

  sqrtIter(1.0,x)
}


println(sqrt(2))