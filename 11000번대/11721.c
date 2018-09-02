#pragma warning(disable:4996)

#include<stdio.h>
#include<stdlib.h>

int main() {

	char temp[101];
	int i = 0;

	scanf("%s", temp);

	while (temp[i] != '\0') {
		printf("%c", temp[i]);
		i++;
		if (i % 10 == 0)
			printf("\n");
	}
	return 0;
}