import java.util.*;
abstract class TreeDLL {
  static Node prev = null;
      static Node head = null;

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    root.right.right.right = new Node(22);
    inorder(root);
          System.out.println( );
    while(head!=null){

      System.out.print( head.data +" ");
      head = head.right;
    }
  }
 
  public static void inorder(Node root){
    if (root == null) {
      return ;
    }

    inorder(root.left);
          System.out.print( root.data +" ");
    if (prev == null) {
      head = root;
      
    } else {
      prev.right = root;
      root.left = prev;
    }
    
    prev = root;
    inorder(root.right);
    
  }
}
