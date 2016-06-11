#include <iostream>
using namespace std;

int main() {
	//code
	int t;
	cin>>t;
	int n;
	int *a;
	while(t>0){
	    t--;
	    cin>>n;
	    if (n==1)
	    {
	    	cout<<n<<endl;
	    	continue;
	    }
	    if (n==2)
	    {
	    	cout<<2<<endl;
	    	continue;
	    }
	    if (n==3)
	    {
	    	cout<<4<<endl;
	    	continue;
	    }
	    a = new int[n+1];
	    a[1] = 1;
	    a[2] = 2;
	    a[3] = 4;
	    for(int i = 4;i<=n;i++){
	        a[i] = a[i-1]+a[i-2]+a[i-3];
	    }
	    cout<<a[n]<<endl;
	}
	return 0;
}