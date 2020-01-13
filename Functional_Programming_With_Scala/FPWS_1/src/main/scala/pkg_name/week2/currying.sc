object currying
{
  // functions returning functions

  def sum(f:Int => Int) : (Int,Int) =>Int =
  {
    def sumF(a:Int,b:Int):Int =
      if(a>b) 0
      else f(a) + sumF(a+1,b)
    sumF
  }
  //sum is a function that returns another function
  // the returned function sumF applies the given function paramter f and sums the results
  def sumInts = sum(x=>x)

  def fact(a:Int):Int =
    if(a==0) 1
    else a* fact(a-1)

  //sumInts(1,4)

  def sumCubes = sum(x=>x*x*x)

  def sumFactorials = sum(fact)

  sumCubes(1,10) + sumFactorials(10,20)
  // sumCubes(1,10) is the same as sum(cube)(1,10)
  sum(x=>x*x*x)(1,10) // sum(x=>x*x*x) returns a function which takes two args

  //syntactic sugar 2 - the definition of functions that return functions is so useful
  //in FP that there is a special syntax for that in scala


  def sum1(f:Double=>Double)(a:Double,b:Double):Double =
    if(a>b)0 else f(a)+sum1(f)(a+1,b)

   //The style of function application where every function is mapped to an expression that
  // consists of nested anonymous functions that each take one parameter is called currying

  //sum1(x=>scala.math.sqrt(x))(4,5)

  def prod(f:Int=>Int)(a:Int,b:Int):Int =
    if(a>b)1 else f(a)*prod(f)(a+1,b)

  //prod(x=>x*x)(1,5)

  //defining factorial in terms of prod function

  def factorial(a:Int):Int =
    {
      prod(x=>x)(1,a)
    }

  //factorial(5)

  def mapReduce(f:Int=>Int, combine:(Int,Int)=> Int,zero:Int)
               (a:Int,b:Int):Int =
    if(a>b)zero
    else combine(f(a),mapReduce(f,combine,zero)(a+1,b))

  //defining product in terms of mapreduce

  def product_new(f:Int=>Int)(a:Int,b:Int):Int  = mapReduce(f,(x,y)=>x*y,1)(a,b)

  def fact1(n:Int) = product_new(x=>x)(1,n)

  fact1(5)
  

}
