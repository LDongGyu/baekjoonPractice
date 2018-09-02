#include<stdio.h>
#include<stdbool.h>

int main() {

	int a, b, c;
	bool corr = false;

	scanf_s("%d", &a);
	
	for (int i = 0; i * 5 <= a; i++) {
		if ((a - (i * 5)) % 3 == 0) {
			b = i;
			corr = true;
		}
	}

	if (corr == false) {
		printf("-1");
	}
	else {
		c = (a - (b * 5)) / 3;
		printf("%d",b+c);
	}
	return 0;
}