#include<stdio.h>
#include<Windows.h>
#include<time.h>
#pragma warning(disable:4996)
void menu(){
	printf("############################\n");
	printf("###欢迎来到我的三子棋游戏###\n");
	printf("###1.play      0.exit    ###\n");
	printf("############################\n");
}
void Game()
{
	int random_num = rand() % 100 + 1;
	int input = 0;
	while (1)
	{
		printf("情输入你要猜的数字:");
		scanf("%d", &input);
		if (input > random_num){
			printf("猜大了\n");
		}
		else if (input < random_num){
			printf("猜小了\n");
		}
		else
		{
			printf("恭喜你，猜对了！");
			break;
		}
	}
}
int main()
{
	int input = 0;
	srand((unsigned)time(NULL));
	do{
		menu();
		printf("请输入你的选择：");
		scanf("%d", &input);
		switch (input){
		case 1:
			Game();
			break;
		case 0:
			break;
		default:
			printf("你输出有误，请重新输入！");
			break;
		}

	} while (input);
	system("pause");
	return 0;
}