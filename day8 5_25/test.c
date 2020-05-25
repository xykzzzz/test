#include<stdio.h>
#include<Windows.h>
#include<string.h>
#pragma warning(disable:4996)
//int main()
//{
//	int arr[] = { 1, 5, 4, 2, 3, 6, 10, 21, 2, 8 };
//	int num = sizeof(arr) / sizeof(arr[0]);
//	Show(arr, num);
//	Rubblesort(arr, num);
//	Show(arr, num);
//	system("pause");
//	return 0;
//}
//void Game()
//{
//	int a = 1;
//	for (a = 1; a <= 5; a++){
//		int b = 1;
//		for (b = 1; b <= 5; b++){
//			int c = 1;
//			for (c = 1; c <= 5; c++){         
//				int d = 1;                 
//				for (d = 1; d <= 5; d++){
//					int e = 1;
//					for (e = 1; e <= 5; e++){
//						if ((2 == b && 3 != a) || (2 != b && 3 == a) == 1)
//						{
//							if ((2 == b && 4 != e) || (2 != b && 4 == e) == 1)
//							{
//								if ((1 == c && 2 != d) || (1 != c && 2 == d) == 1)
//								{
//									if ((5 == c && 3 != d) || (5 != c && 3 == d) == 1)
//									{
//										if ((4 == e && 1 != a) || (4 != e && 1 == a) == 1)
//										{//对五个值均不相同的判断
//											if (((a != b) && (a != c) && (a != d) && (a != e))
//												&& ((b != c) && (b != d) && (b != e))
//												&& ((c != d) && (c != e))
//												&& ((d != e)))
//											{
//												printf("a= %d, b= %d,c= %d,d= %d,e= %d\n", a, b, c, d, e);
//											}
//										}
//									}
//								}
//							}
//						}
//					}
//				}
//			}
//		}
//	}
//}
//int main()
//{
//	Game();
//	system("pause");
//	return 0;
//}
//5位运动员参加了10米台跳水比赛，有人让他们预测比赛结果：
//A选手说：B第二，我第三；
//B选手说：我第二，E第四；
//C选手说：我第一，D第二；
//D选手说：C最后，我第三；
//E选手说：我第四，A第一；
//比赛结束后，每位选手都说对了一半，请编程确定比赛的名次


int main()
{
	int time[] = { 50, 60, 70, 80, 100, 120 };
	int i = 0;    //i j定义为第i首获第j首歌曲
	int count = 0;     //count 用来统计满足条件的歌曲对的数量
	int len = sizeof(time)/sizeof(time[0]);
	for (; i<len; i++){
		int j = 1;
		for (j = 1; j<len; j++){
			if (i >= j){
				continue;
			}
			else if((i<j) && (time[i] + time[j]) % 60 == 0){
				count++;
			}
		}
	}
	printf("可被60整除的歌曲对数量为：%d \n", count);
	system("pause");
	return 0;
}
//在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
//返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字 i 和 j 满足 i < j 且有(time[i] + time[j]) % 60 == 0。
//示例 1：
//输入：[30, 20, 150, 100, 40]
//输出：3
//解释：这三对的总持续时间可被 60 整数：
//(time[0] = 30, time[2] = 150) : 总持续时间 180
//(time[1] = 20, time[3] = 100) : 总持续时间 120
//(time[1] = 20, time[4] = 40) : 总持续时间 60
//示例 2：
//输入：[60, 60, 60]
//输出：3
//解释：所有三对的总持续时间都是 120，可以被 60 整数。
