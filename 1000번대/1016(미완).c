#include<stdio.h>

int main() {

	int max, min;
	int count = 0;

	scanf_s("%d %d", &min, &max);

	for (int i = min ; i <= max; i++) {
		for (int j = 2; j*j <= i; j++) {
			if ( i % (j*j) == 0) {
				count++;
			}
		}
	}

	printf("%d", (max-min+1)-count);
	return 0;
}