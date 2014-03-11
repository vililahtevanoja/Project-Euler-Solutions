/** 
  * Problem 5 - Smallest multiple
  * 
  * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
  * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
  *
  * Author: Vili Lähtevänoja
  */

#include <stdio.h>

bool isDivisibleBy1to20(long long num);

void main(void) {
	long long num = 1;
	while (!isDivisibleBy1to20(++num));
	printf("Result: %lld", num);
	getchar();
}

bool isDivisibleBy1to20(long long num) {
	for (int i = 1; i <= 20; i++) {
		if (num % i > 0)
			return false;
	}
	return true;
}