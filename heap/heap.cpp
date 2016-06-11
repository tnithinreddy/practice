#include<iostream>
using namespace std;
int parent(int i){
	return i/2-1;
}
int left(int i){
	return 2*i + 1;
}
int right(int i){
	return 2*i + 2;
}

void heapify(int a[],int i,int n){
	int l = left(i);
	int r = right(i);
	if (l >= n)
	{
		return;
	}
	int min = i;
	if (r>=n)
	{
		if (a[l]<a[i])
		{
			min = l;
		}
	}else{
		if (a[l] < a[i])
		{
			min = l;
		}
		if(a[r] < a[min])
			min = r;
	}
	if (min != i)
	{
		// swap 
		int x = a[min];
		a[min] = a[i];
		a[i] = x;
		heapify(a,min,n);
	}
}
int heapSort(int a[], int n){
	n--;
	int i = 0;
	while(n > 0){

		// swap a[0] and a[n]
		int t = a[0];
		a[0] = a[n];
		a[n] = t;
		heapify(a,0,n);
		n--;
	}
}

int extractMin(int a[],int &n){
	if (n<=0)
	{
		cout<<"empty\n";
		return 0;
	}
	int max = a[0];
	a[0] = a[n-1];
	n--;
	heapify(a,0,n);

}
int main(int argc, char const *argv[])
{
	int a[] = {10,2,4,40,2,1};
	int n = 6;
	int i  = n/2 - 1;
	while(i>=0){
		heapify(a,i,n);
		i--;
	}
	for (int i = 0; i < n; ++i)
	{
		cout<<a[i] << " ";
	}
	cout<<endl;

	heapSort(a,n);
	for (int i = 0; i < n; ++i)
	{
		cout<<a[i] << " ";
	}
	cout<<endl;

	extractMin(a,n);
	for (int i = 0; i < n; ++i)
	{
		cout<<a[i] << " ";
	}
	return 0;
}