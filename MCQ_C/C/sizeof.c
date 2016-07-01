#include "stdio.h"
#include<stdlib.h>

void fun1(int **a){
	printf("hello inside function sizeof(arr) = %ld\n", sizeof(a)); // 8
	printf("inside function sizeof(arr[0]) = %ld\n", sizeof(a[0])); // size of one full row

}

void fun(int a[]){
	printf("inside function sizeof(a) = %ld\n", sizeof(a)); // here everything is treated as a pointer
}

int main(int argc, char const *argv[])
{
	int a[] = {1,2,3}; // sizeof(a) = 12, this will give size of entire array
						// sizeof(a[0]) = 4, this is the size of int
	int arr[][4] = {
		{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}
	};
	int **darray = arr;
	int *b; // sizeof(b)=8 // this is size of pointer
	char *c; // c = c+1, will increment the address stored in c by 1, if c pointer to int, then c= c+1 will increase by 4
	// printf("sizeof(a) %d\n", sizeof(*b));	
	b = a;
	char carr[] = "hello";
	char *h = "abc";
	printf("sizeof(h) %ld\n", sizeof(*h)); // 1
	printf("h = %d %d\n",h, &h[0]); // 
	// printf("sizeof(carr) %ld\n", sizeof(carr)); // 6, (5 + \0)
	printf("carr+1 = %d %d",carr, carr+1); // if carr is at 1000 the output is 1000,1001
	// printf("sizeof(a) where a is array of int  %ld\n", sizeof(a)); // 12
	// printf("sizeof(b) where b = a, %ld\n", sizeof(b)); // 8
	fun(a);
	// // b = new int[10];
	// b = (int *)malloc(4*sizeof(int));
	// printf("sizeof(b) %ld\n", sizeof(b)); // 8
	// printf("sizeof(*b) %ld\n", sizeof(*b)); // 4

	fun1(darray);	
	// fun1(arr);
	// printf("sizeof(arr) = %ld\n", sizeof(arr)); // 16*4  = 64
	// printf("sizeof(arr[0]) = %ld\n", sizeof(arr[0])); //16
	// printf("sizeof(arr[0][0]) = %ld\n", sizeof(arr[0][0])); //  4

	// int **ptr;
	// printf("sizeof(ptr) = %ld\n", sizeof(ptr)); // 8
	// printf("sizeof(*ptr) = %ld\n", sizeof(*ptr)); // 8
	// printf("sizeof(**ptr) = %ld\n", sizeof(**ptr)); // 4
	
	// ptr = (int**)malloc(4*sizeof(int*));
	// *ptr = 
	return 0;
}