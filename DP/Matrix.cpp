#include<iostream>
#include<climits>
using namespace std;
int main(int argc, char const *argv[])
{	
	int order[] = {40, 20, 30, 10, 30};
	int n = 4;int i;
	int **a = new int*[n+1];
	for (int i = 0; i <=n; ++i)
	{
		a[i] = new int[n+1];
	}
	cout<<"hello\n";

	for ( i = 0; i <= n; ++i)
	{
		a[i][0] = 0;
		a[0][i] = 0;
		a[i][i] = 0;
	}
	// computed for chain length 1
	// compute for each chain length starting from 2
	cout<<"hello\n";
	for (int L = 2; L <= n; ++L)
	{
		for (int j = 1; j <= n-L+1; ++j)
		{
			/* code */
			int k = j+L-1;
			int min = INT_MIN;
			int q;
			for (int l = 0; l < k-2; ++l)
			{
				cout<< " j = "<<j << ", j+l = "<< j+l<<", k = "<< k<<"\n";
				cout<< a[j+l+1][k]<<endl;
				// q = a[j][j+l] + a[j+l+1][k] + order[j-1]*order[j+l-1]*order[k];
				
				if (min > q)
				{
					min = q;
				}
			}
			cout<<"before assign\n";

			a[j][k] = min;
			cout<<"after assign\n";
		}
	}
	return 0;
}