#include<stdio.h>
#include<Windows.h>
#include<string.h>
#include<math.h>
#pragma warning(disable:4996)
//��ӡһ������ÿ��λ֮��
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
//	printf("������һ������");
//	scanf("%d", &x);
//	int ret = Digui(x);
//	printf("%d \n",ret);
//	system("pause");
//	return 0;
//}
//��ӡ���������Ƶ�����λ��ż��λ
//int main()
//{
//	int i = 0;
//	int date = 0;
//	int a[32] = { 0 };
//	printf("������һ������");
//	scanf("%d", &date);
//	for (i = 0; i < 32; i++){
//		a[i] = date % 2;
//		date /= 2;
//	}
//	printf("ż��λΪ:");
//	for (i = 31; i >= 0; i -= 2){
//		printf("%d", a[i]);
//	}
//	printf("\n");
//	printf("����λΪ:");
//	for (i = 30; i >= 0; i -= 2){
//		printf("%d", a[i]);
//	}
//	printf("\n");
//	system("pause");
//	return 0;
//}
//���������������в�ͬλ�ĸ���
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
//	printf("������������");
//	scanf("%d %d", &a, &b);
//	c = a^b;
//	int ret = Num(c);
//	printf("�������в�ͬλ����Ϊ��%d\n", ret);
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
//�������a+aa+aaa+aaaa+aaaaa
int main()
{
	int sum = 0;
	int a = 0;
	int i = 0;
	int n = 0;
	printf("������һ����a��");
	scanf("%d", &a);
	for (; i < 5; i++){
		n = n * 10 + a;
		sum += n;
	}
	printf("��ͽ��Ϊ��%d", sum);
	system("pause");
	return 0;
}
