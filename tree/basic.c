#include<stdio.h>
#include<stdlib.h>
struct node{
  int data;
  struct node* left;
  struct node* right;
};

struct node* newNode(int value){
  struct node* n = (struct node*)malloc(sizeof(struct node));
  n->data = value;
  n->left = NULL;
  n->right = NULL;
  return n;
}

// start from the root, visit all the nodes to the left, visit the node and visit all the nodes to the right
void inorder(struct node* node){
  if(node == NULL){
    return;
  }
  inorder(node->left);
  printf("%d ", node->data);
  inorder(node->right);
}
// for every node, visit the node, visit all the node to its left, vist all the nodes to its right
void preorder(struct node* node){
  if(node == NULL){
    return;
  }
  printf("%d ", node->data);
  preorder(node->left);
  preorder(node->right);

}
void postorder(struct node* node){
  if (node == NULL) {
    return;
  }
  postorder(node->left);
  postorder(node->right);
  printf("%d ",node->data);
}
int areIdentical(struct node* tree1, struct node* tree2){
  if (tree1 == NULL && tree2 == NULL) {
    return 1;
  }
  if(tree1->data == tree2->data && areIdentical(tree1->left, tree2->left) && areIdentical(tree1->right, tree2->right)){
    return 1;
  }
  return 0;
}

int areSimilar(struct node* tree1, struct node* tree2){
  if(tree1 == NULL && tree2 == NULL){
    return 1;
  }
  if(tree1 != NULL && tree2 != NULL){
    return (areSimilar(tree1->left, tree2->left)&& areSimilar(tree1->right, tree2->right));
  }
  return 0;
}

int height(struct node* current){
  if (current == NULL) {
    return 0;
  }
  return 1 + max(height(current->left), height(current->right));
}
int max(int a, int b){
  if(a > b){
    return a;
  }
  return b;
}


int main(){
  struct node* root = newNode(5);
  root->left = newNode(4);
  root->right = newNode(6);
  root->left->left = newNode(3);
  // tree 2
  struct node* root2 = newNode(5);
  root2->left = newNode(4);
  root2->right = newNode(6);
  root2->left->left = newNode(3);
  // int result = areIdentical(root, root2);
  // int result = areSimilar(root, root2);
  // int result = height(root);
  // printf("%d\n", result);
  // printf("root = %d\n", root->data);
  // printf("left = %d\n", root->left->data);
  // printf("right = %d\n", root->right->data);
  // printf("left left = %d\n", root->left->left->data);
  // inorder(root);
  // printf("\n");
  // preorder(root);

}
