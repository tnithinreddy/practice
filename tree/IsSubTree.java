// http://www.cc.iitd.ernet.in/cgi-bin/proxy.mtech
import java.util.*;
public class IsSubTree{
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
          //           1
          //       2       3
          //   4      5 6     7
          // 8    10
          //         15
    Node root2 = new Node(4);
    root2.left = new Node(8);
    root2.right =new Node(10);
    root2.right.right = new Node(15);
    boolean isSub = isSubTree(root, root2);
    System.out.println("answer = " + isSub);
  }
  public static boolean isSubTree(Node root1, Node root2){
      // find root2 in tree1
      Node result = findRoot(root1, root2);
      // System.out.println("root1 = " + root1.data + " result = " + result.data);
      // root2 and result
      return checkIfSame(result, root2);

  }
  public static boolean checkIfSame(Node root1, Node root2){
    if (root1 == root2 && root1 == null) {
      return true;
    }
    if (root1 != null && root2!=null) {
      if (root1.data ==root2.data) {
        return true && checkIfSame(root1.left, root1.left) && checkIfSame(root1.right, root2.right);
      }
    }
    return false;
  }
  public static Node findRoot(Node root1, Node root2){
    if (root1 == null) {
      return null;
    }
    if (root2.data == root1.data ) {
      return root1;
    }
    Node fromLeft = findRoot(root1.left, root2);
    if (fromLeft != null) {
      return fromLeft;
    }
    Node fromRight = findRoot(root1.right, root2);
    if (fromRight !=null ) {
      return fromRight;
    }
    return null;
  }
}
