///
/// Problem 3 - Largest prime factor
/// 
/// The prime factors of 13195 are 5, 7, 13 and 29.
/// What is the largest prime factor of the number 600851475143 ?
///
/// Author: Vili Lähtevänoja
///
/// Slow way of doing prime factorization, should implement proper algorithm?

let sqrt2uint64 = float >> sqrt >> uint64

let isPrime n =
    if (n % 2UL = 0UL) then
        false
    else
        seq { 3UL .. sqrt2uint64 n }
        |> Seq.exists (fun x -> if (n % x = 0UL) then true else false)
        |> not

#time;;
let problem003 = 
    let isDividor i n = 
        if (i % n = 0UL) then true else false

    let calculatePrimeFactors (n) =
        [2UL .. sqrt2uint64 n]
        |> List.filter (fun x -> (isPrime x) && (isDividor n x) ) 

    let calculateLargestPrimeFactor n =
        calculatePrimeFactors n
        |> List.max
    let res = calculateLargestPrimeFactor 600851475143UL
    printfn "Result: %i" res
#time;;
