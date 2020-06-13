#include<stdio.h>
#include<Windows.h>
#include<string.h>
#include<assert.h>
#pragma warning(disable:4996)
// 小写转大写
//int my_islower(char c)
//{
//	return c >= 97 && c <= 122;
//}
//int my_toupper(char c)
//{
//	return my_islower(c) ? c - 32 : c;
//}
//int main()
//{
//	char str[] = "this is sring";
//	int len = strlen(str);
//	int i = 0;
//	for (; i < len; i++){
//		if (my_islower(str[i])){
//			str[i] = my_toupper(str[i]);
//		}
//	}
//	puts(str);
//	system("pause");
//	return 0;
//}

// 模拟memcpy函数
//void* my_memcpy(void*dst, const void* src, int len)
//{
//	assert(dst);
//	assert(src);
//	char*p = (char*)dst;
//	char*pi = (char*)src;
//	char*ret = dst;
//	while (len+1){
//		*p = *pi;
//		p++; pi++;
//		len--;
//	}
//	return ret;
//}
//
//int main()
//{
//	char *src = "hello world!";
//	char dst[20];
//	my_memcpy(dst, src, strlen(src));
//	printf("%s\n", dst);
//	system("pause");
//	return 0;
//}
// 模拟stsstr函数
//void my_strstr(const char* str1, const char* str2)
//{
//	assert(str1);
//	assert(str2);
//	const char*p = str1;
//	const char*pi = str2;
//	int len = strlen(str1);
//	int i = 0;
//	for (; i < len; i++){
//		if (*p != *pi){
//			p++;
//			continue;
//		}
//		if (*p == *pi){
//			break;
//		}
//	}
//	printf("%s\n", p);
//}
//
//int main()
//{
//	char*str1 = "abc 123 xyz";
//	char*str2 = "123";
//	my_strstr(str1, str2);
//	system("pause");
//	return 0;
//}
// 模拟memmove函数实现
//void*my_memmove(void*dst, void*src, size_t len)
//{
//	assert(dst);
//	assert(src);
//	char*_dst = (char*)dst;
//	const char*_src = (char*)src;
//	if (_src < _dst&&_src + len > _dst){
//		_dst = _dst + len - 1;
//		_src = _src + len - 1;
//		while (len>0){
//			*_dst = *_src;
//			_dst--; *_src--;
//			len--;
//		}
//	}
//	else{
//		while (len>0){
//			*_dst = *_src;
//			_dst++; *_src++;
//			len--;
//		}
//	}
//	return dst;
//	}
//
//int main()
//{
//	char str[32] = "abcd";
//	int len = strlen(str);
//	my_memmove(str+1, str , len);
//	printf("%s\n", str);
//	my_memmove(str + 1, str, len);
//	printf("%s\n", str);
//	system("pause");
//	return 0;
//}
//模拟strcat函数实现
//char*my_strcat(char*dst, char*src)
//{
//	assert(dst);
//	assert(src);
//	int len=strlen(src);
//	char *ret = dst;
//	while (*dst){
//		dst++;
//	}
//	while (len){
//		*dst = *src;
//		dst++; src++;
//			len--;
//	}
//	return ret;
//}
//int main()
//{
//	char str1[32] = "hello";
//	char str2[] = "world";
//	my_strcat(str1, str2);
//	printf("%s\n", str1);
//	system("pause");
//	return 0;
//}
//  模拟strcmp函数实现
//int my_strcmp(char*src, char*dst)
//{
//	int ret = 0;
//	assert(dst);
//	assert(src);
//	while (!(ret = *(unsigned char *)src - *(unsigned char *)dst) && *dst){
//		src++; dst++;
//	}
//	if (ret > 0){
//		ret = 1;
//	}
//	else if (ret < 0){
//		ret = -1;
//	}
//	return ret;
//}
//int main()
//{
//	char*str1= "abcd1234";
//	char*str2 = "abcd1234";
//	int ret = my_strcmp(str1, str2);
//	printf("%d\n", ret);
//	system("pause");
//	return 0;
//}
// 模拟strlen函数实现
//int  my_strlen(const char*str)
//{
//	assert(str);
//	const char*p = str;
//	int count = 0;
//	while (*p){
//		p++;
//		count++;
//	}
//	return count;
//}
//int  my_strlen(const char*str)
//{
//	if (*str == '\0')
//	{
//		return 0;
//	}
//	else{
//		return  1 + my_strlen(str + 1);
//	}
//}
//int  my_strlen(const char*str)
//{
//	const char*p = str;
//	while (*p){
//		p++;
//	}
//	return p - str;
//}
//int main()
//{
//	const char*str = "hello world!";
//	int len = my_strlen(str);
//	printf("%d\n", len);
//	system("pause");
//	return 0;
//}

//模拟strcpy函数实现
char*my_strcpy(char*str1, char*str)
{
	assert(str);
	assert(str1);
	int len = strlen(str);
	while (len+1){
		*str1 = *str;
		str1++; str++;
		len--;
	}
	return str1;

}
int main()
{
	char*str = "hello world!";
	char str1[32];
	my_strcpy(str1, str);
	printf("%s\n", str1);
	system("pause");
	return 0;

}