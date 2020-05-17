#include <stdio.h>
#include<Windows.h>
#include<stdlib.h>
#pragma warning(disable:4996)
int power(int n, int k)
{
	if (k <  0){
		k = -k;
		return  1 / (n*power(n, k - 1));
	}
	else if (k = 0){
		return 1;
	}
	else if (k>0){
		return n * power(n, k - 1);

	}
}
int main()
{
	int n;
	int k;
	printf("输入相应的底数和指数：\n");
	scanf("%d %d", &n, &k);
	int ret = power(n, k);
	printf("%d^%d=%lf\n", n, k, ret);
	system("pause");
	return 0;

}