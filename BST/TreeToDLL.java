import java.util.*;
public class TreeToDLL{
	public static Node head;
	public static void main(String[] args) {
		Node root = new Node(6);
		root.left = new Node(-13);
		root.right = new Node(14);
		root.left.left = new Node(-8);
		root.right.left = new Node(13);
		root.right.right = new Node(15);
		root.right.left.left = new Node(7);
		inorder(root);
		System.out.println();
		// convert to dll and get head and tail pointers
		//then traverse and look for the sum
		// convert the DLL back to tree
		Node []pointers = new Node[2];
		pointers[0]=pointers[1]=null;
		treeToDLL(pointers,root);
		Node curr = head;
		while(curr!=null){
			System.out.print(curr.data+ " ");
			curr = curr.right;
		}
		curr = head;
		while(curr!=pointers[1]){
			if(findTriplet(-1*(curr.data),curr.right,pointers[1])){
				System.out.println("found");
				break;
			}
			curr = curr.right;
		}
	}

	public static boolean findTriplet(int sum,Node head,Node tail){
		if (head == null || tail == null) {
			return false;
		}
		while(head!=tail){
			int s = head.data + tail.data;
			if (sum == s) {
				return true;
			}
			if (s > sum) {
				tail = tail.left;				
			}else{
				head = head.right;				
			}
		}
		return false;
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