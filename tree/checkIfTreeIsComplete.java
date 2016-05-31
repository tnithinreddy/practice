import java.util.*;
abstract class hack{
  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    boolean result = checkIfComplete(root);// binary heap is complete tree
    System.out.println(result);
  }

  public static boolean checkIfComplete(Node root){
    Queue<Node> q = new LinkedList<Node>();
    if (root == null) {
      return true;
    }
    q.add(root);
    Node current;
    boolean full = false;
    boolean start = false;
    while(!q.isEmpty()){
      current = q.remove();
      // check if full
      if (current.left != null) {
        q.add(current.left);
      }
      if (current.right != null) {
        q.add(current.right);
      }
      full = checkIfNodeIsFull(current);
      if (full == false && start == false) {
        start = true;
      }
      if (start == true && full == true) {
        return false;
      }
      if (start == true && full == false) {
        if (current.left == null && current.right !=null) {
          return false;
        }
      }
    }
    return true;
  }

  public  static boolean checkIfNodeIsFull(Node current){
    if (current.left!= null && current.right!=null) {
      return true;
    }
    return false;
  }
}
