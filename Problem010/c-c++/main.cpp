/** 
  * Problem 10 - Summation of primes
  * 
  * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
  * 
  * Find the sum of all the primes below two million.
  *
  * Author: Vili Lähtevänoja
  */

#include <stdio.h>
#include <math.h>

#define LIMIT 2000000

bool isPrime(long long num);

void main(void) {
	long long sum = 2;
	for (int i = 3; i <= LIMIT; i += 2) {
		if (isPrime(i))
			sum += i;
	}
	printf("Result: %lld\n", sum);
	getchar();
}

bool isPrime(long long num) {
	for (long long i = 2; i <= fabs(sqrt((double)num)); i++) {
		if (num % i == 0)
			return false;
	}
	return true;
}