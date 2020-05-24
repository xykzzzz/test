#include<stdio.h>
#include<Windows.h>
#pragma warning(disable:4996)
void Showyang(){
	int arr[10][10] = { 0 };
	int i = 0;
	int j = 0;
	for (; i < 10; i++){
		for (j = 0; j < i; j++){
			arr[i][j] = 1;
		}
	}
	for (i = 2; i < 10; i++){
		for (j = 1; j < i; j++){
			arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
		}
	}
	for (i = 0; i < 10; i++){
		for (j = 0; j < i; j++){
			printf("%d ", arr[i][j]);
		}
		printf("\n");
	}
}
int main()
{
	Showyang();
	system("pause");
	return 0;
}
//int main()
//{
//	char killer = 'A';
//	for (; killer <= 'D'; killer++){
//		if ((killer != 'A') + (killer == 'C') + (killer == 'D') + (killer != 'D') == 3){
//			printf("ÕÒµ½Ð×ÊÖ£º%c\n", killer);
//		}
//	}
//	system("pause");
//	return 0;
//}