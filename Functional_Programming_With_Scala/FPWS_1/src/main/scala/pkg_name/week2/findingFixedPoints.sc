object findingFixedPoints
{
  val tolerance = 0.0001
  def isCloseEnough(x:Double,y:Double)=
    Math.abs((x-y)/x)/x < tolerance

  def fixedPoint(f:Double=>Double)(firstGuess:Double)=
    {
      @scala.annotation.tailrec
      def iterate(guess:Double):Double = {
        val next = f(guess)
        if(isCloseEnough(guess,next)) next
        else iterate(next)
      }
      iterate(firstGuess)
    }

  fixedPoint(x=>1+x/2)(1)


  //sqrt(x) is the fixed point if a function(y=>x/y)
  //fixed point of a function is the point where f(x) =x

  def averageDamp(f:Double=>Double)(x:Double)
  = ((x+f(x)))/2

  def sqrt(x:Double) =
    fixedPoint(averageDamp(y=>x/y))(1)

  sqrt(2)
}