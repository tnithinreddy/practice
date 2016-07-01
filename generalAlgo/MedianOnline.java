import java.util.*;
public class MedianOnline{
	public static class MyComparator implements Comparator<Integer>{
		public int compare(Integer x, Integer y){
			return y-x;
		}
	}
	public static void main(String[] args) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11,new MyComparator());
		int a[] = {1,2,3,4,5,6,7,8,9};
		int diff,e,m=0;
		for (int i = 0;i<a.length ;i++ ) {
			e = a[i];
			diff = maxHeap.size()-minHeap.size();
			switch(diff){
				case 0:
					if (e > m) {
						
					}else{

					}
					System.out.println("hello");
					break;
				
				case 1:
					System.out.println("hello");
					break;
				
				case -1:
					System.out.println("hello");
					break;
				default:
					break;
				
			}
		}
	}
}