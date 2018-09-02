#pragma warning(disable:4996)

#include<stdio.h>

int main() {

	int a, b, c;
	scanf("%d %d %d", &a, &b, &c);

	if (a > b) {
		if (a > c) {
			if (b > c) {
				printf("%d", b);
			}
			else {
				printf("%d", c);
			}
		}
		else {
			printf("%d", a);
		}
	}
	else { // b>a
		if (a > c) {
			printf("%d", a);
		}
		else {
			if (b > c) {
				printf("%d", c);
			}
			else {
				printf("%d", b);
			}
		}
	}

	return 0;
}