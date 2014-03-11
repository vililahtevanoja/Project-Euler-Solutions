/**
  * Problem 3 - Largest prime factor
  * 
  * The prime factors of 13195 are 5, 7, 13 and 29.
  * What is the largest prime factor of the number 600851475143 ?
  *
  * Author: Vili Lähtevänoja
  *
  * The solution finds the answer fast, but doesn't really FINISH with the answer in a reasonable time,
  * need to improve perhaps.
  **/

#include <stdio.h>

bool isPrime(long long num);

#define NUM 600851475143

int main(void) {
	long long i = 3;
	long long largestPrime = 0;
	printf("Prime factors: ");
	do {
		if ((NUM % i == 0) && isPrime(i)) {
			largestPrime = i;
			printf("%lld, ", largestPrime);
		}
		i += 2;
	} while (i <= NUM / 2);
	printf("Result: %lld\n", largestPrime);
	getchar();
}

bool isPrime(long long num) {
	for (long long i = 2; i < (num / 2); i++) {
		if (num % i == 0)
			return false;
	}
	return true;
}

