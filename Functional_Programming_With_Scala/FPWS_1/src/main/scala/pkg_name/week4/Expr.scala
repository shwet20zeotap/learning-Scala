package week4

import java.lang.Number

trait Expr
case class Number(n:Int) extends Expr
case class Sum(e1:Expr,e2:Expr) extends Expr



