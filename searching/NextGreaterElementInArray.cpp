#include <iostream>
using namespace std;
int ceilSearch(int a[], int beg, int end, int x){
	int mid = beg + end;
	mid = mid/2;
	if (a[mid] == x)
	{
		return mid;
	}
	if (a[mid] < x)
	{
		if (mid < end && a[mid+1] > x)
		{
			return mid+1;
		}else{
			return ceilSearch(a,mid+1,end,x);
		}
	}else{
		if (mid > beg && a[mid-1]<x)
		{
			return mid;
		}else{
			return ceilSearch(a,beg,mid-1,x);
		}
	}
}

int main(int argc, char const *argv[])
{
	int a[] = {1, 2, 8, 10, 10, 12, 19};
	int n = 7;
	int x = 5,index;
	for (int i = 0; i < n; ++i)
	{
		cout<< a[i] << " ";
	}
	cout<<endl;
	while(true){
		cout << "enter x = ";
		cin >> x;
		if (a[0] >= x)
		{
			index = 0;
		}else{
			if (a[n-1] < x)
			{
				index = -1;
			}else{
				index = ceilSearch(a,0,n-1,x);
			}
		}
		cout<<"index = "<< index<<endl;
	}
	 
	return 0;
	
}