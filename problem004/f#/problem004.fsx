/// Problem 4 - Largest Palindrome Product
/// A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers 
/// is 9009 = 91 × 99.
///
/// Find the largest palindrome made from the product of two 3-digit numbers.

#time
let isPalindrome x  =
    let xStr = string x
    let xRevStr = (new string(xStr.ToCharArray() |> Array.rev))
    xStr.Equals(xRevStr) 

let problem004 =
    let productList = [ for a in 100 .. 999 do
                            for b in 100 .. 999 do
                                yield a*b
                      ]
    List.fold (fun biggest n -> match ((isPalindrome n) && (n > biggest)) with
                                      | true -> n
                                      | false -> biggest) 0 productList

printfn "%i" problem004
#time
