#include <stdio.h>

int main(){
	int a, b, c;
	scanf("%d %d %d", &a, &b, &c);

	if (a == b || a == c || c == b){
		printf("S");
	} else if (a == (b + c) || b == (c + a) || c == (b + a)){
		printf("S");
	} else {
		printf("N");
	}
	
	printf("\n");

	return 0;
}