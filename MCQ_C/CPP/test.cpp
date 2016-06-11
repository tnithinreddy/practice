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
	cout<< inc(3)<<endl;
	return 0;
}