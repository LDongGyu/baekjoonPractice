﻿#pragma warning(disable:4996)

#include<stdio.h>

int main() {

	int n, x;
	scanf("%d %d", &n, &x);

	int *arr;
	arr = (int*)malloc(sizeof(int)*n);

	for (int i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
		getchar();
	}

	for (int i = 0; i < n; i++) {
		if (arr[i] < x) {
			printf("%d ", arr[i]);
		}
	}


	return 0;
}