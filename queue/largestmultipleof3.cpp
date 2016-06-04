#include<iostream>
#include<queue>
#include<algorithm>
using namespace std;
bool myfunction(int i,int j){
	return (i>j);
}
int main(int argc, char const *argv[])
{
	// queue<int
	int a[] = {8,1,7,6,0};
	sort(a, a+5,myfunction);
	for (int i = 0; i < 5; ++i)
	{
		cout<<a[i]<<" ";
	}
	queue<int> q1;
		queue<int> q2,q3;
	cout<<endl;
	sort(a,a+5);
	int sum = 0;
	for (int i = 0; i < 5; ++i)
	{
		sum = a[i]+ sum;
	}
	for (int i = 0; i < 5; ++i)
	{
		if (a[i]%3 == 1)
		{
			q1.push(a[i]);
		}
		if (a[i]%3 == 2)
		{
			q2.push(a[i]);
		}
		if (a[i]%3 == 0)
		{
			q3.push(a[i]);
		}
	}
	if (sum%3 == 0)
	{
		/* code */

	}else{
		
	
		if (sum%3 == 2)
		{
			/* code */
			if(!q2.empty()){
				q2.pop();
			}else{
				if (q1.size()>2)
				{
					q1.pop();
					q1.pop();
				}else{
					cout<<"not possible";
					return 0;
				}
			}
		}else{
			if(!q1.empty()){
				q1.pop();
			}else{
				if (q2.size()>2)
				{
					q2.pop();
					q2.pop();
				}else{
					cout<<"not possible";
					return 0;
				}
			}

		}
	}
	std:vector<int> v;
	cout<<q1.size()<<q2.size()<<q3.size();
	while(!q1.empty()){
		v.push_back(q1.front());
		q1.pop();
	}
	while(!q2.empty()){
		v.push_back(q2.front());
		q2.pop();
	}
	while(!q3.empty()){
		v.push_back(q3.front());
		q3.pop();
	}
	sort(v.begin(),v.end(),myfunction);
	for(std::vector<int>::iterator it=v.begin();it!=v.end();++it){
		cout<<*it<<" ";
	}
	return 0;
}