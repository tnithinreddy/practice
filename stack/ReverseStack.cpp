#include <stack>
#include<iostream>
using namespace std;


void insertAtBottom(int data,stack<int>& s){
	if (s.empty())
	{	
		// cout<<s.size()<<" ";
		// cout<<"insertAtBottom = "<<data<<endl;
		s.push(data);
		// cout<< s.top()<<endl;
		return;
	}
	int d = s.top();
	s.pop();
	insertAtBottom(data,s);
	s.push(d);
	return;

}

void reverse(stack<int>& s){
	// x = 5;
	// cout<<s.size()<<endl;
	if (s.empty())
	{
		return;
	} else{		
	 	int data = s.top();
	 	s.pop();
	 	reverse(s);
	 	insertAtBottom(data,s);
	 // 	while(!s.empty() && data == 6){
		// 	cout<<s.top()<<endl;
		// 	s.pop();
		// }
	}
}

void fun(int& x){
	cout<< x<<" ";
	if (x == 10)
	{
		return;
		/* code */
	}
	x++;
	fun(x);
}
int main(){
	stack<int> s;
	s.push(1);
	s.push(2);
	s.push(3);
	s.push(4);
	s.push(5);
	s.push(6);
	int x = 4;
	// fun(x);
	reverse(s);
	cout<<"final\n";
	while(!s.empty()){
		cout<<s.top()<<endl;
		s.pop();
	}
	cout<<"\n";
	// cout<<x;
}

