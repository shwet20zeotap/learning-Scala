object classes
{
  //creating a custom DS with class
  //scala keeps the names of types and values in different namespaces
  //so there's no conflict between the 2 definitions of Rational

  class Rational(x:Int,y:Int)
  {
    def numer = x
    def denom = y
  }

  // new object -> new Rational(1,2)


}