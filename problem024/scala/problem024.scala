// Problem 024 - Lexicographic permutations
// 
// A permutation is an ordered arrangement of objects. For example, 3124 is
// one possible permutation of the digits 1, 2, 3 and 4. If all of the
// permutations are listed numerically or alphabetically, we call it 
// lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
// 
// 012   021   102   120   201   210
// 
// What is the millionth lexicographic permutation of the digits 0, 1, 2, 3,
// 4, 5, 6, 7, 8 and 9?
import scala.annotation.tailrec

object problem024 {
  def factorial(n: Int): Long = {
    @tailrec def inner(n: Int, res: Long): Long = {
      n match {
        case 1L => res
        case _ => inner(n-1, n*res)
      }
    }
    inner(n, 1L)
  }

  def solve = { 
    val arr = Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    val n = arr.length
    val wantedPermutation = 999999
    (1 until 10)
      .foldLeft((List.range(0, 10), List[Int](), wantedPermutation)) {
        case ((numbers: List[Int], ls: List[Int], remain: Int), i: Int) =>
          remain match {
            case 0 => (numbers, ls, remain)
            case _ => {
              val fact = factorial(n-i).toInt
              println(s"Remaining numbers: ${numbers}\nCurrent progress: ${ls}\nFactorial: ${fact}\nRemain: ${remain}")
              (numbers.zipWithIndex.filterNot(_._2==(remain / fact)).map(_._1),
                ls :+ numbers((remain/fact)),
                (remain % fact))
            }
          }
        }._2.mkString("")
  }
  def test = Array(0, 1, 2)
    .permutations
    .toList
    .map(_.mkString(""))
    .sorted
}
