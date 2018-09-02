#include<stdio.h>

int main() {

	int a;
	scanf_s("%d", &a);

	for (int i = a; i >= 1; i--) {

		for (int j = 0; j < a - i; j++) {
			printf(" ");
		}
		for (int j = i; j > 0; j--) {
			printf("*");
		}
		printf("\n");
	}
	return 0;
}