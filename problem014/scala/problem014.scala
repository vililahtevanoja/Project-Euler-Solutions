/// Problem 14 - Longest Collatz sequence
///
/// The following iterative sequence is defined for the set of positive integers:
///
///  n → n/2 (n is even)
///  n → 3n + 1 (n is odd)
///
/// Using the rule above and starting with 13, we generate the following sequence:
///
///  13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
/// It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
/// Although it has not been proved yet (Collatz Problem), it is thought that all starting
/// numbers finish at 1.
///
/// Which starting number, under one million, produces the longest chain?
///
/// NOTE: Once the chain starts the terms are allowed to go above one million.

object problem014 {
  def generateCollatzSequence(n: BigInt): Iterator[scala.math.BigInt] = {
    val collatzSequence = Iterator.iterate(n) { case state =>
      (state == BigInt(1)) match {
        case true => (state)
        case false => (state % BigInt(2) == 0) match {
          case true => (state / BigInt(2))
          case false => ((state * BigInt(3)) + 1)
        }
      }
    } takeWhile { case n => n != BigInt(1) }
    collatzSequence ++ Seq(BigInt(1))
  }

  def getCollatzSequenceLength(n: AnyVal): BigInt = {
    generateCollatzSequence(BigInt.apply(n.toString, 10)).length
  
  }
  def solve = (1 until 1000000)
      .map { case x => (x, problem014.getCollatzSequenceLength(x)) }
      .maxBy(_._2)
      ._1
}
