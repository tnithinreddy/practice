import java.util.*;
public class PermutationsOfString{
	public static void main(String[] args) {
		char a[] = {'a','b','c','a'};
		// printPermutations(a,0,a.length-1);
		// Random r = new Random();
		// System.out.println(r.nextInt());
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = "hello";
		StringBuilder builder = new StringBuilder(s);
		System.out.println(builder.reverse());

		// while(n!=0){
		// 	s = s + 
		// }

	}
	public static void printPermutations(char a[], int start, int end){
		if (start == end) {
			// print the array
			System.out.println("printing... = " + a.length);
			print(a);
		}
		int i = start;
		for (i = start;i<=end; i++) {
			if (a[start] == a[i] && i!=start) {
				continue;
			}
			swap(a,start,i);
			printPermutations(a,start+1,end);
			swap(a,start,i);
		}

	}
	public static void swap(char c[], int i, int j){
		char t = c[i];
		c[i] = c[j];
		c[j] = t;
	}

	public static void print(char c[]){
		for (int i = 0; i<c.length;i++ ) {
			System.out.print(c[i]);
		}
		System.out.println();
	}
}