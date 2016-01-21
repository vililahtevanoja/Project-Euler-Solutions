/// Problem 7 - 10001st prime
///
/// By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
///
/// What is the 10 001st prime number?

#time
let isPrime2 n = [2 .. int (sqrt (float n))] |> List.exists (fun x -> n % x = 0) |> not
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

printfn "%s" (string(primeSeq |> Seq.item(10000)))
#time
