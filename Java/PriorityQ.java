import java.util.PriorityQueue;
import java.util.Comparator;
public class PriorityQ{
	private static class MyComparator implements Comparator<Integer>{
		public 	int compare(Integer x, Integer y){
			return y-x;
		}
	}
	public static void main(String[] args) {
		int k = 3;
		// heap.add();
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

		int a[] = {1,2,3,4,5,6,7,8,9};
		for (int i = 0 ;i< k; i++ ) {
			heap.add(a[i]);
		}
		for (int i = k;i<a.length ; i++ ) {
			Integer in = heap.peek();
			if (in.intValue() < a[i]) {
				heap.poll();
				heap.add(a[i]);
			}
		}
		Object maxElements[] = heap.toArray();
		for (Object l : maxElements ) {
			System.out.print(l + " ");
		}
		System.out.println();
		// PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, new MyComparator()); // can pass inital size of queue
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k,new MyComparator());
		for (int i = 0;i< k ;i++ ) {
			maxHeap.add(a[i]);
		}
		for (int i = k; i<a.length;i++ ) {
			Integer inm = maxHeap.peek();
			if (inm.intValue() > a[i]  ) {
				maxHeap.poll();
				maxHeap.add(a[i]);
			}
		}
		Object[] minElements = maxHeap.toArray();
		int intValue;
		for (Object i : minElements ) {
			intValue = ((Integer)i).intValue();
			System.out.print(intValue + " ");
		}
		System.out.println();
	}
}