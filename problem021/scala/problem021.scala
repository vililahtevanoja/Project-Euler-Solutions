// Problem 21 - Amicable numbers
// 
// Let d(n) be defined as the sum of proper divisors of n (numbers less than
// n which divide evenly into n).
// If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair
// and each of a and b are called amicable numbers.
// 
// For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22,
// 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1,
// 2, 4, 71 and 142; so d(284) = 220.
// 
// Evaluate the sum of all the amicable numbers under 10000.

object problem021 {
  def getProperDivisors(n: Long): List[Long] = {
    List.range(1L, math.sqrt(n).ceil.toLong)
      .foldLeft(List[Long]()) {case (ls, x) =>
        ((n % x == 0), (n / x > 0)) match {
          case (true, true) => if (n / x != n) ls :+ x :+ (n / x) else ls :+ x
          case (true, false) => if (x != n) ls :+ x else ls
          case (false, _) => ls
        }
      }
      .sorted
      .distinct
  }
  
  def hasAmicableNumber(n: Int): Boolean = {
    val nDivisorsSum = getProperDivisors(n).sum
    (nDivisorsSum == n) match {
      case true => false
      case false  => {
        val amicableCandidate = getProperDivisors(nDivisorsSum).sum
        amicableCandidate == n
      }
    }
  }

  def solve =
    List.range(1, 9999)
    .filter(hasAmicableNumber(_))
    .sum
}
