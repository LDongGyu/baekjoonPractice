#include<stdio.h>
#include<stdlib.h>

int fibonacci(int n);


int main() {
	int testcase = 0;
	int top = 0;

	int *n;
	int *zero;
	int *one;

	int temp = 0;
	int n_1 = 0;
	int n_2 = 0;

	scanf_s("%d", &testcase);

	n = (int*)malloc(sizeof(int)*testcase);
	one = (int*)malloc(sizeof(int)*testcase);
	zero = (int*)malloc(sizeof(int)*testcase);
	n[top] = 0;

	for (int i = 0; i < testcase; i++) {
		scanf_s("%d", &n[i]);
		if (n[i] > n[top])
			top = i;
	}

	int max = n[top];

	for (int i = 0; i <= max; i++) {
		n_2 = n_1;
		n_1 = temp;

		if (i>2)
			temp = n_1 + n_2;

		if (i == 0) {
			n_2 = 0;
			n_1 = 0;
			for (int j = 0; j < testcase; j++) {
				if (i == n[j]) {
					one[j] = 0;
					zero[j] = 1;
				}
			}
		}
		else if (i == 1) {
			n_1 = 0;
			n_2 = 0;
			temp = 1;
			for (int j = 0; j < testcase; j++) {
				if (i == n[j]) {
					one[j] = 1;
					zero[j] = 0;
				}
			}
		}
		else if (i == 2) {
			n_2 = 0;
			n_1 = 1;
			temp = 1;
			for (int j = 0; j < testcase; j++) {
				if (i == n[j]) {
					one[j] = 1;
					zero[j] = 1;
				}
			}
		}
		else {
			for (int j = 0; j < testcase; j++) {
				if (i == n[j]) {
					one[j] = n_2 + n_1;
					zero[j] = n_1;
				}
			}
		}
	}


	for (int i = 0; i < testcase; i++) {
		printf("%d %d\n", zero[i], one[i]);
	}

	return 0;
}


/*	n[top] = temp;
zero[top] = n_1; */