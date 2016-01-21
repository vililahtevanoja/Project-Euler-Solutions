// Problem 20 - Factorial digit sum
// 
// n! means n × (n − 1) × ... × 3 × 2 × 1
// 
// For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
// and the sum of the digits in the number 10! is
//    3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
// 
// Find the sum of the digits in the number 100!

import scala.annotation.tailrec

object problem020 {
  def factorial(n: Int): BigInt = {
    @tailrec def inner(n: Int, res: BigInt): BigInt = {
      n match {
        case 1 => res
        case _ => inner(n-1, n*res)
      }
    }
    inner(n, BigInt(1))
  }
  def solve =
    factorial(100)
      .toString
      .toCharArray
      .map(c => c - '0')
      .sum
}
