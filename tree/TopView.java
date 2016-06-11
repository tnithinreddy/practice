import java.util.*;
public class TopView{
	private static class ExtraNode{
		public Node n;
		public int hd;
		public ExtraNode(Node x,int u){
			n = x;
			hd = u;
		}
	}
	public static void main(String[] args) {
		Node root = new Node(1);
	    root.left = new Node(2);
	    root.right = new Node(3);
	    root.left.left = new Node(4);
	    root.left.left.right = new Node(10);
	    root.left.left.right.right = new Node(15);
	    root.left.right = new Node(5);
	    root.right.left = new Node(6);
	    root.right.right = new Node(7);
	    root.left.left.left = new Node(8);
	    topView(root,0);
	    bottomView(root,0);
	}
	public static void topView(Node root, int hd){
		if (root == null) {
			System.out.println("empty tree");
			return;
		}
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		Queue<ExtraNode> q = new LinkedList<ExtraNode>();
		ExtraNode e = new ExtraNode(root,0);
		q.add(e);
		while(!q.isEmpty()){

			e = q.remove();
			
			Integer in = map.get(e.hd);
			if (in == null) {
				map.put(e.hd,e.n.data);
			}
			// Node c = e.n;
			if (e.n.left!=null) {
			ExtraNode	c = new ExtraNode(e.n.left,e.hd-1);
				q.add(c);
			}
			if (e.n.right!=null) {
				e = new ExtraNode(e.n.right,e.hd+1);
				q.add(e);
			}
		}

		System.out.println(map);

	}
	public static void bottomView(Node root, int hd){
		if (root == null) {
			System.out.println("empty tree");
			return;
		}
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		Queue<ExtraNode> q = new LinkedList<ExtraNode>();
		ExtraNode e = new ExtraNode(root,0);
		q.add(e);
		while(!q.isEmpty()){

			e = q.remove();
			
			map.put(e.hd,e.n.data);

			// Node c = e.n;
			if (e.n.left!=null) {
			ExtraNode	c = new ExtraNode(e.n.left,e.hd-1);
				q.add(c);
			}
			if (e.n.right!=null) {
				e = new ExtraNode(e.n.right,e.hd+1);
				q.add(e);
			}
		}

		System.out.println(map);

	}
}