import java.util.*;
public class DLLtoTree{
	public static Node head;
	public static Node headDll;
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
	public static void main(String[] args) {
		Node root = new Node(6);
		root.left = new Node(-13);
		root.right = new Node(14);
		root.left.left = new Node(-8);
		root.right.left = new Node(13);
		root.right.right = new Node(15);
		root.right.left.left = new Node(7);
		// inorder(root);
		System.out.println();
		// convert to dll and get head and tail pointers
		//then traverse and look for the sum
		// convert the DLL back to tree
		Node []pointers = new Node[2];
		pointers[0]=pointers[1]=null;
		treeToDLL(pointers,root);
		Node curr = pointers[1];
		while(curr!=null){
			System.out.print(curr.data+ " ");
			curr = curr.left;
		}
		curr = head;
		System.out.println();
		while(curr!=null){
			System.out.print(curr.data+ " ");
			curr = curr.right;
		}
		int n=0;
		curr = head;
		while(curr!=null)
{
			n++;
			curr = curr.right;
}		headDll = head;
		Node newRoot = dlltoTree(n);
		inorder(newRoot);
		System.out.println("done");
		print(newRoot);

		
	}
	public static Node dlltoTree(int num){
		// 
		if (headDll == null) {
			return null;
		}

		if (num<=0) {
			return null;
		}

		Node n;

		Node leftRoot = dlltoTree(num/2);
		n = headDll;
		n.left = leftRoot;
		headDll = headDll.right;
		Node rightRoot = dlltoTree(num-num/2-1);
		n.right = rightRoot;;		
		return n;

	}
	public static void treeToDLL(Node[] pointers, Node root){
		if (root == null) {
			return ;
		}
		pointers[1] = root;
		treeToDLL(pointers,root.left);
		if (head == null) {
			head = root;
		}
		root.left = pointers[0];
		if (pointers[0]!=null) {
		pointers[0].right = root;
			
		}
		pointers[0] = root;
		treeToDLL(pointers,root.right);
	}
	public static void inorder(Node node){
	  if(node == null){
	    return;
	  }
	  inorder(node.left);
	  System.out.print(node.data + " ");
	  inorder(node.right);
	}
}