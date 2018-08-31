#include<stdio.h>
#include<stdlib.h>

int** makeGraph(int building_num, int **connect, int rule);

int main() {
	int testcase = 0;
	int building_num = 0;
	int rule = 0;
	int **building_time;
	int ***connect;
	int *dest;

	scanf_s("%d", &testcase);
	building_time = (int**)malloc(sizeof(int*)*testcase);
	connect = (int***)malloc(sizeof(int**)*testcase);
	dest = (int*)malloc(sizeof(int)*testcase);

	for (int i = 0; i < testcase; i++) {
		scanf_s("%d %d", &building_num, &rule);
		building_time[i] = (int*)malloc(sizeof(int)*building_num);
		connect[i] = (int**)malloc(sizeof(int*)*rule);
		for (int n = 0; n < building_num; n++) {
			scanf_s("%d", &building_time[i][n]);
		} // 3번째줄까지

		for (int k = 0; k < rule; k++) {
			connect[i][k] = (int*)malloc(sizeof(int) * 2);
			scanf_s("%d %d", &connect[i][k][0], &connect[i][k][1]);
		}
	}


	return 0;
}

int** makeGraph(int building_num, int **connect, int rule) {
	int** graph;
	
	graph = (int**)malloc(sizeof(int*)*building_num);

	for (int i = 0; i < building_num; i++) {
		graph[i] = (int*)malloc(sizeof(int)*building_num);
	}

	for (int i = 0; i < rule; i++) {
		for (int j = 0; j < 2; j++) {

		}
	}
}