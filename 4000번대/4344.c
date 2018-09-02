#pragma warning(disable:4996)

#include<stdio.h>

int main() {

	int testcase;
	int *stu_num;
	float *sum = 0;
	int *count = 0;
	float *avg = 0;

	scanf("%d", &testcase);

	int **stu_case = (int**)malloc(sizeof(int*)*testcase);
	stu_num = (int*)malloc(sizeof(int)*testcase);
	avg = (float*)malloc(sizeof(float)*testcase);
	count = (int*)malloc(sizeof(int)*testcase);
	sum = (float*)malloc(sizeof(float)*testcase);

	for (int i = 0; i < testcase; i++) {
		scanf("%d", &stu_num[i]);
		stu_case[i] = (int*)malloc(sizeof(int)*stu_num[i]);
		for (int j = 0; j < stu_num[i]; j++) {
			scanf("%d", &stu_case[i][j]);
			getchar();
		}
		sum[i] = 0.0;
		for (int j = 0; j < stu_num[i]; j++) {
			sum[i] += stu_case[i][j];
		}
		avg[i] = sum[i] / stu_num[i];
		count[i] = 0;
		for (int j = 0; j < stu_num[i]; j++) {
			if (stu_case[i][j] > avg[i]) {
				count[i]++;
			}
		}
	}

	for (int i = 0; i < testcase; i++) {
		printf("%2.3f%%\n", (float)count[i] / stu_num[i] * 100);
	}



	return 0;
}