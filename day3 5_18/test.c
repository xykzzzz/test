#include<stdio.h>
#include<Windows.h>
#pragma warning(disable:4996)
int main()
{
	int m, n, a, b, c;
	printf("��������������");
	scanf("%d %d", &a, &b);
	m = a;
	n = b;
	while (b != 0){
		c = a%b;
		a = b;
		b = c;
	}
	printf("���Լ����%d\n", a);
	printf("��С������:%d\n", m*n / a);
	system("pause");
}