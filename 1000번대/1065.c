#pragma warning(disable:4996)

#include<stdio.h>

int han(int num);

int main() {

	int num;
	int j = 0;
	int before, after;
	int count = 0;

	scanf("%d", &num);

	for (int i = 1; i <= num; i++) {
		j = i;
		while (j>99) {
			before=han(j);
			j = j / 10;
			if (j > 0) {
				after = han(j);
				if (before != after) {
					count++;
					break;
				}
			}
			else {
				break;
			}
		}
	}

	printf("%d", num - count);
	return 0;
}

int han(int num) {
	int d =0;

	int temp1 = 0;
	int temp2 = 0;

	temp1 = num % 10;
	num = num / 10;
	temp2 = num % 10;
	d = temp2 - temp1;
	
	return d;
}