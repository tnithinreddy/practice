#include <stdio.h>
#include<stdlib.h>

void fun1(int a[][4]){
	printf("inside function sizeof(arr) = %ld\n", sizeof(a)); // 16*4  = 64

}

int main(int argc, char const *argv[])
{
	int a[] = {1,2,3}; // sizeof(a) = 12, this will give size of entire array
						// sizeof(a[0]) = 4, this is the size of int

	int *b; // sizeof(b)=8 // this is size of pointer
	char *c; // c = c+1, will increment the address stored in c by 1, if c pointer to int, then c= c+1 will increase by 4
	// printf("sizeof(a) %d\n", sizeof(*b));	
	b = a;
	// b = new int[10];
	b = (int *)malloc(4*sizeof(int));
	printf("sizeof(b) %ld\n", sizeof(b)); // 8
	printf("sizeof(*b) %ld\n", sizeof(*b)); // 4

	int arr[][4] = {
		{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}
	};
	fun1(arr);
	printf("sizeof(arr) = %ld\n", sizeof(arr)); // 16*4  = 64
	printf("sizeof(arr[0]) = %ld\n", sizeof(arr[0])); //16
	printf("sizeof(arr[0][0]) = %ld\n", sizeof(arr[0][0])); //  4

	int **ptr;
	printf("sizeof(ptr) = %ld\n", sizeof(ptr)); // 8
	printf("sizeof(*ptr) = %ld\n", sizeof(*ptr)); // 8
	printf("sizeof(**ptr) = %ld\n", sizeof(**ptr)); // 4
	
	ptr = (int**)malloc(4*sizeof(int*));
	// *ptr = 
	return 0;
}