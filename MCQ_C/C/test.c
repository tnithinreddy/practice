#include<stdio.h>
#include<stdlib.h>
#define inc(x) x++
#define merge(a,b) a##b
#define fun(a) #a
int g = 10;

void fun1(){
	printf("%d\n",g);
}
void fun2(int i, int j){
	printf("hello world\n");

}
void main(){
	// fun(1);
	// printf("%d\n", i);
	// inc(8);
	// printf();

	// system("cat test.c");
	// int i = merge(123,24);
	// printf("%s\n", __FILE__);
	// printf("%d\n",__LINE__ );
	// printf("%s\n",__DATE__ );
	// printf("%s\n",__TIME__ );
	int **ptr = (int **)malloc(3*sizeof(int *));
	*ptr = (int *) malloc(3*sizeof(int));
	*(ptr+1) = (int *) malloc(3*sizeof(int));
	*(ptr+2) = (int *) malloc(3*sizeof(int));

	char *ptr1 = "stored in read only memory, cannot be changed";
	ptr1[0] = 'n';
	int x = 12345;
	printf("total printed = %d\n", printf("%d\n",x ));
	printf("size fo \"hi\" = %ld\n", sizeof("hi"));
	printf(2 + "hello");
	return;
}