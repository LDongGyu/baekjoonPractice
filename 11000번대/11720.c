#pragma warning(disable:4996)

#include<stdio.h>
#include<stdlib.h>

int main() {

	int num;
	char *temp;
	int sum = 0;

	scanf("%d", &num);
	temp = (char*)malloc(sizeof(char)*(num+1));

	scanf("%s", temp);

	for (int i = 0; i < num; i++) {
		
		sum += temp[i]-'0';
	}

	printf("%d", sum);

	return 0;
}