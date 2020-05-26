#include<stdio.h>
#include<Windows.h>
#pragma warning(disable:4996)
typedef struct stu{
	char name[32];
	char sex;
	int age;
	int score[5];
}stu_s;
void Show(stu_s x){
	int num = sizeof(x.score) / sizeof(x.score[0]);
	printf("%s %c %d \n", x.name, x.sex, x.age);
	int i = 0;
	for (; i < num; i++){
		printf("%d:%d ", i, x.score[i]);
		printf("\n");
	}
}
int main(){
	stu_s student = { "ÏÄÓî¿Æ", 'm', 21, { 90, 90, 90, 90, 98 } };
	stu_s*p = &student;
	Show(student);
	/*int num = sizeof(p->score) / sizeof(p->score[0]);
	printf("%s %c %d \n", p->name, p->sex, p->age);
	int i = 0;
	for (; i < num; i++){
		printf("%d:%d ", i, p->score[i]);
		/*printf("\n");*/
	/*printf("main: %p\n", &student);
	printf("main: %p\n", p->name);
	printf("main: %p\n", &(student.name));
	printf("               \n");

	printf("main: %p\n", &student+1);
	printf("main: %p\n", p->name+1);
	printf("main: %p\n", &(student.name)+1);*/

	system("pause");
	return 0;
}