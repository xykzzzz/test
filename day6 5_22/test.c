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
//	printf("������������֣�");
//	scanf("%d", &a);
//	int ret = Isprime(a);
//	if (ret ==1){
//		printf("������������");
//	}
//	if(ret==2){
//		printf("��������������");
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
//	printf("�����������ݣ�");
//	scanf("%d", &a);
//	int ret = Leapyear(a);
//	if (ret == 1){
//		printf("���������꣡");
//	}
//	if (ret == 2){
//		printf("���겻�����꣡");
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
//	printf("������������֣�");
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
//	printf("����һ�����Ľ׳ˣ�\n");
//	scanf("%d", &n);
//	int ret = Factorial(n);
//	printf("%d�Ľ׳�Ϊ%d\n", n, ret);
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
//	printf("������һ������");
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
	printf("������n��k�η�:");
	scanf("%d %d", &n, &k);
	int ret = power(n, k);
	printf("%d^%d=%1d\n",n, k, ret);
	system("pause");
	return 0;
}