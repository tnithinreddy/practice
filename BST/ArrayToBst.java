import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class ArrayToBst{

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
	public static void main(String[] args) throws IOException	{
		// BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		// String str = b.readLine();
		// System.out.println(str);
		// String[] strings = str.trim().split("\\s+");
		// for (String s :strings) {
		// 	System.out.println(s);
		// }

		int a[] = {1, 2, 3, 4, 5, 6};
		int n = a.length;
		int beg = 0;
		Node root = new Node(a[n/2]);
		root.left = arraytoTree(a,beg,n/2 - 1);
		root.right = arraytoTree(a,n/2 + 1,n-1);
		print(root);
		System.out.println("inorder = ");
		inorder(root);
		System.out.println("");

	}
	public static Node arraytoTree(int[] a,int beg,int end){
		if (beg < 0 || end >= a.length) {
			return null;
		}
		if (beg>end) {
			System.out.println("beg greater than end");
			return null;
		}
		int mid = beg + end;
		mid = mid/2;
		Node n = new Node(a[mid]);
		if(beg == end){
			return n;
		}
		n.left = arraytoTree(a,beg,mid-1);
		n.right = arraytoTree(a,mid+1,end);
		return n;
	}
}