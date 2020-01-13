object higherorderfunctions
{
  // normal function
  /*

  def sumInts(a:Int, b:Int):Int =
    if(a>b) 0 else a+ sumInts(a+1,b)

  def cube(a:Int):Int =
    a*a*a

  def sumCubes(a:Int, b:Int):Int =
    if(a>b) 0 else cube(a) + sumCubes(a+1,b)

  */
  /// now we write a higher order function
  // which means we pass a function as a parameter ( or return a function)


  def cube(a:Int):Int =
    a*a*a

  def id(a:Int):Int =
    a

  def fact(n:Int):Int =
    if(n==0)1 else fact(n-1)

  def sum(f:Int => Int, a:Int,b:Int):Int =
    if(a>b)
      0
    else f(a) + sum(f,a+1,b) // her cube(a) can be replaced by a placeholder f(a) which signifies any function e.g.
  // square, squareroot,etc

  // this is a higher order function since f here is a parameter


  def sumInts(a:Int,b:Int)  = sum(id,a,b)
  def sumCubes(a:Int,b:Int) = sum(cube,a,b)
  def sumFactorial(a:Int,b:Int) = sum(fact,a,b)


  // using anonymous functions takes away the pain of defining small functions

  def sumInts1(a:Int, b:Int) = sum(x=>x*x*x,a,b)
  sumInts1(1,3)

}