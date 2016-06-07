#include <iostream>
using namespace std;

void printSorted(int [],int,int);
int main(){
	int a[] = {4,2,5,1,3};
	int n = 5;
	for (int i = 0; i < n; ++i)
	{
		cout<<a[i]<<" ";
	}
	cout<<endl;
	printSorted(a,0,n);
	return 0;
}
// 
void printSorted(int a[],int root,int n){
	if (root >= n)
	{
		return;
	}
	printSorted(a,2*root+1,n);
	cout<< a[root]<<" ";
	printSorted(a,2*root+2,n);

}