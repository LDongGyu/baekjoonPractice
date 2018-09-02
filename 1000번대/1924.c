#include<stdio.h>

int main() {

	int x,y;
	int count = 0;
	int day = 0;

	scanf_s("%d %d", &x, &y);

	for (int i = 1; i < x; i++) {
		if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 | i == 10 || i == 12) {
			count += 31;
		}
		else if (i == 4 || i == 6 || i == 9 || i == 11) {
			count += 30;
		}
		else {
			count += 28;
		}
	}

	count += y;
	day = count % 7;
	
	switch (day) {
	case 1:
		printf("MON");
		break;
	case 2:
		printf("TUE");
		break;
	case 3:
		printf("WED");
		break;
	case 4:
		printf("THU");
		break;
	case 5:
		printf("FRI");
		break;
	case 6:
		printf("SAT");
		break;
	case 0:
		printf("SUN");
		break;
	default:
		printf("error");
		break;

	}
	return 0;
}