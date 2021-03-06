import java.util.*;

public class Mindepth{
  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    // root.right.left = new Node(6);
    // root.right.right = new Node(7);
    // root.right.right.right = new Node(22);
    int res = mindepth(root);
    System.out.println("result = "+ res);
  }
  public static int mindepth(Node root){
    if (root  == null) {
      return 0;
    }
    int left = mindepth(root.left);
    int right = mindepth(root.right);
    return (1 + (left < right ? left:right));
  }
}
