#include<stdio.h>
#include<Windows.h>
#pragma warning(disable:4996)
//int main()
//{
//	int m, n, a, b, c;
//	printf("��������������");
//	scanf("%d %d", &a, &b);
//	m = a;
//	n = b;
//	while (b != 0){
//		c = a%b;
//		a = b;
//		b = c;
//	}
//	printf("���Լ����%d\n", a);
//	printf("��С������:%d\n", m*n / a);
//	system("pause");
//}
void reverstr(char *p)
{
	int len = strlen(p);
	char *pi = p;
	char *pc = p + len - 1;
	int i = 0;
	char ch;
	for (; i < len / 2; i++){
		ch = *pi;
		*pi =*pc;
		*pc = ch;
		pi++;
		pc--;
	}
}
int main()
{
	char p[] = "hello world!";
	printf("����֮ǰ������ַ�����%s\n", p);
	reverstr(p);
	printf("����֮��������ַ�����%s\n", p);
	system("pause");
}