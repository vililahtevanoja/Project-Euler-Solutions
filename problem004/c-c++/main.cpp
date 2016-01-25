/** 
  * Problem 4 - Largest palindrome product
  *
  * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
  *
  * Find the largest palindrome made from the product of two 3-digit numbers.
  *
  *Author: Vili Lähtevänoja
  */

bool isPalindrome(long long num);

#include <stdio.h>
#include <string.h>

void main(void) {
	long biggestPalindrome = 0;
	int i,
		j,
		factor1,
		factor2;
    for (i = 999; i >= 100; i--) {
		for (j = 999; j >= 100; j--) {
			if (isPalindrome(i*j) && (i*j > biggestPalindrome)) {
				biggestPalindrome = (long)i*j;
				factor1 = i;
				factor2 = j;
			}
		}
	}
	printf("Largest palindrome made from the product of two 3-digit numbers: %d * %d = %ld", factor1 , factor2, biggestPalindrome);
	getchar();
}

bool isPalindrome(long long num) {
	char numStr[32];
	char* leftSide;
	char* rightSide;
	int steps = 0;

	_snprintf_s(numStr, 32, "%lld", num);

	int numLen = strlen(numStr);

	if (numLen % 2 > 1) {
		int centerIndex = ((numLen - 1)  / 2) - 1; 
		leftSide = numStr + centerIndex - 1;
		rightSide = numStr + centerIndex + 1;
		steps = (numLen - 1) / 2;
	}
	else {
		leftSide = numStr + ((numLen / 2) - 1);
		rightSide = numStr + (numLen / 2);
		steps = numLen / 2;
	}

	for (int i = 0; i < steps; i++) {
		if (*leftSide != *rightSide)
			return false;
		leftSide--;
		rightSide++;
	}
	return true;
}