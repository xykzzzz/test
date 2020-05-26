#include<stdio.h>
#include<Windows.h>
#pragma warning(disable:4996)
int main()
{
	int i = 0;
	int j = 0;
	int k = 0;
	for (i = 1; i < 5; i++){
		for (j = 1; j < 5; j++){
			for (k = 1; k < 5; k++){
				if ((i != j) && (i != k) && (j != k)){
					printf("%d %d %d\n", i, j, k);
				}
			}
		}
	}
	system("pause");
	return 0;
}