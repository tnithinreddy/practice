import java.util.*;
import java.lang.*;
public class MaxSumPath{
	static int max;
	public static void main(String[] args) {
		Node root = new Node(-15);
	    root.left = new Node(5);
	    root.right = new Node(6);
	    root.left.left = new Node(-8);
	    root.left.right = new Node(1);
	    root.left.left.left = new Node(2);
	    root.left.left.right = new Node(6);
	    root.right.left = new Node(3);
	    root.right.right = new Node(9);
	    root.right.right.right= new Node(0);
	    root.right.right.right.left= new Node(4);
	    root.right.right.right.right= new Node(-1);
	    root.right.right.right.right.left= new Node(10);
	    max = Integer.MIN_VALUE;
	    maxPathSumLeafToLeaf(root);
	    System.out.println(max);
	}

	public static int maxPathSumLeafToLeaf(Node root){
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return root.data;
		}
		int leftSum = maxPathSumLeafToLeaf(root.left);
		int rightSum = maxPathSumLeafToLeaf(root.right); 
		int total = leftSum + rightSum + root.data;
		if (total > max && root.left!=null && root.right!=null) {
			max = total;
		}
		if (leftSum > rightSum) {
			return root.data + leftSum;
		}else{
			return root.data + rightSum;
		}
	}

	public static int maxPathSum(Node root){
		if (root == null) {
			return 0;
		}
		int leftSum = maxPathSum(root.left);
		int rightSum = maxPathSum(root.right);

		



	}
}