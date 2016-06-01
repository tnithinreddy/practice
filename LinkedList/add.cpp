#include <iostream>
using namespace std;

struct Node{
	int data;
	Node *next;
	Node(int d){
		this->data = d;
		this->next = NULL;
	}
};

void print(Node *current){
  while (current!=NULL) {
    cout<< current->data << " ";
    current = current->next;
  }
  cout<<"\n";
}

Node * sum(Node *a, Node *b, int a1, int b1, int *carryPtr){
	if (a == NULL && b== NULL)
	{
		/* code */
		return NULL;
	}

	Node * curr = new Node(0);
	int carry = 0;
	int *c = &carry;
	if (a1 > b1)
	{
	
		curr->next = sum(a->next,b,a1-1,b1,c);
		curr->data = a->data+carry;

	}else{
		curr->next = sum(a->next,b->next,a1,b1,c);
		curr->data = a->data + b->data+carry;

		
	}
	*carryPtr = curr->data/10;
	curr->data = curr->data%10;
	return curr;
}

int size(Node *x){
	int c = 0;
	while(x!=NULL){
		c++;
		x = x->next;
	}
	return c;
}

Node * getSumHead(Node *a, Node*b){
	int a1 = size(a);
	int b1 = size(b);
	Node *newHead =NULL;
	int carry=0;
	int *carryPtr = &carry;
	if (a1>b1)
	{
	newHead = sum(a,b,a1,b1,carryPtr);	
	} else{
			newHead = sum(b,a,b1,a1,carryPtr);	
	}
	if (carry>0)
	{
		Node * n = new Node(carry);
		n->next = newHead;
		newHead = n;
	}
	return newHead;
}

int main(){
	Node *a = new Node(4);
	a->next = new Node(7);
	a->next->next = new Node(9);
	a->next->next->next = new Node(6);
	// 4796
	//  179
	print(a);
	Node *b = new Node(1);
	b->next = new Node(7);
	b->next->next = new Node(9);
	b->next->next->next = new Node(0);
	Node * nh = getSumHead(a,b);
	print(nh);
}