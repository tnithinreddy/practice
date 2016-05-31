import java.util.*;
/*
   class Node
       int data;
       Node left;
       Node right;
*/
// void print_left(Node root){
//   if(root == null)
//      return;
//   print_left(root.left);
//   System.out.print(root.data + " ");
// }
//
// void print_right(Node root){
//     if(root == null)
//         return;
//     System.out.print(root.data + " ");
//     print_right(root.right);
//
// }
// void top_view(Node root)
// {
//   //print all left nodes
//   if(root == null)
//       return;
//   print_left(root.left);
//   System.out.print(root.data + " ");
//   print_right(root.right);
//   // print all right nodes
// }
public class RootToLeaf{
  public static void main(String[] args){
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    root.left.left.left = new Node(8);
    LinkedList<Integer> l = new LinkedList<Integer>();
    LCA(Integer.parseInt(args[0]), Integer.parseInt(args[1]), root);
    // printTree(root, l);
  }
  public static void printTree(Node root, LinkedList l){
    if (root == null) {
      return;
    }
    l.add(root.data);
    if(root.left == null && root.right == null){
      for (int i = 0; i < l.size() ; i++) {
        System.out.print(l.get(i) + " ");
      }
      System.out.println();
      l.removeLast();
      return;
    }
    printTree(root.left, l);
    printTree(root.right, l);
    l.removeLast();
  }
  public static boolean rootToNode(int k, Node root, LinkedList l){
    if (root == null) {
      return false;
    }
    l.add(root.data);
    if (root.data == k) {
      return true;
    }
    if(rootToNode(k,root.left,l)||rootToNode(k,root.right,l)){
      return true;
    }
    l.removeLast();
    return false;
  }
  public static void LCA(int v1, int v2, Node root){
    // traverse and look for v1 and return the
    LinkedList<Integer> l1 = new LinkedList<Integer>();
    boolean found1 = rootToNode(v1, root, l1);
    System.out.println("searched for " + v1 + " path = " + l1.toString());
    LinkedList<Integer> l2 = new LinkedList<Integer>();
    boolean found2 = rootToNode(v2, root, l2);
    System.out.println("searched for " + v2 + " path = " + l2.toString());
    if (found1 == false || found2 == false) {
      System.out.println("no LCA");
      return ;
    }
    int i = 0;
    for ( i = 0; i < l1.size() && i< l2.size(); i++ ) {
      if (l1.get(i) != l2.get(i)){
        break;
      }
    }
    System.out.println(l1.get(i-1));

  }
}
