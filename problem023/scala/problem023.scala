// Problem 23 - Non-abuntant sums
// 
// A perfect number is a number for which the sum of its proper divisors is
// exactly equal to the number. For example, the sum of the proper divisors
// of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect
// number.
// 
// A number n is called deficient if the sum of its proper divisors is less
// than n and it is called abundant if this sum exceeds n.
// 
// As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the
// smallest number that can be written as the sum of two abundant numbers is
// 24. By mathematical analysis, it can be shown that all integers greater
// than 28123 can be written as the sum of two abundant numbers. However,
// this upper limit cannot be reduced any further by analysis even though it
// is known that the greatest number that cannot be expressed as the sum of
// two abundant numbers is less than this limit.
// 
// Find the sum of all the positive integers which cannot be written as the
// sum of two abundant numbers.

object problem023 {
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

  def isAbundantNumber(n: Long): Boolean = {
    getProperDivisors(n).sum > n
  }
  
  val limit = 28123

  def getAbundantListIterator(lower: Long): Iterator[Long] = {
    Iterator.iterate(12L) { case n => 
      var x = n+1L
      while (!isAbundantNumber(x)) {
        x= x + 1L
      }
      x
    }
  }

  def solve = {
    val abundantNumberList = List.range(1, limit).filter(isAbundantNumber(_))
    List.range(1, limit)
      .filter { x =>
        abundantNumberList.find(y => abundantNumberList.contains(x-y)) match {
          case Some(n) => false
          case None => true
        }
      }
      .sum
  }
}
