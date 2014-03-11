/** Problem 1 - Divisibles of 3 and 5
  *
  * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
  * Find the sum of all the multiples of 3 or 5 below 1000.
  *
  * Author: Vili Lähtevänoja
  */

#include <stdio.h>
#define DIVISIBLE_BY_3_OR_5(X) ((X % 3 == 0) || (X % 5 ==0))

int main(void) {
	long sum = 0;
	int i;
	for (i = 1; i < 1000; i++) {
		if (DIVISIBLE_BY_3_OR_5(i))
			sum += i;
	}
	printf("Sum of all the multiples of 3 or 5 below 1000: %ld\n", sum);
	getchar();
}