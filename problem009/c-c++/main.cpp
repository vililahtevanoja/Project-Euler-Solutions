/**
  * Problem 9 - Pythagorean triplet
  *
  * Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
  * a2 + b2 = c2
  * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
  *
  * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
  * Find the product abc.
  */

#include <stdio.h>
#include <math.h>

int findProduct();

#define UPPER_LIMIT 998
#define FIRST_HALF_END 499
#define TRIPLET_EQUALS_1000(a, b, c) ((a + b + c) == 1000)
#define IS_PYTHAGOREAN_TRIPLET(a, b, c) (fabs(pow((double)a, 2)) + fabs(pow((double)b, 2)) == fabs(pow((double)c,2)))

void main(void) {
	int result = findProduct();
	printf("Result: %d", result);
	getchar();
}

int findProduct() {
	for (int i = 1; i <= UPPER_LIMIT; i++) {
		for (int j = 1; j <= UPPER_LIMIT; j++) {
			for (int k = 1; k <= UPPER_LIMIT; k++) {
				if (TRIPLET_EQUALS_1000(i, j, k)) {
					if (IS_PYTHAGOREAN_TRIPLET(i, j, k)) {
						printf("%d^2 + %d^2 = %d^2\n", i, j, k);
						return i*j*k;
					}
				}
			}
		}
	}
	return -1;
}