#include<stdio.h>
#include<stdlib.h>
#include<math.h>

int main() {

	int max, min;
	int *mult_arr;
	int count = 0;
	int arr_length = 0;
	int min_index = -1;
	int max_index = -1;

	scanf_s("%d %d", &min, &max);
	arr_length = sqrt(max) - 1;
	mult_arr = (int*)malloc(sizeof(int)*arr_length);

	for (int i = 2; i <= arr_length + 1; i++) {
		mult_arr[i - 2] = i*i;
	}

	for (int i = 0; i < arr_length; i++) {
		if (mult_arr[i] > min && min_index == -1) {
			min_index = i;
		}
	}

	count = arr_length - min_index + 1;
	printf("%d", (max - min + 1) - count);
	return 0;
}