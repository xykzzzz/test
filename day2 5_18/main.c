#include"mmine.h"
static void menu()
{
	printf("################################\n");
	printf("#####��ӭ�����ҵ�ɨ����Ϸ#######\n");
	printf("################################\n");
	printf("#######1.hard  2. exit 3. easy ########\n");
	printf("################################\n");
	printf("���������ѡ��-��");

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
			printf("��ǰ��Ϸ�Ѿ�������Ҫ������һ��\n");
			break;
		case 2:
			quit = 1;
			printf("��ӭ�´�������\n");
			break;
		case 3:
			Gamee();
			printf("��ǰ��Ϸ�Ѿ�������Ҫ������һ��\n");
			break;
		default:
			printf("ѡ���������������\n");
				break;
		}

	} while (!quit);
	system("pause");
		return 0;
}