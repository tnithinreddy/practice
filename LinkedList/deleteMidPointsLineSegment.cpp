#include <iostream>
#include<stack>
#include<cstdlib>

using namespace std;
struct Node{
  int x,y;
  Node *next;
  Node(int x=0, int y=0)
  {
    this->x = x;
    this->y = y;
    this->next = NULL;
  }
};
void print(Node *current){
  while (current!=NULL) {
    cout<<"("<< current->x << ","<<current->y<<"), ";
    current = current->next;
  }
  cout<<"\n";
}
int getOrientation(Node *ptr1, Node *ptr2){
	if (ptr1->x == ptr2->x)
	{
		return 0;
	}
	return 1;
}

void removeMiddle(Node *head){
	if (head == NULL || head->next == NULL)
	{
		return;
	}
	int prevOrientation = getOrientation(head, head->next);
	Node *curr = head->next->next;
	Node * start = head;
	Node *end = head->next;
	int currentOrientation;
	while(curr != NULL){
		currentOrientation = getOrientation(end, curr);
		if(currentOrientation == prevOrientation){
			start->next = curr;
			free(end);
			end = curr;
		}else{
			start = end;
			end = curr;
			prevOrientation = currentOrientation;
		}
		curr = curr->next;
	}
	print(head);
	return;
}



int  main(int argc, char const *argv[])
{
	  Node *head = new Node(0,10);
	  head->next = new Node(1,10);
	  head->next->next = new Node(3,10);
	  head->next->next->next = new Node(10,10);
	  head->next->next->next->next = new Node(10,8);
	  head->next->next->next->next->next = new Node(10,5);
	  head->next->next->next->next->next->next = new Node(20,5);
	  head->next->next->next->next->next->next->next = new Node(40,5);
	  print(head);
	  removeMiddle(head);

	return 0;
}