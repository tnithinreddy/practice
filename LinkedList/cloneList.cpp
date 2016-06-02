#include<iostream>
#include<cstdio>
#include<string>
using namespace std;

struct Node{
	int data;
	Node *next,*random;
	Node(int data=0){
		this->data = data;
		this->next = this->random = NULL;	
	}
};
// Node * clone(Node *head){
// 	if (head == NULL)
// 	{
// 		return NULL;
// 	}
	
// }
int main(){
	string s = "";
	// Node *head = new Node(5);
	// head->next = new Node(3);
	// head->next->next = new Node(1);
	// head->next->next->next = new Node(2);
	// head->next->next->next->next = new Node(4);
	// head->next->next->next->next->next = new Node(9);
	// Node *newList = clone(head);
}

