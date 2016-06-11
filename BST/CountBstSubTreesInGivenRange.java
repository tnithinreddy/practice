import java.util.*;
public class CountBstSubTreesInGivenRange{
	public static void inorder(Node node){
	  if(node == null){
	    return;
	  }
	  inorder(node.left);
	  System.out.print(node.data + " ");
	  inorder(node.right);
	}
	public static void print(Node root){
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		q.add(null);
		Node curr;
		while(!q.isEmpty()){
			curr = q.remove();
			if (curr == null) {
				System.out.println();	
				if (q.isEmpty()) {
					break;
				}
				q.add(null);
				continue;
			}
			System.out.print(curr.data + " ");
			if (curr.left!=null) {
				q.add(curr.left);
			}
			if (curr.right!=null) {
				q.add(curr.right);
			}
		}
	}
	static int min,max,count;
	public static void main(String[] args) {
		Node root = new Node(6);
		root.left = new Node(-13);
		root.right = new Node(14);
		root.left.right = new Node(-8);
		root.right.left = new Node(13);
		root.right.right = new Node(15);
		root.right.left.left = new Node(7);
		inorder(root);
		System.out.println();
		int k1 = -100, k2 = 90;
		int c = countSubtrees(root,k1,k2);
	}
	public static int countSubtrees(Node root,int k1,int k2){
		count = 0;
		int c = getCount(root,k1,k2);
		System.out.println("count = " + c);
		return c;
	}
	public static int getCount(Node root, int k1,int k2){
		if (root == null) {
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			return 0;
		}
		int leftCount = getCount(root.left,k1,k2);
		int leftMin = min;
		int leftMax = max;
		if (leftMin == Integer.MAX_VALUE) {
			leftMin = min = root.data;
		}
		if (leftMax == Integer.MIN_VALUE) {
			leftMax = max = root.data;
		}
		int rightCount = getCount(root.right,k1,k2);
		int rightMin = min;
		int rightMax = max;
		min = leftMin;
		max = rightMax;
		if (rightMin == Integer.MAX_VALUE) {
			rightMin = min = root.data;
		}
		if (rightMax == Integer.MIN_VALUE) {
			rightMax = max = root.data;
		}
		if (root.data >= k1 && root.data<=k2 && leftMin>=k1 && rightMin<=k2) {
			System.out.println("data = " + root.data);
			leftCount++;
		}
		return leftCount + rightCount;
	}
}