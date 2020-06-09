#include<stdio.h>
#include<Windows.h>
#include<string.h>
#pragma warning(disable:4996)
#include<assert.h>
int Find(int a[][5], int row, int col, int target)
{
int i = 0;
int j = col - 1;
while (i < row && j >= 0){
	if (target < a[i][j]){
		j--;
	}
	else if (target > a[i][j]){
		i++;
	}
	else{
		return 1;
	}
}

return -1;
}
int main()
{
	int a[][5] = {
		{ 1, 2, 3, 4, 5 },
		{ 11, 22, 33, 44, 55 },
		{ 111, 222, 333, 444, 555 }
	};
	int x = 333;
	int ret = Find(a, 3, 5, x);
	printf("%d\n", ret);
	system("pause");
	return 0;
}//-1,no. 1 yes
