#include<stdio.h>
#include<Windows.h>
#include<string.h>
#include<math.h>
#pragma warning(disable:4996)
//打印一个数的每个位之和
//int Digui(int x)
//{
//	if (x <= 0){
//		return 0;
//	}
//	else{
//		return x % 10 + Digui(x / 10);
//	}
//}
//int main()
//{
//	int x = 0;
//	printf("请输入一个数：");
//	scanf("%d", &x);
//	int ret = Digui(x);
//	printf("%d \n",ret);
//	system("pause");
//	return 0;
//}
//打印整数二进制的奇数位和偶数位
//int main()
//{
//	int i = 0;
//	int date = 0;
//	int a[32] = { 0 };
//	printf("请输入一个数：");
//	scanf("%d", &date);
//	for (i = 0; i < 32; i++){
//		a[i] = date % 2;
//		date /= 2;
//	}
//	printf("偶数位为:");
//	for (i = 31; i >= 0; i -= 2){
//		printf("%d", a[i]);
//	}
//	printf("\n");
//	printf("奇数位为:");
//	for (i = 30; i >= 0; i -= 2){
//		printf("%d", a[i]);
//	}
//	printf("\n");
//	system("pause");
//	return 0;
//}
//求两个数二进制中不同位的个数
//int Num(int c)
//{
//	int count = 0;
//	while (c){
//		c &= (c - 1);
//		count++;
//	}
//	return count;
//}
//int main()
//{
//	int a, b,c;
//	printf("输入两个数：");
//	scanf("%d %d", &a, &b);
//	c = a^b;
//	int ret = Num(c);
//	printf("二进制中不同位个数为：%d\n", ret);
//	system("pause");
//	return 0;
//}
//int main()
//{
//	int arr[] = { 1, 2, 3, 4, 5, 6 };
//	const int *p = arr;
//	int i = 0;
//	int len =sizeof(arr)/sizeof(arr[0]);
//	for (; i < len; i++){
//		printf("%d ", *(p + i));
//	}
//	system("pause");
//	return 0;
//}
//计算求和a+aa+aaa+aaaa+aaaaa
int main()
{
	int sum = 0;
	int a = 0;
	int i = 0;
	int n = 0;
	printf("请输入一个数a：");
	scanf("%d", &a);
	for (; i < 5; i++){
		n = n * 10 + a;
		sum += n;
	}
	printf("求和结果为：%d", sum);
	system("pause");
	return 0;
}
