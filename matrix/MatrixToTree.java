import java.util.*;
public class MatrixToTree{

	public static class Node{
		int data;
		Node left,right;
		public Node(int a){
			this.data = a;			
		}
	}
	public static void inorder(Node root){
		if (root == null) {
			return ;
		}
		inorder(root.left);
		System.out.println(root.data );
		inorder(root.right);
	}
	public static void main(String[] args) {
		int a[][] = {
			{ 0, 0, 0, 0, 0, 0 },
	        { 1, 0, 0, 0, 1, 0 },
	        { 0, 0, 0, 1, 0, 0 },
	        { 0, 0, 0, 0, 0, 0 },
	        { 0, 0, 0, 0, 0, 0 },
	        { 1, 1, 1, 1, 1, 0 }
		};

		TreeMap<Integer,LinkedList<Integer>> map = new TreeMap<Integer,LinkedList<Integer>>();
		int rows = 6,count;
		for (int i = 0;i < rows ;i++ ) {
			count  = 0;
			for (int j = 0 ;j < rows ;j++ ) {
				if (a[i][j] == 1) {
					count++;
				}
			}
			LinkedList<Integer> list = map.get(count);
			if (list == null) {
				list = new LinkedList<Integer>();
				list.add(i);
				map.put(count,list);							
			}else{
				list.add(i);
				map.put(count,list);
			}
		}
		Set<Integer> set = map.keySet();
		int parent[] = new int[rows];
		Node nodes[] = new Node[rows];
		Arrays.fill(parent,-1);
		Node root = null;
		for (Integer key : set) {
			LinkedList<Integer> list = map.get(key);
			for (Integer in : list) {
				int intValue = in.intValue();
				Node n = new Node(intValue);
				nodes[intValue] = n;
				for (int  i = 0;i<rows;i++ ) {
					if(a[intValue][i] == 1 && parent[i] == -1){
						// System.out.println("parent of " + i + " is null" + intValue);
						if (n.left == null) {
							n.left = nodes[i];
							parent[i] = intValue;
						}else{
							n.right = nodes[i];
							parent[i] = intValue;

						}
					}
				}
				root  = n;
			}
		}
		inorder(root);
	}
}