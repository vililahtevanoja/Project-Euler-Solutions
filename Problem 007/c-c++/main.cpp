/** Problem 7 - 10001st prime
*
  * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
  *
  * What is the 10 001st prime number?
  *
  * Author: Vili Lähtevänoja
  */

#include <stdio.h>
#include <math.h>

bool isPrime(long long num);

void main(void) {
	int n = 10001;
	int primesFound = 0;
	long long numToCheck = 1;

	while (primesFound < n) {
		numToCheck++;
		if (isPrime(numToCheck))
			primesFound++;
	}
	printf("Result: %lld", numToCheck);
	getchar();
}

bool isPrime(long long num) {
	for (long long i = 2; i <= fabs(sqrt((double)num)); i++) {
		if (num % i == 0)
			return false;
	}
	return true;
}
