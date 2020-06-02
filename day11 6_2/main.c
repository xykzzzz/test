#include"cal.h"
void menu()
{
	printf("############################\n");
	printf("###1.Myadd       2.Mysub ###\n");
	printf("###3.Mymul       4.Mydiv ###\n");
	printf("########  0.exit ###########\n");
	printf("请输入你的选择：");
}
int main()
{
	int(*fun[5])(int, int) = { NULL, Myadd, Mysub, Mymul, Mydiv };
	int select = 0;
	do{
		menu();
		scanf("%d", &select);
		if (select<0 || select>4){
			printf("输入错误，请重新输入：");
			continue;
		}
		if (select == 0){
			break;
		}
		int x = 0;
		int y = 0;
		printf(" 请输入x:");
		scanf("%d", &x);
		printf("请输入y:");
		scanf("%d", &y);
		int z = fun[select](x, y);
		printf("%d\n", z);
	} while (1);
}