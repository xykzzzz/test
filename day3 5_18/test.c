#include<stdio.h>
#include<Windows.h>
#pragma warning(disable:4996)
int main()
{
	int m, n, a, b, c;
	printf("请输入两个数：");
	scanf("%d %d", &a, &b);
	m = a;
	n = b;
	while (b != 0){
		c = a%b;
		a = b;
		b = c;
	}
	printf("最大公约数：%d\n", a);
	printf("最小公倍数:%d\n", m*n / a);
	system("pause");
}