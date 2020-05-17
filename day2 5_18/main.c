#include"mmine.h"
static void menu()
{
	printf("################################\n");
	printf("#####欢迎来到我的扫雷游戏#######\n");
	printf("################################\n");
	printf("#######1.hard  2. exit 3. easy ########\n");
	printf("################################\n");
	printf("请输入你的选择-》");

}
int main()
{
	int quit = 0;
	do{
		int select = 0;
		menu();
		scanf("%d", &select);
		switch (select){
		case 1:
			Game();
			printf("当前游戏已经结束，要不再来一把\n");
			break;
		case 2:
			quit = 1;
			printf("欢迎下次再来玩\n");
			break;
		case 3:
			Gamee();
			printf("当前游戏已经结束，要不再来一把\n");
			break;
		default:
			printf("选择错误，请重新输入\n");
				break;
		}

	} while (!quit);
	system("pause");
		return 0;
}