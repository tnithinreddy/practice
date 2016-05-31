import java.util.*;
abstract class TreeDLL {
  static Node prev;
  static Node last;
  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    root.right.right.right = new Node(22);
    prev = null;
    last = null;
    inorder(root);
    Node current;
    current = prev;
    current.right = null;
    current = current.left;
    while(current!=null){
      current.right = prev;
      current = current.left;
      prev = prev.left;
    }
    current = prev;
    while(current!=null){
      System.out.println(current.data);
      prev = current;
      current = current.right;
    }

  }
  public static Node toDll(Node root){
    if (root == null) {
      return root;
    }
    // convert left subtree to DLL
    // find predecessor and attach it to root
    if (root.left != null) {
      // predecessor is rightmost in left subtree
    }
    // convert right subtree to DLL
    // find successor and attach it to root
    if (root.right != null) {
      // successor is leftmost in right subtree

    }
    return root;
  }
  public static void setLeftPtr(){

  }
  public static void inorder(Node root){
    if (root == null) {
      return;
    }
    inorder(root.left);
    root.left = prev;
    prev = root;
    inorder(root.right);

  }
}
