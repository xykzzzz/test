#include <stdio.h>
#include<Windows.h>
#include <stdlib.h>
#include<math.h>
#pragma warning(disable:4996)
int main()
{
	int i = 0;
	for (; i < 100000; i++){
		int sum = 0;
		int n = 0;
		int temp = i;
		while (temp){
			n++;
			temp /= 10;
		}
		temp = i;
		while (temp){
			sum += pow(temp%10, n);
			temp /= 10;
		}
		if (sum == i){
			printf("%d  ", i);
		}
	}
	system("pause");
	return 0;
}
