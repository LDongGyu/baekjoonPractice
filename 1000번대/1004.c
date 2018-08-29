#include<stdio.h>
#include<stdlib.h>
#include<math.h>

double distance(int x1, int y1, int x2, int y2);

int main() {
	int testcase = 0;
	int *x1, *y1, *x2, *y2;
	int *planet;
	int ***planet_info;
	int *answer;
	double distance1, distance2;
	
	int start_count = 0;
	int end_count = 0;
	int jung = 0;

	scanf_s("%d", &testcase); // 테스트 케이스

	planet = (int*)malloc(sizeof(int)*testcase); // 행성 개수
	planet_info = (int***)malloc(sizeof(int**)*testcase); // 행성 정보
	answer = (int*)malloc(sizeof(int)*testcase); // 답 담기
	
	x1 = (int*)malloc(sizeof(int)*testcase);
	y1 = (int*)malloc(sizeof(int)*testcase);
	x2 = (int*)malloc(sizeof(int)*testcase);
	y2 = (int*)malloc(sizeof(int)*testcase);

	
	for (int i = 0; i < testcase; i++) {
		scanf_s("%d %d %d %d", &x1[i], &y1[i], &x2[i], &y2[i]); // 시작, 도착점
		scanf_s("%d", &planet[i]);
		planet_info[i] = (int**)malloc(sizeof(int*)*planet[i]);
		
		for (int j = 0; j < planet[i]; j++) {
			planet_info[i][j] = (int*)malloc(sizeof(int) * 3);
			scanf_s("%d %d %d", &planet_info[i][j][0], &planet_info[i][j][1], &planet_info[i][j][2]);
		}
	}

	for (int i = 0; i < testcase; i++) {
		for (int j = 0; j < planet[i]; j++) {
			 distance1 = distance(x1[i], y1[i], planet_info[i][j][0], planet_info[i][j][1]); // 출발점과 행성 중점 거리
			 distance2 = distance(x2[i], y2[i], planet_info[i][j][0], planet_info[i][j][1]); // 도착점과 행성 중점 거리
			 if (distance1 < (double)planet_info[i][j][2]) {
				 start_count++;
			 }
			 if (distance2 < (double)planet_info[i][j][2]) {
				 end_count++;
			 }
			 if (distance1 < (double)planet_info[i][j][2] && distance2 < (double)planet_info[i][j][2]) {
				 jung++;
			 }
		}
		answer[i] = start_count + end_count - 2 * jung;
		start_count = 0;
		end_count = 0;
		jung = 0;

		printf("%d\n", answer[i]);
	}

	return 0;
}

double distance(int x1, int y1, int x2, int y2) {
	double d = 0.0;

	d = sqrt((double)((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)));

	return d;
}