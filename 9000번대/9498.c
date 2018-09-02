#pragma warning(disable:4996)

#include<stdio.h>

int main() {

	int testcase;
	scanf("%d", &testcase);

	if (testcase >= 90 && testcase <= 100) {
		printf("A");
	}
	else if (testcase >= 80 && testcase <= 89) {
		printf("B");
	}
	else if (testcase >= 70 && testcase <= 79) {
		printf("C");
	}
	else if (testcase >= 60 && testcase <= 69) {
		printf("D");
	}
	else {
		printf("F");
	}

	return 0;
}