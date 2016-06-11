#include<stdio.h>
#define inc(x) x++
#define merge(a,b) a##b
#define fun(a) #a
 void fu1n(int i){
	printf("hello world\n");
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
	int i = merge(123,24);
	printf("%s\n", __FILE__);
	printf("%d\n",__LINE__ );
	printf("%s\n",__DATE__ );
	printf("%s\n",__TIME__ );


	// printf("%s\n", fun(geeks));
	return;
}