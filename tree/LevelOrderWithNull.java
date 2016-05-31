import java.util.*;
public class LevelOrderWithNull{
  public static void main(String[] args){
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.left.right = new Node(10);
    root.left.left.right.right = new Node(15);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    root.left.left.left = new Node(8);
    levelOrderWithNull(root);
  }
  public static void levelOrderWithNull(Node root){
    if (root == null) {
      return;
    }
    Queue<Node> q = new LinkedList<Node>();
    q.add(root);
    q.add(null);
    // System.out.print(q);
    Node current;
    int currentNodes = 0, maxNodes = 0;
    while(!q.isEmpty()){
      current = q.remove();
      if (current == null) {
        if (currentNodes > maxNodes) {
          maxNodes = currentNodes;
        }
        if (q.size()!=0) {
          q.add(null);
        }
        currentNodes = 0;
        System.out.println();
        continue;
      }
      currentNodes++;
      System.out.print(current.data + " ");
      if (current.left!=null) {
        q.add(current.left);
      }
      if (current.right!=null) {
        q.add(current.right);
      }
    }
    System.out.println("max nodes = " + maxNodes);
  }
}
