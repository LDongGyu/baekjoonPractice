#include<stdio.h>

int main() {

	int a, b;
	double c = 0.0;

	scanf_s("%d %d", &a, &b);

	c = (double)a / (double)b;

	printf("%.32lf", c);
	return 0;
}