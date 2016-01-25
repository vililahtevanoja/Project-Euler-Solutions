///
/// Problem 3 - Largest prime factor
/// 
/// The prime factors of 13195 are 5, 7, 13 and 29.
/// What is the largest prime factor of the number 600851475143 ?
///
/// Author: Vili Lähtevänoja
///
/// Slow way of doing prime factorization, should implement proper algorithm?

let isPrime (n : bigint) =
    if (n % bigint(2) = bigint(0)) then
        false
    else
        seq { bigint(3) .. bigint(sqrt(float n)) }
        |> Seq.exists (fun x -> if (n % x = bigint(0)) then true else false)
        |> not

let rec gcd x y =
     if y = 0 then
        x
     else
        gcd y (x % y)

let problem003 = 
    let isDividor (i : bigint) (n : bigint) = 
        if (i % n = bigint(0)) then true else false

    let calculatePrimeFactors (n : bigint) =
        [bigint(2) .. bigint(sqrt (float n))]
        |> List.filter (fun x -> (isPrime x) && (isDividor n x) ) 

    let calculateLargestPrimeFactor (n : bigint) =
        calculatePrimeFactors n
        |> List.max
    calculateLargestPrimeFactor (bigint(600851475143UL))