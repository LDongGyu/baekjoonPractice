#pragma warning(disable:4996)

#include<stdio.h>

int main() {

	int origin_num;
	int new_num = 0;
	int count = 0;

	scanf("%d", &origin_num);

	new_num = origin_num % 10 * 10 + (origin_num / 10 + origin_num % 10)%10;
	if (new_num == origin_num) {
		printf("1");
	}
	else {
		count++;
		while (origin_num != new_num) {
			if (new_num < 10) {
				new_num = new_num % 10 * 10 + (new_num / 10 + new_num % 10) % 10;
			}
			else {
				new_num = new_num % 10 * 10 + (new_num / 10 + new_num % 10) % 10;
			}
			count++;
		}
		printf("%d", count);
	}
	
	return 0;
}
/*
int num = 0;

scanf("%d", &num);

if (num == 92 || num == 21 || num == 13 || num == 34 || num == 47 || num == 71 || num == 18 || num == 89 || num == 97 || num == 76 || num == 63 || num == 39) {
printf("12");
}
else if (num == 26 || num == 68 || num == 84 || num == 42) {
printf("4");
}
else if (num == 5 || num == 55 || num == 50) {
printf("3");
}
else if (num==66||num==62 || num == 28 || num == 80 || num == 8 || num == 88 || num == 86 || num == 64 || num == 40 || num == 4 || num == 44 || num == 48 || num == 82 || num == 20 || num == 2 || num == 22 || num == 24 || num == 46 || num == 60 || num == 6) {
printf("20");
}
else if (num == 0) {
printf("1");
}
else{
printf("60");
}
*/