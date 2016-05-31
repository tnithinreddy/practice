#include <stdio.h>
#include<stdlib.h>

struct Node
{
  struct Node *left;
   struct Node *right;
  int data;
};

struct Node* newNode(int data){
  struct Node *n = (struct Node*)malloc(sizeof(struct Node));
   n->left = NULL;
   n->right = NULL;
   n->data = data;
   return n;
}
// if level is less than k(4) remove
struct Node* removeTillK(struct Node* root, int level, int k)
{
  if (root == NULL) {
    return NULL;
  }
  root->left = removeTillK(root->left, level+1, k);
  root->right = removeTillK(root->right, level+1, k);
  printf("%d %d\n", level, root->data);
  if (root->left == NULL && root->right == NULL && level < k) {
    free(root);
    printf("yes\n");
    return NULL;
  }
  return root;
}
void inorder(struct Node* node){
  if(node == NULL){
    return;
  }
  inorder(node->left);
  printf("%d ", node->data);
  inorder(node->right);
}
int main(){
  // Node root(1);
  int k;
  struct Node* root = newNode(1);
  root->left = newNode(2);
  root->right = newNode(3);
  root->left->left = newNode(4);
  root->left->right = newNode(5);
  root->right->left = newNode(6);
  root->right->right = newNode(7);
  root->left->left->left = newNode(8);
  root->left->left->right = newNode(10);
  root->left->left->right->right = newNode(15);
  inorder(root);
  printf("\n");
  root = removeTillK(root, 1, 4);
  printf("\n");
  inorder(root);
  printf("\n");
  // printf("%d\n",root.dat );
}
