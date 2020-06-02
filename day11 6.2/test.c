#include<stdio.h>
#include<Windows.h>
#include<stdlib.h>
#include<assert.h>
#pragma warning(disable:4996)
int CompInt(const void* vx, const void* vy)
{
	int*x = (int*)vx;
	int*y = (int*)vy;
	//vx,vy代表任意两个元素的地址，*x, *y，任何两个元素
	if (*x > *y){
		return 1;
	}
	else if (*x < *y){
		return -1;
	}
	else{
		return 0;
	}
}
void show(int*arr, int num)
{
	int i = 0;
	for (; i < num; i++){
		printf("%d ", arr[i]);
	}
	printf("\n");
}
void Swap(char *x, char *y, int size)
{
	for (int i = 0; i < size; i++){
		*(x + i) ^= *(y + i);
		*(y + i) ^= *(x + i);
		*(x + i) ^= *(y + i);
	}
}
void Myqsort(void*base, int num, int size, int(*comp)(const void*, const void*))
{
	assert(base);
	assert(comp);
	char*_base = (char*)base;
	for (int i = 0; i < num - 1; i++)
	{
		for (int j = 0; j < num - 1 - i; j++){
			if (comp(_base + size*j, _base + size*(j + 1))>0){
				Swap(_base + size*j, _base + size*(j + 1), size);
			}
		}
	}
}
int main()
{
	int arr[] = { 1, 5, 6, 9, 40, 56, 50, 10, 3, 5 };
	int num = sizeof(arr) / sizeof(arr[0]);
	show(arr, num);
	Myqsort(arr, num, sizeof(int), CompInt);
	show(arr, num);
	system("pause");
	return 0;
}