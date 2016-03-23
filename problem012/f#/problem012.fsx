/// Problem 012 - Highly divisible triangular number
///
/// The sequence of triangle numbers is generated by adding the natural numbers.
/// So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:
/// 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
/// 
/// Let us list the factors of the first seven triangle numbers:
/// 
///  1: 1
///  3: 1,3
///  6: 1,2,3,6
/// 10: 1,2,5,10
/// 15: 1,3,5,15
/// 21: 1,3,7,21
/// 28: 1,2,4,7,14,28
/// We can see that 28 is the first triangle number to have over five divisors.
/// 
/// What is the value of the first triangle number to have over five hundred divisors?
#time
let getDivisors n =
    [1L .. int64(n/2L)]
    |> List.fold (fun acc x -> if(int64(n) % int64(x) = 0L) then acc+1L else acc) 0L
let triangleNumberSeq = Seq.initInfinite ( fun index ->
    [1L .. int64(index)+1L] |> List.sum)
let res = triangleNumberSeq |> Seq.find ( fun n -> (getDivisors (int64(n))) > 500L)
#time
printfn "%s" (string(res))
