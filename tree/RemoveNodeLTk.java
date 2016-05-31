import java.util.*;

public class RemoveNodeLTk {
  public static Map<Integer,Integer> map = new HashMap<Integer,Integer>();
  public static void main(String[] args) {
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
    ArrayList<Integer> list = new ArrayList<Integer>();
    traverseTillLeaf(root, list);
    System.out.println(map);

  }
  public static void traverseTillLeaf(Node root, ArrayList<Integer> list){
    list.add(root.data);
    if (root.left == null && root.right == null) {
      // fill the dictionary
      int current;
      int inMap ;
      for (int i =0; i < list.size() ;i++ ) {
        current = list.get(i);
        if (  map.get(current)== null) {
          map.put(current, list.size());
        } else {
          if (map.get(current) < list.size()) {
            map.put(current, list.size());
          }
        }

      }
    }
    if (root.left!=null) {
      traverseTillLeaf(root.left, list);
    }
    if (root.right!=null) {
      traverseTillLeaf(root.right, list);
    }
    list.remove(list.size()-1);
  }
}
