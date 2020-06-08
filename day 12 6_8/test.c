#include<stdio.h>
#include<Windows.h>
#include<string.h>
#pragma warning(disable:4996)
#include<assert.h>
          //方法一 子区间逆序得到左旋结果
//void Reverse(char*str, int start, int end)
//{
//	while (start < end){
//		char temp = str[start];
//		str[start] = str[end];
//		str[end] = temp;
//		start++; end--;
//	}
//
//}
//void left(char*str, int len, int num)
//{
//	assert(str);
//	assert(len > 0);
//	assert(num > 0);
//	num %= len;
//	Reverse(str, 0, num - 1);
//	Reverse(str, num, len - 1);
//	Reverse(str, 0, len - 1);
//}
//int main()
//{
//	char str1[] = "abcd1234";
//	char str2[] = "bcd1234a";
//	int len = strlen(str1);
//	int num = 1;
//	left(str1, len, num);
//	int i = 0;
//	for (; i < len; i++){
//		if (strcmp(str1, str2) == 0){
//			printf("yes!\n");
//			break;
//		}
//		left(str1, len, num);
//		
//	}
//	if (i == len){
//		printf("no!\n");
//	}
//	system("pause");
//	return 0;
//}


          //方法二  
//void left(char*str1, int len, int num)
//{
//	assert(str1);
//	assert(len > 0);
//	assert(num > 0);
//	num %= len;
//	while (num){
//		int i = 0;
//		char temp = str1[0];
//		for (; i < len - 1; i++){
//			str1[i] = str1[i + 1];
//		}
//		str1[i] = temp;
//		num--;
//	}
//}
//int main()
//{
//	char str1[] = "abcd1234";
//	char str2[] = "bcd1234a";
//	int len = strlen(str1);
//	int num = 1;
//	int i = 0;
//	for (; i < len; i++){
//		if (strcmp(str1, str2) == 0){
//			printf("yes!\n");
//			break;
//		}
//		left(str1, len, num);
//
//	}
//	if (i == len){
//		printf("no!\n");
//	}
//	system("pause");
//	return 0;
//}

         //方法三双倍串
int main()
{
	char str1[] = "abcd1234";
	char str2[] = "bcd1234a";
	int len = strlen(str1);
	char *double_string = (char*)malloc(2 * len + 1);
	if (double_string == NULL){
		return -1;
	}
	strcpy(double_string, str1);
	strcat(double_string, str1);
	printf("double string : %s\n", double_string);
	if (strstr(double_string, str2) != NULL){
		printf("yes\n");
	}
	else{
		printf("no!\n");
	}
	free(double_string);
	system("pause");
	return 0;
}