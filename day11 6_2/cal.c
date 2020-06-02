#include"cal.h"
int Myadd(int x, int y)
{
	return x + y;
}
int Mysub(int x, int y)
{
	return x - y;
}
int Mymul(int x, int y)
{
	return x *y;
}
int Mydiv(int x, int y)
{
	if (y == 0){
		printf("·ÖÄ¸Îª0£¡\n");
		return -1;
	}
		return x / y;
}