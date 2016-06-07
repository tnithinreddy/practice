public class Main  {
	public static void main(String[] args) {
		BST tree = new BST();
		tree.insertUtil(9);
		tree.insertUtil(5);
		tree.insertUtil(10);
		tree.insertUtil(0);
		tree.insertUtil(6);
		tree.insertUtil(11);
		tree.insertUtil(-1);
		tree.insertUtil(1);
		tree.insertUtil(2);
		tree.print();
		tree.delete(10);
		tree.print();
	}
}