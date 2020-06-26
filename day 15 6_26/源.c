#include<stdio.h>
#include<Windows.h>
#include<string.h>
#include<assert.h>
#pragma warning(disable:4996)
//struct Array{
//	int num;
//	int*mem;
//};
//struct A{
//	int num;
//	char arr[0];
//};
//int main()
//{
	/*struct Array*arr = (struct Array*)malloc(sizeof(struct Array));
	if (arr ==NULL){
		return 1;
	}
	arr->num = 100;
	arr->mem = (int*)malloc(arr->num*sizeof(int));
	if (arr->mem == NULL){
		free(arr);
		return 2;
	}*/

//	struct A*p = malloc(sizeof(struct A) + 100 * sizeof(char));
//	if (p == NULL){
//		return 1;
//	}
//	p->num = 100;
//	int i = 0;
//	for (; i < p->num; i++){
//		p->arr[i] = i;
//	}
//	
//	system("pause");
//	return 0;
//}
void Finddog(int a[], int num, int*x, int*y)
{
	int result = a[0];
	for (int i = 1; i < num; i++){
		result ^= a[i];
	}
	int pos = 1;
	while (1)
	{
		if (result &pos){
			break;
		}
		pos <<= 1;
	}
	*x = 0;
	*y = 0;
	for (int i = 0; i < num; i++){
		if (a[i] & pos){
			*x ^= a[i];
		}
		else{
			*y ^= a[i];
		}
	}
}

int main()
{
	int a[] = { 1, 2, 3, 4, 5, 6, 10, 15, 1, 2, 3, 4, 5, 6 };
	int x = 0;
	int y = 0;
	int num = sizeof(a) / sizeof(a[0]);
	Finddog(a, num, &x, &y);
	printf("x:%d y:%d\n", x, y);
	system("pause");
	return 0;
}