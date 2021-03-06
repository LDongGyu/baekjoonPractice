﻿#include<stdio.h>
#include<stdlib.h>
#include<math.h>

int main() {

	int max, min;
	int *mult_arr;
	int count = 0;
	int arr_length = 0;
	int min_index = 0;
	int max_index = 0;

	scanf_s("%d %d", &min, &max);
	arr_length = sqrt(max) - 1;
	mult_arr = (int*)malloc(sizeof(int)*arr_length);

	for (int i = 2; i <= arr_length+1; i++) {
		mult_arr[i - 2] = i*i;
	}

	for (int i = 0; i < arr_length; i++) {
		if (mult_arr[i] > min && min_index == 0) {
			min_index = i;
		}
		if (mult_arr[i] >= max && max_index == 0) {
			max_index = i;
		}
	}

	count = max_index - min_inex +1;
	printf("%d", (max-min+1)-count);
	return 0;
}