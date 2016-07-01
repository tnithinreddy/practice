import java.util.*;
public class Sausage{
	public static class Pair implements Comparator<Pair>{
		int v;
		int w;
		public int compare(Pair x, Pair y){
			return y.w - x.w;
		}
		public Pair(int a, int b){
			v = a;
			w = b;
		}
	}
	public static class MyComparator implements Comparator<Pair> {
		public int compare(Pair x, Pair y){
			return y.w - x.w;
		}
	}
	public static void main(String[] args) {
		int a[] = {};

		LinkedList<Pair> list = new LinkedList<Pair>();
		list.add(new Pair(3,1));
		list.add(new Pair(5,7));
		list.add(new Pair(6,2));
		list.add(new Pair(9,10));
		// Collections.sort(list, new Comparator<Pair>(){
		// 	public int compare(Pair x, Pair y){
		// 		return y.w - x.w;
		// 	}
		// });
		Collections.sort(list, new MyComparator());
		for (Pair item : list) {
		System.out.println("veretex = " + item.v + " weigth = " + item.w);			
		}

	}
}