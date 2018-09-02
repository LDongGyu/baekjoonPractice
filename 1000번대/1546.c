#pragma warning(disable:4996)

#include<stdio.h>

int main() {

	int testcase;
	int max = -1;
	int top = 0;
	float sum = 0;
	
	scanf("%d", &testcase);

	int *score = (int*)malloc(sizeof(int)*testcase);
	float *newscore = (float*)malloc(sizeof(float)*testcase);

	for (int i = 0; i < testcase; i++) {
		scanf("%d",&score[i]);
		getchar();
		if (score[i] > max) {
			max = score[i];
			top = i;
		}
	}

	for (int i = 0; i < testcase; i++) {
		newscore[i] = (float)score[i] / (float)max * 100;
		sum += newscore[i];
	}

	printf("%.2f", sum/testcase);

	return 0;
}