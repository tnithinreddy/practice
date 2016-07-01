#include<iostream>
#define inc(x) ++x
using namespace std;
// static keyword with local scope and but across all functions main
// int main(int k){
// 	static int i =5;
// 	if (i < 11)
// 	{	
// 		cout<<i<<endl;
// 		i++;
// 		main(9);		/* code */
// 	}
// }

int main(int argc, char const *argv[])
{
	/* code */
	int i  = 0;
	// cout<< ++2<<endl; // incerement operator requires location value
	string s;
	// getline(cin,s);
	// cout<<s;
	cout<<"set bit count = "<< __builtin_popcount(-7)<<endl;
	int n;
	cin >>n;
	int count;
	while(n > 0){
		
		i++;
		count = count + (n & 1);
		n = n >> 1;
	}
	cout<<"count = "<< count;
	return 0;
}