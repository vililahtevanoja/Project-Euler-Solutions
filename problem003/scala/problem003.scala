/**
  * Problem 3 - Largest prime factor
  *
  * The prime factors of 13195 are 5, 7, 13 and 29.
  * What is the largest prime factor of the number 600851475143 ?
  *
  * Author: Vili Lähtevänoja
  **/
import scala.annotation.tailrec

object problem003 {
  def getLargestPrimeFactor(n: Long): Int = {
    @tailrec def inner(start: Int, end: Long): Int = {
      val factor = Stream.from(start).find(end % _ == 0).get
      factor match {
        case `end`  => factor
        case _ => inner(factor + 1, end / factor)
      }
    }
    inner(2, n)
  }
  
  def getPrimeFactors(n: Long): List[Long] = {
    @tailrec def inner(start: Int,
      end: Long, 
      factors: List[Long]): List[Long] = {
      println(s"$start -> $end")
      (end - start) <= 0 match {
        case true => factors
        case false => 
          val factor = Stream.from(start).find(end % _ == 0).get
          factor match {
            case `end` => factors
            case _ => inner(factor + 1, end / factor, factors :+ factor.toLong)
          }
      }
    }
    inner(2, math.round(math.sqrt(n)).toLong, List())
  }
  def solve = println(getLargestPrimeFactor(600851475143L))
}
