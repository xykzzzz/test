#ifndef _MMINE_H_
#define _MMINE_H_

#include<stdio.h>
#include<stdlib.h>
#include<Windows.h>
#include<time.h>
#pragma warning(disable:4996)
#define ROW 12
#define COL 12
#define NUM 20
void Game();
void Initboard(char board[][COL],int row, int col, char elem);
void SetMine(char mine[][COL], int row, int col);
void ShowBoard(char board[][COL], int row, int col);
char GetNum(char mine[][COL], int x, int y);




void Gamee();
#define ROWA 6
#define COLA 6
#define NUMA 4
void Initboard1(char board1[][COLA], int rowa, int cola, char elem);
void SetMine1(char mine1[][COLA], int rowa, int cola);
void ShowBoard1(char board1[][COLA], int rowa, int cola);
char GetNum1(char mine1[][COLA], int x, int y);







#endif