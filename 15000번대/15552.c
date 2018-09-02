#pragma warning(disable:4996)

#include<stdio.h>
#include<stdlib.h>

int main() {

	int testcase;
	int a, b;
	scanf("%d", &testcase);

	for (int i = 0; i < testcase; i++) {
		scanf("%d %d", &a, &b);
		printf("%d\n", a + b);
	}

	return 0;
}