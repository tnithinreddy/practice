#include<string>
#include<iostream>
using namespace std;

int main(int argc, char const *argv[])
{
	string s1 = "hello";
	for (int i = 0; i < s1.size(); ++i)
	{
		
	}
	for (string::iterator it = s1.begin();it!=s1.end();it++)
	{
		cout<<*it;
		*it = 'c';
	}
	cout<<endl<<s1;
	return 0;
}