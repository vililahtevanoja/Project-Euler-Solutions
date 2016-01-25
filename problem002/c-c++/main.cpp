/** Problem 2 - Even Fibonacci Numbers
  *
  * Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
  * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
  * By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
  *
  * Author: Vili L�htev�noja
  */
#include <stdio.h>

#define IS_EVEN(x) (x % 2 == 0)

void main(void) {
	int term = 2;
	int prevTerm = 1;
	int tempTerm;
	long sumOfEvenTerms = 0;
	while (term <= 4000000) {
		printf("Term: %d\n", term);
		if (IS_EVEN(term)) {
			sumOfEvenTerms += term;
		}
		tempTerm = prevTerm;
		prevTerm = term;
		term = tempTerm + term;
	}
	printf("Sum of the even-valued terms: %ld", sumOfEvenTerms);
	getchar();
}