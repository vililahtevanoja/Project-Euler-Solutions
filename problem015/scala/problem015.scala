// Problem 015 - Lattice paths
// Starting in the top left corner of a 2×2 grid, and only being able to
// move to the right and down, there are exactly 6 routes to the bottom
// right corner.
//
// How many such routes are there through a 20×20 grid?
import scala.annotation.tailrec

object problem015 {
  def factorial(n: Int): BigInt = n match {
      case 1L => BigInt(1)
      case _ => BigInt(n) * factorial(n-1)
  }

  def nChooseK(n: Int, k: Int): BigInt = {
    factorial(n) / (factorial(k) * (factorial(n - k)))
  }

  def calculateNumberOfLatticePathsRecursive(x: Int, y: Int): BigInt = {
    val xEnd = x 
    val yEnd = y
    def isFinish(xPos: Int, yPos: Int): Boolean =
      ((xPos == xEnd), (yPos == yEnd)) == (true, true)
    def inner(xPos: Int, yPos: Int): BigInt = {
      (xPos < xEnd, yPos < yEnd) match {
        case (false, false) => if (isFinish(xPos, yPos))
          BigInt(1) else BigInt(0)
        case (true, false) => inner(xPos + 1, yPos)
        case (false, true) => inner(xPos, yPos + 1)
        case (true, true) => inner(xPos+1, yPos) + inner(xPos, yPos+1)
      }
    }
    inner(0, 0)
  }
  def solveRec = calculateNumberOfLatticePaths(20, 20)
  def solveSimpleRec = calculateNumberOfLatticePaths(2,2)
  
  def calculateNumberOfLatticePathsDynamic(x: Int, y: Int): BigInt = {
    val xEnd = x
    val yEnd = y
    def isFinish(xPos: Int, yPos: Int): Boolean =
      ((xPos == xEnd), (yPos == yEnd)) == (true, true)
    def isInside(xPos: Int, yPos: Int): Boolean =
      ((xPos < xEnd), (yPos < yEnd)) == (true, true)
    val arr = Array
      .ofDim[Int](x, y)
      .map(_.map(_ => 1))
    def generateIndices(n: Int): List[(Int, Int)] = {
    
    }  
    def inner(n: Int, M: Array[Array[Int]]): Array[Array[Int]] = {
       
    }
  }

  def solveDynamic = calculateNumberOfLatticePathsDynamic(20,20)
  def solveSimpleDynamic = calculateNumberOfLatticePathsDynamic(2,2)
}
