/// Problem 5 - Smallest multiple
/// 
/// 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
///
/// What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
#time
let divisibleBy x n = (x % n) = 0
let divisibleByRange x i j = [i .. j] |> List.forall(fun n -> divisibleBy x n)
let infiniteSequence = Seq.initInfinite (fun index -> if (index > 0) then index*2 else 1)
let res = infiniteSequence |> Seq.find(fun x -> divisibleByRange x 1 20)
printfn "%i" res
#time
