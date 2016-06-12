#include<iostream>
#include<cstdio>
#include<string>
using namespace std;

struct Node{
	int data;
	Node *next,*random;
	Node(int data=0){
		this->data = data;
		this->next = NULL;	
	}
};
void print(Node *root){
	while(root!=NULL){
		cout<<root->data<<" ";
		root = root->next;
	}
	cout<<endl;
}
Node * mergeSort(Node *head){
	// if head == null return
	// if head->next || head == null  return head;
	//split the linked list
	if (head == NULL || head->next == NULL)
	{
		return head;
	}
	// split
	Node *slow = head;
	Node *fast = head->next;
	while(fast!=NULL && fast->next!=NULL){
		fast = fast->next->next;
		slow = slow->next;
	}
	fast = slow->next;
	slow->next = NULL;
	cout<<"slow = "<< slow->data << " fast = "<< fast->data<<endl;
	// print(head);
	// print(fast);

	Node *left = mergeSort(head);
	Node *right = mergeSort(fast);
	Node *sorted = NULL;
	Node *sortedHead = NULL;
	if (left == NULL)
	{
		return right;
	}
	if(right == NULL){
		return left;
	}

	if (left->data <= right->data)
	{
		sortedHead = left;
		left = left->next;
		sortedHead->next = NULL;
	}else{
		sortedHead = right;
		right = right->next;
		sortedHead->next = NULL;
	}
	sorted = sortedHead;
	while(left!=NULL && right!=NULL){
		if (left->data <= right->data)
		{
			sorted->next = left;
			left = left->next;
			sorted = sorted->next;
			sorted->next = NULL;
		}else{
			sorted->next = right;
			right = right->next;
			sorted = sorted->next;
			sorted->next = NULL;
		}
	}
	if (left == NULL)
	{
		sorted->next = right;
	}
	if (right == NULL)
	{
		sorted->next = left;
	}
	// while(left!=NULL && right!=NULL){
	// 	if (sortedHead == NULL)
	// 	{
	// 		if (left->data == right->data)
	// 		{
	// 			sortedHead = left;
	// 			sorted = left;
	// 			left = left->next;
	// 			sorted->next = right;
	// 			right = right->next;
	// 			sorted = sorted->next;
	// 		}else{
	// 			if (left->data < right->data)
	// 			{
	// 				sortedHead = left;
	// 				left = left->next;
	// 				sortedHead->next = NULL;
	// 				sorted = sortedHead;
					
	// 			}else{
	// 				sortedHead = right;
	// 				right = right->next;
	// 				// right->next = NULL;
	// 				sortedHead->next = NULL;
	// 				sorted = sortedHead;
	// 			}
	// 		}
			
	// 	}else{
	// 		if (left->data == right->data)
	// 		{
	// 			sorted->next = left;
	// 			left = left->next;
	// 			sorted = sorted->next;
	// 			sorted->next = right;
	// 			sorted = sorted->next;
	// 			right = right->next;
	// 		}else{
	// 			if (left->data < right->data)
	// 			{
	// 				sorted->next = left;
	// 				left = left->next;
	// 				sorted = sorted->next;
	// 				sorted->next = NULL;
					
	// 			}else{
	// 				sorted->next = right;
	// 				sorted = sorted->next;
	// 				right = right->next;
	// 			}
	// 		}
			
	// 	}
	// 		// sorted = sorted->next;
	// 		sorted->next = NULL;
	// }
	// while(left!=NULL){
	// 	sorted->next = left;
	// 	left = left->next;
	// 	sorted = sorted->next;
	// 	sorted->next = NULL;
	// }
	// while(right!=NULL){
	// 	sorted->next = right;
	// 	right= right->next;
	// 	sorted = sorted->next;
	// 	sorted->next = NULL;
	// }
	return sortedHead;
}
int main(){

	Node *head = new Node(5);
	head->next = new Node(3);
	head->next->next = new Node(1);
	head->next->next->next = new Node(2);
	head->next->next->next->next = new Node(4);
	head->next->next->next->next->next = new Node(9);
	head->next->next->next->next->next->next = new Node(10);
	Node *sorted = mergeSort(head);
	print(sorted);
}

