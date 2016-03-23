/// Problem 9 - Pythagorean triplet
/// 
/// Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
/// a2 + b2 = c2
/// For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
/// 
/// There exists exactly one Pythagorean triplet for which a + b + c = 1000.
/// Find the product abc.
#time
let isPythTripl x y z = (x*x + y*y) = z*z

let aseq = seq {1 .. 998}
let bseq = seq {1 .. 998}
let cseq = seq {1 .. 998}

let resa, resb, resc =
    aseq
    |> Seq.iter ( fun a -> bseq
        |> Seq.iter ( fun b -> cseq
            |> Seq.iter ( fun c -> if (a + b + c =  1000 & isPythTripl a b c) return (a, b, c))))
let res = resa*resb*resc
#time
printfn "%s" res
