#include<stdio.h>
#include<Windows.h>
#include<time.h>
#pragma warning(disable:4996)
//int  Isprime(int x)
//{
//	int i = 0;
//	for (i = 2; i <= x - 1; i++)	{
//		if (x%i == 0){
//			return 2;
//		}
//	}
//	if (x==i){
//		return 1;
//		}
//	}
//int main()
//{
//	int a = 0;
//	printf("请输入你的数字：");
//	scanf("%d", &a);
//	int ret = Isprime(a);
//	if (ret ==1){
//		printf("该数是素数！");
//	}
//	if(ret==2){
//		printf("该数不是素数！");
//	}
//	system("pause");
//	return 0;
//}
//int  Leapyear(int x)
//{
//	if ((x % 4 == 0 && x % 100 != 0) || x % 400 == 0){
//		return 1;
//	}
//	else{
//		return 2;
//	}
//}
//int main()
//{
//	int a = 0;
//	printf("请输入你的年份：");
//	scanf("%d", &a);
//	int ret = Leapyear(a);
//	if (ret == 1){
//		printf("该年是闰年！");
//	}
//	if (ret == 2){
//		printf("该年不是闰年！");
//	}
//	system("pause");
//	return 0;
//}
//void Show(int x){
//	int a[64] = { 0 };
//	int i = 0;
//	while (x){
//		a[i] = x % 10;
//		x = x / 10;
//		i++;
//	}
//	while (i > 0){
//		i--;
//		printf("%d ", a[i]);
//	}
//	printf("\n");
//}
//int main()
//{
//	int a = 0;
//	printf("情输入你的数字：");
//	scanf("%d", &a);
//	Show(a);
//	system("pause");
//	return 0;
//}
//int Factorial(int x){
//	int i = 1;
//	int mul = 1;
//	for (; i <= x; i++){
//		mul *= i;
//	}
//	return mul;
//}
//int main()
//{
//	int n = 0;
//	printf("输入一个数的阶乘：\n");
//	scanf("%d", &n);
//	int ret = Factorial(n);
//	printf("%d的阶乘为%d\n", n, ret);
//	system("pause");
//	return 0;
//}
//int Digitisum(int x){
//	if (x > 0){
//		return x % 10 + Digitisum(x / 10);
//	}
//	else{
//		return 0;
//	}
//}
//int main()
//{
//	int num = 0;
//	printf("请输入一个数：");
//	scanf("%d", &num);
//	int ret = Digitisum(num);
//	printf("%d", ret);
//	system("pause");
//	return 0;
//}
int power(int n, int k)
{
	if (k < 0){
		k = -k;
		return 1 / (n*power(n, k - 1));
	}
	else if(k=0) {
		return 1;
	}
	else if(k>0){
		return n*power(n, k - 1);
	}
}
int main()
{
	int n, k;
	printf("请输入n的k次方:");
	scanf("%d %d", &n, &k);
	int ret = power(n, k);
	printf("%d^%d=%1d\n",n, k, ret);
	system("pause");
	return 0;
}