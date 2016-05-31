import java.util.*;

public class VerticalOrderTraversal{
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
    Map<Integer,ArrayList<Integer>> multiMap = new HashMap<Integer,ArrayList<Integer>>();
    verticalTraversal(root, 0, multiMap);
    Set<Integer> s = multiMap.keySet();
    TreeSet myTreeSet = new TreeSet();
    myTreeSet.addAll(s);
    Iterator it = myTreeSet.iterator();
    while(it.hasNext()){
      System.out.println(multiMap.get(it.next()));
      // multiMap.get(it);
    }

    // for (int i = 0;i< myTreeSet.size() ; i++ ) {
    //   System.out.print(myTreeSet);
    // }
  }
  public static void verticalTraversalLeverOrder(){

  }
  public static void verticalTraversal(Node root, int hd, Map<Integer,ArrayList<Integer>> multiMap){
    // get the element with the value add and the send it back
    if (root == null) {
      return;
    }
    ArrayList<Integer> current = multiMap.get(hd);
    if (current == null) {
      current = new ArrayList<Integer>();
    }
    current.add(root.data);
    multiMap.put(hd, current);
    verticalTraversal(root.right, hd + 1, multiMap);
    verticalTraversal(root.left, hd - 1, multiMap);

  }
}
