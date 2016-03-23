///
/// Problem 10 - Summation of primes
///
/// The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
///
/// Find the sum of all the primes below two million.
///
/// Author: Vili Lähtevänoja

#time
let rec primeSeq =
    let isPrime n =
        let sqrtn = float >> sqrt >> int
        primeSeq
            |> Seq.takeWhile (fun x -> x <= (sqrtn n))
            |> Seq.exists (fun x -> n % x = 0)
        |> not

    let rec calcPrimeSeq current =
        seq {
            if isPrime current then
                yield current
            yield! calcPrimeSeq (current + 2)
        }
    seq {
        yield 2
        yield! calcPrimeSeq 3
    } |> Seq.cache

let primes = primeSeq |> Seq.takeWhile (fun n -> n < 2000000)
let primesSum = primes |> Seq.map (fun x -> bigint(x)) |> Seq.fold (fun acc n -> acc+n) (bigint(0))
#time
printfn "%s" (string(primesSum))
