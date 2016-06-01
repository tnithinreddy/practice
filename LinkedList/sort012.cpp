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

Node * sort(Node *head){
	if (head ==NULL)
	{
		return NULL;
		/* code */
	}
	Node *ones = NULL;
	Node *twos = NULL;
	Node *threes = NULL;
	Node *curr = head;
	Node *next = curr;
	while(curr!=NULL){
		next = curr->next;
		if (curr->data == 0)
		{
			if (ones == NULL)
			{
				ones = curr;
				ones->next = NULL;
				// first->next;
			}else{
				curr->next = ones;
				ones = curr;
			}
		}
		if (curr->data == 1)
		{
			if (twos == NULL)
			{
				twos = curr;
				twos->next = NULL;
				// first->next;
			}else{
				curr->next = twos;
				twos = curr;
			}
		}
		if (curr->data == 2)
		{
			if (threes == NULL)
			{
				threes = curr;
				threes->next = NULL;
				// first->next;
			}else{
				curr->next = threes;
				threes = curr;
			}
		}
		curr = next;
	}
	print(ones);
	print(twos);
	print(threes);
	return NULL;
}

int main(){
	  Node *head = new Node(2);
	  head->next = new Node(0);
	  head->next->next = new Node(1);
	  head->next->next->next = new Node(2);
	  head->next->next->next->next = new Node(0);
	  head->next->next->next->next->next = new Node(1);
	  head->next->next->next->next->next->next = new Node(2);
	  sort(head);
}	