#include<iostream>
#include<stack>
#include<vector>
using namespace std;
struct node
{
	int data;
	int date;
};
int main(int argc, char const *argv[])
{	
	stack<node> s;
	std::vector<int> v;
	v.push_back(100);
	v.push_back(80);
	v.push_back(60);
	v.push_back(70);
	v.push_back(60);
	v.push_back(75);
	v.push_back(85);
	std::vector<int>::iterator it = v.begin();
	node n;
	n.date = 0;
	n.data = *it;
	s.push(n);
	++it;
	int i =1;
	cout<<"data = "<<n.data<<"no.of days = 1"<<endl;
	for (; it != v.end(); ++it)
	{
		while(!s.empty()&&s.top().data < *it){
			s.pop();
		}
		if (s.empty())
		{
			cout<<"data = "<<*it<<"no.of days = "<<i<<endl;
		}else{
			int x = s.top().date;
			cout<<"data = "<<*it<<"no.of days = "<<i-x<<endl;
		}
		n.data = *it;
		n.date = i;
		s.push(n);
		i++;
	}

	return 0;
}