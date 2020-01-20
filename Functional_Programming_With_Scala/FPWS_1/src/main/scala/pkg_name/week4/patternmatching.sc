import week4._
object patternmatching
{
  //patternmatching is a generalization of switch
  //statement from c/java to class hierarchies

  //variables should start with lowercase
  //constants should start with uppercase
  def show(e:Expr):String = e match{
    case Number(x) => x.toString
    case Sum(l,r)=> show(l)+" + "+show(r)
  }

  show(Sum(Number(1),Number(44)))
}