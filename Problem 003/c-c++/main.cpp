/**
  * Problem 3 - Largest prime factor
  * 
  * The prime factors of 13195 are 5, 7, 13 and 29.
  * What is the largest prime factor of the number 600851475143 ?
  *
  * Author: Vili Lähtevänoja
  **/

#include <stdio.h>
#include <math.h>

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
	} while (i <= fabs(sqrt((double)NUM)));
	printf("\nResult: %lld\n", largestPrime);
	getchar();
}

bool isPrime(long long num) {
	for (long long i = 2; i <= fabs(sqrt((double)num)); i++) {
		if (num % i == 0)
			return false;
	}
	return true;
}
