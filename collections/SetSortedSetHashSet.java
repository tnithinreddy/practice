import java.util.*;
public class SetSortedSetHashSet{
	public static class Node{
		int data;
		int index;
		Node(int d, int i){
			this.data = d;
			this.index = i;
		}
	}
	public static class MyComparator implements Comparator<Node>{
		public int compare(Node a, Node b){
			return a.data - b.data;
		}
	}
	public static void main(String[] args) {
		Set<Node> treeSet = new TreeSet<Node>(new MyComparator());
		treeSet.add(new Node(15,0));
		treeSet.add(new Node(5,1));
		treeSet.add(new Node(1,2));
		treeSet.add(new Node(27,3));
		treeSet.add(new Node(2,4));
		Iterator it = treeSet.iterator();
		// while(it.hasNext()){
		// 	Node n = (Node)it.next();
		// 	System.out.print(" data = " + n.data + " index = "+ n.index);
		// }
		System.out.println(treeSet);

		TreeMap<Integer,Integer> treeMap = new TreeMap<Integer,Integer>();
		treeMap.put(1,5323);
		treeMap.put(5,511);
		treeMap.put(2,52);
		treeMap.put(222,25);
		treeMap.put(78,5);
		treeMap.put(-1,3);
		Set<Integer> set = treeMap.keySet();
		for(Integer key : set){
			System.out.println((key));
		}

		for (Map.Entry entry :treeMap.entrySet() ) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}
}

// how to sort array of structure/object based on some other criteria