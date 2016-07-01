// C++ Program to find decimal value of
// binary linked list
#include<iostream>
using namespace std;

/* Link list Node */
struct Node
{
	bool data;
	struct Node* next;
};

/* Returns decimal value of binary linked list */
// int decimalValue(struct Node *head)
// {
// 	// Initialized result
// 	int res = 0;

// 	// Traverse linked list
// 	while (head != NULL)
// 	{
// 		// Multiply result by 2 and add
// 		// head's data
// 		res = (res << 1) + head->data;

// 		// Move next
// 		head = head->next;
// 	}
// 	return res;
// }
long long unsigned int MOD = 1000000007;
long long unsigned int getDecimalValue(struct Node *head,int a[]){
    if(head == NULL){
        a[0] = 0;
        return 0;
    }
    long long unsigned int res = getDecimalValue(head->next,a);
    // res = res%MOD;
    return (((head->data*( 1 << a[0]++))%MOD) + res)%MOD;
}
// Should return decimal equivalent modulo 1000000007 of binary linked list 
long long unsigned int decimalValue(struct Node *head)
{
   // Your Code Here
   int a[0];
   a[0] = -1;
   int i = 0;
   long long unsigned int res = 0;
   while(head!=NULL){
   	res = (res << 1)+ head->data;
   	res = res%MOD;
   	head = head->next;
   }
   return  res;
}


// Utility function to create a new node.
Node *newNode(bool data)
{
	struct Node *temp = new Node;
	temp->data = data;
	temp->next = NULL;
	return temp;
}

/* Drier program to test above function*/
int main()
{
	/* Start with the empty list */
	struct Node* head = newNode(1);
	head->next = newNode(0);
	head->next->next = newNode(1);
	head->next->next->next = newNode(1);

	cout << "Decimal value is "
		<< decimalValue(head)<<endl;

	return 0;
}
