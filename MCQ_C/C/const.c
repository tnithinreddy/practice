#include<stdio.h>
#define get(x) #x
#define merge(x,y) x##y

extern void fun1(int);
void main(){ 
	
	int i = 5;
	extern int g;
	g++;
	printf("external variable  = %d\n",g );
	fun1(g);
	const int k = 5; // we cannot change k value
	// k++; not permitted
	 int const x = 9; // same as const int k = 5;, cannnot change x value
	 // x++; // is not permitted
	 int* const ptr = &i;
	 // ptr++ is not permitted
	// printf("%d\n", ++ptr);
	  int * ptr1;
	 ptr1 = &x;
	 (*ptr)++; // throws a warning saying const of the target is neglected, not an error 
	 printf(" i = %d\n", i);
	 const int a; // cannot change the value of a
	 int const e;// cannot change value of e;
	 const int * b;
	 const int * const c;
	 int* const d;

	 int arr[] = {15,100};
	 ptr1 = arr;
     printf("%d %d\n",*ptr1, *ptr1++);// use the value of ptr first and then increment the value of ptr 
     						// *ptr1++ will increase the address not the target value
     						// post and pre increment will have higher precedence to *
     // printf("%d\n", *ptr1);
	return;
}