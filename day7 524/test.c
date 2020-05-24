#include<stdio.h>
#include<Windows.h>
#pragma warning(disable:4996)
void Rubblesort(int*arr,int a){
	int i = 0;
	for (i = 0; i < a - 1; i++){
		int j = 0;
		for (; j < a - 1 - i; j++){
			if (arr[j]>arr[j + 1]){
				int temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}
	}
}
void Show(int*arr, int a)
{
	int i = 0;
	for (i = 0; i < a; i++){
		printf("%d ", arr[i]);
	}
	printf("\n");
}

int main()
{
	int arr[] = { 1, 5, 4, 2, 3, 6, 10, 21, 2, 8 };
	int num = sizeof(arr) / sizeof(arr[0]);
	Show(arr, num);
	Rubblesort(arr, num);
	Show(arr, num);
	system("pause");
	return 0;
}