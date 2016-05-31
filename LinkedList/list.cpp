#include <iostream>
#include<stack>

using namespace std;
struct Node{
  int data;
  Node *next;
  Node(int val=0)
  {
    data = val;
    next = NULL;
  }
};

void insert(Node **head, int data){
  Node *n = new Node(data);
  n->next = *head;
  *head = n;
}

void insertAfter(Node *node, int data){
  Node *n = new Node(data);
  n->next = node->next;
  node->next = n;
}

void print(Node *current){
  while (current!=NULL) {
    cout<< current->data << " ";
    current = current->next;
  }
  std::cout << std::endl;
}

void deleteNode(int key, Node **head){
  if (*head == NULL) {
    return ;
  }
  Node * current  = *head;
  Node *prev = *head;
  if (current->data == key) {
    // delete head
    *head = (*head)->next;
    return;
  }
  current = current->next;
  while (current!=NULL) {
    if (current->data == key) {
      prev->next = current->next;
      return;
    }
    current = current->next;
    prev = prev->next;
  }
  return;
}

void deleteNodeFromPosition(int pos, Node **head){
  if (pos<0 || *head == NULL) {
    return;
  }
  Node *current = *head;
  int i =0;
  if (pos == 0) {
    *head = (*head)->next;
    current = current->next;
    return;
  }
  Node * prev = current;
  current = current->next;
  i++;
  while (current!=NULL) {
    if (pos == i) {
      // found
      prev->next = current->next;
      return;
    }
    i++;
    current = current->next;
    prev = prev->next;
  }
}

void swapNodes(int a, int b, Node **head) {
  // find a find b, also note prev pointers
  // Node * current = *head;
  // Node *first,*second;
  // if (current->data == a) {
  //   first = *head;
  //   second = findNode();
  // }
  // if (current->data == b) {
  //   first = *head;
  //   second = findNode();
  // }
  // first = findOther();
  // second = findOther();
}

void printMiddle(Node *fast){
  if (fast==NULL) {
    std::cout << "not found" << std::endl;
    return;
  }
  Node * slow = fast;
  while (fast!=NULL) {
    if (fast->next == NULL) {
       std::cout << slow->data << std::endl;
       return;
    }
    fast = fast->next;
    fast = fast->next;
    slow = slow->next;
  }
  std::cout << slow->data << std::endl;
}

void reverse(Node **head){
  if (*head == NULL ) {
    return;
  }
  Node *ptr1 = *head;
  Node *ptr2 = ptr1->next;
  Node *next;
  while (ptr2 != NULL) {
    next = ptr2->next;
    ptr2->next = ptr1;
    ptr1 = ptr2;
    ptr2 = next;
  }
  (*head)->next = NULL;
  *head = ptr1;
}
//
// Node *merge(Node *head1, Node* head2){
//   Node *head ;
//   if (head1 == NULL && head2 == NULL) {
//     return NULL;
//   }
//   if (head1 == NULL) {
//     return head2;
//   }
//   if (head2 == NULL) {
//     return head1;
//   }
//   while (head1 != NULL && head2 != NULL) {
//     if (head1->data < head2->data) {
//       add(head1);
//       head1 = head1->next;
//     } else{
//       add(head2);
//       head2 = head2->next;
//     }
//   }
//   if (head1 == NULL) {
//     while (head2!=NULL) {
//       add(head2);
//       head2 = head2->next;
//     }
//   } else{
//     while (head1!=NULL) {
//       add(head1);
//       head1 = head1->next;
//     }
//   }
// }

bool palindrome(Node *head){
  // go till the middle
  if (head == NULL) {
    return false;
  }
  Node *slow = head;
  // Node *fast = head;
  // while (fast != NULL && fast->next!=NULL) {
  //   fast = fast->next->next;
  //   slow = slow->next;
  // }
  // std::cout << "slow->data" << slow->data<<std::endl;
  // Stack
  // return false;
  std::stack<int> myStack;
  while (slow!=NULL) {
    myStack.push(slow->data);
    slow = slow->next;
  }
  slow = head;
  while (slow != NULL) {
    int data = myStack.top();
    myStack.pop();
    if (data != slow->data) {
      std::cout << "not a palindrome" << std::endl;
       return false;
    }
    slow = slow->next;
  }
  std::cout << "yes it is" << std::endl;
  return true;
}
bool utilPalindrome(Node **left, Node *right){
  if (right == NULL) {
    return true;
  }
  bool prev = utilPalindrome(left, right->next);
  if (prev == false) {
    return false;
  }
  bool a = ((*left)->data) == right->data;
  *left = (*left)->next;
  return a;

}
bool palindromeRecursive(Node *head){
  bool r =  utilPalindrome(&head, head);
  std::cout << "palindrome " <<r<< std::endl;
  return r;
}

void deleteDuplicate(Node **head){
  if (*head == NULL) {
     return;
  }
  Node *ptr = (*head)->next;
  Node *prev = *head;
  while (ptr!=NULL) {
    if (ptr->data == prev->data) {
      prev->next = ptr->next;
      temp = ptr;
      ptr = ptr->next;
      free(temp);
    } else{
      ptr = ptr->next;
      prev = pre->next;
    }
  }
}

int main(){
  Node *head = new Node(5);
  insert(&head, 6);
  // head->next->next = new Node(8);
  // print(head);
  insertAfter(head->next,7);
  insert(&head, 1);
  insert(&head, 6);
  insert(&head, 5);
  insert(&head, 7);

  // print(head);
  // deleteNode(6, &head);
  // std::cout << "before" << std::endl;
  // print(head);
  // deleteNodeFromPosition(2, &head);
  // std::cout << "after" << std::endl;
  // print(head);
  // reverse(&head);
  print(head);
  palindrome(head);
  palindromeRecursive(head);
}
