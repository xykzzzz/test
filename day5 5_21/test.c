#include<stdio.h>
#include<Windows.h>
#include<time.h>
#pragma warning(disable:4996)
void menu(){
	printf("############################\n");
	printf("###��ӭ�����ҵ���������Ϸ###\n");
	printf("###1.play      0.exit    ###\n");
	printf("############################\n");
}
void Game()
{
	int random_num = rand() % 100 + 1;
	int input = 0;
	while (1)
	{
		printf("��������Ҫ�µ�����:");
		scanf("%d", &input);
		if (input > random_num){
			printf("�´���\n");
		}
		else if (input < random_num){
			printf("��С��\n");
		}
		else
		{
			printf("��ϲ�㣬�¶��ˣ�");
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
		printf("���������ѡ��");
		scanf("%d", &input);
		switch (input){
		case 1:
			Game();
			break;
		case 0:
			break;
		default:
			printf("������������������룡");
			break;
		}

	} while (input);
	system("pause");
	return 0;
}