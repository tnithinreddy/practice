import java.util.*;
abstract class TreeListRecursion {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    root.right.right.right = new Node(22);


  }
 
  public static void inorder(Node root){

  }

  public static Node getLeftListTail(Node root){
    if (root == NULL) {
      return NULL;
    }
    
  }

  public static Node treeToDLL(Node root){
    if (root == NULL) {
      return NULL;
    }
    Node leftTail = getLeftListTail(root->left);
    Node rightHead = getRightHead(root->right);
    root->left = leftTail;
    root->right = rightHead;
    if (leftTail != NULL) {
      leftTail->right = root;
    }
    if (rightHead != NULL) {
      rightHead->left = root;
    }
  }
}
