#include<iostream>
#include<climits>
using namespace std;
bool isSameBst(int [], int [], int, int, int,  int, int);
int main(int argc, char const *argv[])
{
	int a[] = {8, 3, 6, 1, 4, 7, 10, 14, 13};
	int b[] = {8, 10, 14, 3, 6, 4, 1, 7, 13};
	int min = INT_MIN;
	int max = INT_MAX;
	int aIndex = 0;
	int bIndex = 0;
	if (sizeof(a) != sizeof(b))
	{
		cout<<"not identical BST's"<<endl;
	}
	bool res = isSameBst(a,b,sizeof(a)/sizeof(a[0]),aIndex,bIndex,min,max);
	if (res)
	{
		cout<<"same BST\n";
	}else{
		cout<<"not identical BST's"<<endl;

	}
	return 0;
}

bool isSameBst(int a[], int b[], int n, int aIndex, int bIndex, int min, int max){
	int i,j;
	for ( i = aIndex; i < n; ++i)
	{
		if (a[i]>min && a[i]<max)
		{
			break;
		}
	}
	for ( j = bIndex; j < n; ++j)
	{
		if (b[j]>min && b[j]<max)
		{
			break;
		}
	}
	if (i == n && j == n)
	{
		return true;
	}
	if (((i==n) ^ (j == n)) || a[i]!=b[j] )
	{
		cout<<"here i = "<< i << " j = "<< j<<endl;
		cout<<"here a[i] = "<< a[i] << " a[j] = "<< b[j]<<endl;

		return false;
	}
	return isSameBst(a,b,n,i+1,j+1,min,a[i]) && isSameBst(a,b,n,i+1,j+1,a[i],max);
	// return false;
}