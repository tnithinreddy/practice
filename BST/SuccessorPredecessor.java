public class SuccessorPredecessor{
	static Node pre,suc;
	public static void main(String[] args) {
		BST tree = new BST();
		tree.insertUtil(50);
		tree.insertUtil(30);
		tree.insertUtil(20);
		tree.insertUtil(40);
		tree.insertUtil(70);
		tree.insertUtil(60);
		tree.insertUtil(80);
		tree.print();
		System.out.println("root = " + tree.root.data);
		findsucpre(tree.root,70);
		System.out.println(suc.data + " " + pre.data);
	}
	public static void findsucpre(Node root, int value){
		if (root == null) {
			return;
		}
			Node curr = root;

		if (root.data == value) {
			if (root.right !=null) {
				curr = root.right;
				while(curr.left!=null){
					curr = curr.left;
					
				}
				suc = curr;
			}
			if (root.left!=null) {
				curr = root.left;
				while(curr.right!=null){
					curr = curr.right;
				}
					pre = curr;

			}
			return;
		}
		if (root.data > value) {
			suc = root;
			findsucpre(root.left,value);
		}else{
			pre = root;
			findsucpre(root.right, value);
		}
	}
}