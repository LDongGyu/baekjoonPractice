#pragma warning(disable:4996)

#include<stdio.h>

int main() {
	
	int testcase = 0;
	int push_num = 0;
	int stack[100001];
	int top = -1;
	char input_case[6];

	scanf("%d", &testcase);

	for (int i = 0; i < testcase; i++) {
		scanf("%s", input_case);

		if (input_case[0] == 'p') {
			if (input_case[1] == 'u') {
				scanf("%d", &push_num);
				top++;
				stack[top] = push_num;
			}
			else {
				if (top < 0) {
					printf("-1\n");
				}
				else {
					printf("%d\n", stack[top]);
					top--;
				}
			}
		}
		else if (input_case[0] == 's') {
			printf("%d\n", top + 1);
		}
		else if (input_case[0] == 'e') {
			if (top > -1) {
				printf("0\n");
			}
			else {
				printf("1\n");
			}
		}
		else {
			if (top > -1) {
				printf("%d\n", stack[top]);
			}
			else
				printf("-1\n");
		}
	}
}