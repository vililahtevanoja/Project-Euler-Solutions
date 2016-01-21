// Problem 16 - Power digit sum
//
// 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
// What is the sum of the digits of the number 2^1000?

object problem016 {
  def sumOfDigits(n: BigInt): BigInt = {
    n
      .toString
      .toCharArray
      .map(c => c - '0')
      .sum
  } 
  def solve = sumOfDigits(BigInt(2).pow(1000))
}
