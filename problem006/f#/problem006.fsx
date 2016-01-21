/// Problem 6 - Sum square difference
///
///The sum of the squares of the first ten natural numbers is,
/// 1^2 + 2^2 + ... + 10^2 = 385
///
/// The square of the sum of the first ten natural numbers is,
/// (1 + 2 + ... + 10)^2 = 55^2 = 3025
///
/// Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is
/// 3025 − 385 = 2640.
///
/// Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the
/// sum

#time
let sumOfSquares = [for i in 1 .. 100 -> i*i] |> List.sum
let squareOfSums = float ([1 .. 100] |> List.sum) ** 2.0 |> int
printfn "%i sum of squares" sumOfSquares
printfn "%i square of sums" squareOfSums
printfn "%i - %i = %i" squareOfSums sumOfSquares (squareOfSums - sumOfSquares)
#time
