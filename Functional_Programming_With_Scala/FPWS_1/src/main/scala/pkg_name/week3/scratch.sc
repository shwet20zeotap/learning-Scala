import week3.Rational

//import week3._ // imports everything from package week3
//import week3.{Rational,Hello} //multiple classes import

object scratch{
  new Rational(1,9)
  /*
  In java as well as scala , a class can have only one superclass
  so for that we use traits ( like interface in java)

  a trait is declared like an abstract class just with trait
  instead of abstract class
   */
  trait planar
  {
    def height:Int
    def width:Int
    def surface = height*width
  }
  //classes , objects and traits can inherit from
  //at most one class but arbitrary many traits

  //e.g class square extends shape with Planar with Movable
  //planar and movable are traits
  //traits resemble interface but are more powerful since they can have
  //fields and concrete methods

  //traits cannot have value parameters, only classes can

  /*
  the nothing type in class hierarchy is at the bottom,it is a subtype of all other types
  there is no value of type nothing

  USAGE: - to signal abnormal termination
         - as an empty type of empty collections


   SCALA EXCEPTION HANDLING IS THE SAME AS JAVA

   */
  def error (msg:String) = throw new Error(msg)
 // error("ohshitgit")

  /*
  scala.null is a subclass of all the refernce types
  and also used to denote null.
  So if we wanna pass a string, we can also pass a null
  The type of null is Null
   */
  val x =null
  val y:String =x
  //val z:Int =x //not allowed

}