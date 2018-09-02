#pragma warning(disable:4996)

#include<stdio.h>

int d(int n);
int arr[10000] = { 0 };

int main() {

	for (int i = 1; i < 10000; i++) {
		d(i);
	}

	for (int i = 0; i < 10000; i++) {
		if (arr[i] != 1) {	
			printf("%d\n", i+1);
		}
	}

	return 0;
}

int d(int n) {
	int next = 0;
	
	if (n > 10000) {
		return 0;
	}

	next += n;
	while (n > 0) {
		next += n % 10;
		n = n / 10;
	}
	arr[next-1] = 1;
	d(next);
}