import java.util.*;
abstract class FirstRepeatedNumber{
	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<Integer>();
		int a[] = {6, 10, 5, 4, 9, 120, 4, 6, 10};
		int min = -1;
		// set.add(6); // add, contains, remove, size, isEmpty
		for (int i = a.length-1;i >= 0;i-- ) {
			if (set.contains(a[i])) {
				min = i;			
				// break;
			}else{
				set.add(a[i]);
			}
		}
		System.out.println(a[min]);

	}
}