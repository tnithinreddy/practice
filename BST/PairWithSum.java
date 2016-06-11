import java.util.*;
public class PairWithSum{
	public static void inorder(Node node){
	  if(node == null){
	    return;
	  }
	  inorder(node.left);
	  System.out.print(node.data + " ");
	  inorder(node.right);
	}
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
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		Node n1 = root,n2 = root;
		int sum = 0;
		int done1 = 0,done2=0;
		while(true){
			
			if (done1 == 0) {
				if (!s1.isEmpty()) {
					n1 = s1.pop();
					n1 = n1.right;
				}
				while(n1!=null){
					s1.push(n1);
					n1 = n1.left;
				}
				done1 = 1;	
			}			
			if (done2==0) {
				if (!s2.isEmpty()) {
					n2 = s2.pop();
					n2 = n2.left;
				}
				while(n2!=null){
					s2.push(n2);
					n2 = n2.right;
				}

				done1 = 1;
			}
			if (s1.isEmpty() || s2.isEmpty()) {
				System.out.println("not found");
				break;
			}
			int val1 = s1.peek().data;
			int val2 = s2.peek().data;
			System.out.println("val1 = " + val1 + "val2 = " + val2);
			if (val2 + val1 == sum) {
				System.out.println("found");
				break;	
			}
			if (val1+val2 > sum) {
				done2 = 0;
			}
			if (val1+val2 < sum) {
				done1 = 0;
			}

		}
	}
}