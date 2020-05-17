#include"mmine.h"
void Initboard(char board[][COL], int row, int col, char elem)
{
	int i = 0;
	for (; i < row; i++){
		int j = 0;
		for (; j < col; j++){
			board[i][j] = elem;
		}
	}
}
void SetMine(char mine[][COL], int row, int col)
{
	int n = NUM;
	while (n){
		int x = rand() % (row - 2) + 1;
		int y = rand() % (col - 2) + 1;
		if (mine[x][y] =='1'){
			continue;
		}
		mine[x][y] = '1';
		n--;
	}

}
void ShowBoard(char board[][COL], int row, int col)
{
	int i = 1;
	printf("   ");
	for (; i <= col - 2; i++){
		printf(" %-2d|", i);
	}
	printf("\n");
	for (i = 1; i <= col - 2; i++){
		printf("%3s","----");
	}
	printf("---\n");
	for (i = 1; i <= row - 2; i++){
		printf("%2d|", i);
		int j = 1;
		for (; j <= col - 2; j++){
			printf(" %-2c|", board[i][j]);
		}
		printf("\n");
		for (j = 1; j<= col - 2; j++){
			printf("%3s", "----");
		}
		printf("---\n");
	}
}
char GetNum(char mine[][COL], int x, int y)
{
   return mine[x - 1][y - 1] + mine[x - 1][y] + mine[x - 1][y + 1] + mine[x][y - 1] + mine[x][y + 1] + mine[x + 1][y - 1] + mine[x + 1][y] + mine[x + 1][y + 1]-7 * '0';
}
void Game()
{
	srand((unsigned long)time(NULL));
	char board[ROW][COL];
	char mine[ROW][COL];
	Initboard(board, ROW, COL, '*'); //����ʼ��*
	Initboard(mine, ROW, COL, '0');
	SetMine(mine, ROW, COL);
	int count = (ROW - 2)*(COL - 2) - NUM;
	do{
		system("cls");
		int x = 0;
		int y = 0;
		ShowBoard(board, ROW, COL);
		printf("��������Ҫɨ������-��");
		scanf("%d %d", &x, &y);
		if (x<1 || x>10 || y<1 || y>10){
			printf("�������λ���Ǵ���ģ����������룺\n");
				continue;
		}
		if (board[x][y] != '*'){
			printf("�������λ���Ѿ���ռ�ã����������룺\n");
			continue;
		}
		if (mine[x][y] == '0'){
			count--;
			char num = GetNum(mine, x, y);
			board[x][y] = num;
		}
		else{
			printf("�������λ�ã�%d,%d),���ף�\n", x, y);
			break;
		}
	} while (count>0);
	if (count > 0){
		printf("ɨ�׽������㱻ը����\n");
	}
	else{
		printf("ɨ�׽�������ϲ�㣬�ɹ�����\n");
	}

	ShowBoard(mine, ROW, COL);

}




void Initboard1(char board1[][COLA], int rowa, int cola, char elem)
{
	int i = 0;
	for (; i < rowa; i++){
		int j = 0;
		for (; j < cola; j++){
			board1[i][j] = elem;
		}
	}
}
void SetMine1(char mine1[][COLA], int rowa, int cola)
{
	int n = NUMA;
	while (n){
		int x = rand() % (rowa - 2) + 1;
		int y = rand() % (cola - 2) + 1;
		if (mine1[x][y] == '1'){
			continue;
		}
		mine1[x][y] = '1';
		n--;
	}

}
void ShowBoard1(char board1[][COLA], int rowa, int cola)
{
	int i = 1;
	printf("   ");
	for (; i <= cola - 2; i++){
		printf(" %-2d|", i);
	}
	printf("\n");
	for (i = 1; i <= cola - 2; i++){
		printf("%3s", "----");
	}
	printf("---\n");
	for (i = 1; i <= rowa - 2; i++){
		printf("%2d|", i);
		int j = 1;
		for (; j <= cola - 2; j++){
			printf(" %-2c|", board1[i][j]);
		}
		printf("\n");
		for (j = 1; j <= cola - 2; j++){
			printf("%3s", "----");
		}
		printf("---\n");
	}
}
char GetNum1(char mine1[][COLA], int x, int y)
{
	return mine1[x - 1][y - 1] + mine1[x - 1][y] + mine1[x - 1][y + 1] + mine1[x][y - 1] + mine1[x][y + 1] + mine1[x + 1][y - 1] + mine1[x + 1][y] + mine1[x + 1][y + 1] - 7 * '0';
}

void Gamee(){
	srand((unsigned long)time(NULL));
	char board1[ROWA][COLA];
	char mine1[ROWA][COLA];
	Initboard1(board1, ROWA, COLA, '*'); //����ʼ��*
	Initboard1(mine1, ROWA, COLA, '0');
	SetMine1(mine1, ROWA, COLA);
	int count1 = (ROWA - 2)*(COLA - 2) - NUMA;
	do{
		system("cls");
		int x = 0;
		int y = 0;
		ShowBoard1(board1, ROWA, COLA);
		printf("��������Ҫɨ������-��");
		scanf("%d %d", &x, &y);
		if (x<1 || x>10 || y<1 || y>10){
			printf("�������λ���Ǵ���ģ����������룺\n");
			continue;
		}
		if (board1[x][y] != '*'){
			printf("�������λ���Ѿ���ռ�ã����������룺\n");
			continue;
		}
		if (mine1[x][y] == '0'){
			count1--;
			char num1 = GetNum1(mine1, x, y);
			board1[x][y] = num1;
		}
		else{
			printf("�������λ�ã�%d,%d),���ף�\n", x, y);
			break;
		}
	} while (count1>0);
	if (count1 > 0){
		printf("ɨ�׽������㱻ը����\n");
	}
	else{
		printf("ɨ�׽�������ϲ�㣬�ɹ�����\n");
	}

	ShowBoard1(mine1, ROWA, COLA);

}

	
