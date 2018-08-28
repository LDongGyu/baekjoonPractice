#include<stdio.h>
#include<stdlib.h>
#include<math.h>

int main() {
	int testcase = 0;
	scanf_s("%d", &testcase);

	int *x1, *y1, *r1, *x2, *y2, *r2;
	double d = 0.0;

	x1 = (int *)malloc(sizeof(int)*testcase);
	y1 = (int *)malloc(sizeof(int)*testcase);
	r1 = (int *)malloc(sizeof(int)*testcase);
	x2 = (int *)malloc(sizeof(int)*testcase);
	y2 = (int *)malloc(sizeof(int)*testcase);
	r2 = (int *)malloc(sizeof(int)*testcase);

	for (int i = 0; i < testcase; i++) {
		scanf_s("%d %d %d %d %d %d", &x1[i], &y1[i], &r1[i], &x2[i], &y2[i], &r2[i]);
	}


	for (int i = 0; i < testcase; i++) {
		d = sqrt((x1[i]-x2[i])*(x1[i]-x2[i])+(y1[i]-y2[i])*(y1[i]-y2[i]));

		if (d == 0 && r1[i] != r2[i]) {
			printf("0\n");
		}
		else if ( d == 0 ) {
			printf("-1\n");
		}
		else if ((double)(r1[i] + r2[i]) < d || d < (double)abs(r1[i]-r2[i])) {
			printf("0\n");
		}
		else if ((double)(r1[i]+r2[i]) == d || (double)abs(r1[i]-r2[i]) == d) {
			printf("1\n");
		}
		else if ((double)(r1[i] + r2[i]) > d && (double)abs((r1[i] - r2[i])) < d) {
			printf("2\n");
		}
		else {
			printf("-1\n");
		}
	}
	return 0;
}