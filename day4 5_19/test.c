#include<stdio.h>
#include<Windows.h>
#pragma warning(disable:4996)
#include<math.h>
//int main()
//{
//	int m, n, a, b, c;
//	printf("请输入两个数：");
//	scanf("%d %d", &a, &b);
//	m = a;
//	n = b;
//	while (b != 0){
//		c = a%b;
//		a = b;
//		b = c;
//	}
//	printf("最大公约数：%d\n", a);
//	printf("最小公倍数:%d\n", m*n / a);
//	system("pause");
//}
//void reverstr(char *p)
//{
//	int len = strlen(p);
//	char *pi = p;
//	char *pc = p + len - 1;
//	int i = 0;
//	char ch;
//	for (; i < len / 2; i++){
//		ch = *pi;
//		*pi =*pc;
//		*pc = ch;
//		pi++;
//		pc--;
//	}
//}
//int main()
//{
//	char p[] = "hello world!";
//	printf("倒序之前输出的字符串：%s\n", p);
//	reverstr(p);
//	printf("倒叙之后输出的字符串：%s\n", p);
//	system("pause");
//}
//int main()
//{
//	int a, b, c, t;
//	printf("请输入三个数：");
//	scanf("%d %d %d", &a, &b, &c);
//	if (a > b){ t = a; a = b; b = t; }
//	if (a > c){ t = a; a = c; c = t; }
//	if (b > c){ t = b; b = c; c = t; }
//	printf("%d %d %d", a, b, c);
//	system("pause");
//}
//int main()
//{
//	int i = 0;
//	for (i = 1; i <= 100; i++){
//		if (i % 3 == 0){
//			printf("%d  ", i);
//		}
//		else{
//			continue;
//		}
//	}
//	system("pause");
//}
//int main()
//{
//	int year = 0;
//	for (year= 1000; year <= 2000; year++){
//		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
//			printf("%d  ", year);
//		}
//		else{
//			continue;
//		}
//	}
//	system("pause");
//	return 0;
//}
//int main()
//{
//	int i = 0;
//	for (i = 100; i <= 200; i++){
//		int j = 0;
//		for (j = 2; j <= i - 1; j++){
//			if (i%j == 0)
//				break;
//		}
//			if (j == i){
//				printf("%d ", i);
//			}
//		}
//	system("pause");
//}
//int main()
//{
//	int i = 0;
//	for (i = 1; i <= 100; i++){
//		if (i % 10 == 9 || i / 10 == 9){
//			printf("%d ", i);
//		}
//		else{
//			continue;
//		}
//	}
//	system("pause");
//	return 0;
//}
//int main()
//{
//	int n = 0;
//	double sum = 0;
//	double c = 0;
//	for (n = 1; n <= 100; n++){
//		c = pow(-1, n + 1) * 1 / n;
//		sum += c;
//	}
//	printf("%f ", sum);
//	system("pause");
//	return 0;
//}
//int max;
//int fun(int a[],int n){
//	int i = 0;
//	max = a[0];
//	int pos = 0;
//	for (; i < n; i++){
//		if (a[i]>max){
//			max = a[i];
//			pos = i;
//		}
//	}
//	return pos;
//}
//int main()
//{
//	int a[10] = { 1, 4, 2, 7, 3, 12,5, 34, 5, 9 };
//	int len = sizeof(a) / sizeof(a[0]);
//	int ret = fun(a,len);
//	printf("%d\n", a[ret]);
//	system("pause");
//	return 0;
//}
//int main()
//{
//	int i = 0;
//	for (i=1; i <= 9; i++){
//		printf("%d ", i);
//	}
//	printf("\n");
//	for (i = 1; i <= 9; i++){
//		int j = 0;
//		for (j = 1; j <= i; j++){
//			int mul = i*j;
//			printf("%d ",mul);
//		}
//		printf("\n");
//	}
//	system("pause");
//	return 0;
//}

