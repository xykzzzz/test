#include<stdio.h>
#include<Windows.h>
#include<stdlib.h>
#include<limits.h>
#include<assert.h>
#pragma warning(disable:4996)
int status = 0;
int my_atoi(const char*str)
{
	assert(str);
	int flag = 1;
	long long int result = 0;
	int i = 0;
	while (isspace(str[i])){
		i++;
	}
	if (str[i] == '-'){
		flag = -flag;
		i++;
	}
	while (str[i]){
		if (isdigit(str[i])){
			result = result * 10 + flag*(str[i] - '0');
			if (result > INT_MAX || result < INT_MIN){
				status = 1;
				break;
			}
		}
		else{
			status = 2;
			break;
		}
		i++;
	}
	return (int)result;
}

int main()
{
	const char*str = "  -1234";
	int res = my_atoi(str);
	printf("status:%d  result:%d\n", status, res);
	system("pause");
	return 0;
}