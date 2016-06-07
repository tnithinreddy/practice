import java.lang.Math;
import java.util.*;
public class BST{
	public Node root;
	public BST(){
		root = null;
	}
	 
	public int height(Node root){
		if (root == null) {
			return 0;
		}
		return root.height;
	}
	public Node rotateRight(Node y){
		Node x = y.left;
		Node beta = x.right;

		x.right = y;
		y.left = beta;

		y.height = Math.max(height(y.left), height(y.right)) + 1;
		x.height = Math.max(height(x.left), height(x.right)) + 1;
		return x;
	}
	public Node rotateLeft(Node y){
		Node x = y.right;
		Node beta = x.left;

		x.left = y;
		y.right = beta;

		x.height = Math.max(height(x.left), height(x.right)) + 1;
		y.height = Math.max(height(y.left), height(y.right)) + 1;

		return x;
	}
	public int getDiff(Node left, Node right){
		if (left == null && right == null) {
			return 0;
		}
		if (left!=null && right!=null) {
			return (left.height-right.height);
		}
		if (left == null) {
			return -right.height;
		}
		return left.height;
	}
	public Node removeFromAvl(Node root, int key){
		if (root == null) {
			return null;
		}
		if (root.data == key) {
			if (root.left == null && root.right == null) {
				root = null;
				return root;
			}else{
				if(root.left!=null && root.right!=null){
					// get successor value, copy it and delete successor
					root.data = getSuccessor(root.right);
					root.right = removeFromAvl(root.right, root.data);
				}else{
					if (root.left == null) {
						root = root.right;
					}else{
						root = root.left;
					}
				}
			}

		}else{
			if (root.data > key) {
				root.left = removeFromAvl(root.left,key); 
			}else{
				root.right = removeFromAvl(root.right,key);
			}
		}
		root.height = Math.max(height(root.left),height(root.right)) + 1;
		int diff = getDiff(root.left, root.right);
		if (diff > 1) {
			int x = getDiff(root.left.left,root.left.right);
			if (x >=0 ) {
				
			}else{
				root.left = rotateLeft(root.left);
			}
			root = rotateRight(root);
		}else{
			if (diff < -1) {
				int x = getDiff(root.right.left,root.right.right);
				if (x >=0 ) {
					root.right = rotateRight(root.right);
				}else{
					
				}
				root = rotateLeft(root);
			}
		}

		root.height = Math.max(height(root.left),height(root.right)) + 1;
		return root;

	}
	public Node insert (Node root, int key){
		if (root == null) {
			return new Node(key);
		}
		if (key == root.data) {
			return root;			
		}
		if (key > root.data) {
			root.right = insert(root.right, key);
		}else{
			root.left = insert(root.left,key);
		}
		int diff = getDiff(root.left, root.right);
		
		if (diff > 1) { //inserted in left subtree
			if (root.left.data > key) {
				// left left
				
			}else{
				// left right
				// left rotate(y)
				root.left = rotateLeft(root.left);


			}
			// right rotate(z)
			root = rotateRight(root);
		}
		if (diff < -1) { //inserted in right subtree
			if (root.right.data > key) {
				// right left
				// right rotate (y)
				root.right = rotateRight(root.right);
			
			}else{
				// right right
				
			}
				//left rotate (z)
			root = rotateLeft(root);

		}
		root.height = Math.max(height(root.left), height(root.right)) + 1;
		return root;
	}
	public Node remove(Node root,int key){
		if (root ==null) {
			return null;
		}
		if (root.data > key) {
			root.left = remove(root.left,key);
			return root;
		}
		if (root.data < key) {
			root.right = remove(root.right,key);
			return root;
		}
		if (root.left == null && root.right == null) {
			return null;
		}
		if (root.left == null) {
			root = root.right;
			return root;
		}
		if (root.right == null) {
			root = root.left;
			return root;
		}
		// find  successor in right sub-tree
		int successor = getSuccessor(root.right);
		root.data = successor;
		root.right = remove(root.right, successor);
		return root;
		// 

	}
	public int getSuccessor(Node root){
		while(root.left!=null){
			root = root.left;
		}
		return root.data;
	}
	public void delete(int key){
		root = removeFromAvl(root,key);
	}
	public void insertUtil(int key){
		root = insert(root,key);
	}
	public void print(){
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
}