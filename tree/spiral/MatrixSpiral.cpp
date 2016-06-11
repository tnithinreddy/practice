#include<iostream>
using namespace std;
int main(int argc, char const *argv[])
{
	int **a;
	int rows = 3;
	int col = 4;
	a = new int*[rows];
	for (int i = 0; i < rows; ++i)
	{
		a[i] = new int[col];
	}
	for (int i = 0; i < rows; ++i)
	{
		for (int j = 0; j < col; ++j)
		{
			cin>>a[i][j];
			// cout<<a[i][j]<<" ";
		}
	}
	for (int i = 0; i < rows; ++i)
	{
		for (int j = 0; j < col; ++j)
		{
			cout<<a[i][j]<<" ";
		}
		cout<<endl;
	}
	int i=0,j=0,k=rows-1,l=col-1;
	while(true){
		if (i>k || j>l)
		{
		cout<<"\n i = "<<i<<" j = "<<j<<" k = "<<k<<" l = "<<l<<endl;	

			break;
		}
		// printRowFromBegToend(i,j,k);
		for (int x = j;x<l;x++)
		{
			cout<<a[i][x]<<" ";
		}
		if (i>k || j>l)
		{
		cout<<"\n i = "<<i<<" j = "<<j<<" k = "<<k<<" l = "<<l<<endl;	

			break;
		}
		i++;
		
		// printColfromTopToBottom(i,j,k);
		for (int x = i-1;x<k;x++)
		{
			cout<<a[x][l]<<" ";
		}
		l--;
		if (i>k || j>l)
		{
		cout<<"\n i = "<<i<<" j = "<<j<<" k = "<<k<<" l = "<<l<<endl;	

			break;
		}
		// printRowRightToLeft();
		for (int x = l+1;x>j;x--)
		{
			cout<<a[k][x]<<" ";
		}
		
		if (i>k || j>l)
		{
		cout<<"\n i = "<<i<<" j = "<<j<<" k = "<<k<<" l = "<<l<<endl;	

			break;
		}
		k--;
		// printColBottomToTop();
		for (int x = k+1;x>=i;x--)
		{
			cout<<a[x][j]<<" ";
		}
		j++;
		
	}
	
	return 0;
}