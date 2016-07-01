import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
abstract class GFG{
	public static void main(String[] args) throws IOException{
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		
		int i = 0,max,min;
		int a[] ;
		int n ;
		int t = Integer.parseInt(b.readLine());
		while(t > 0){
		    t--;
			n = Integer.parseInt(b.readLine());
			a = new int[n];
			String str = b.readLine();
			String[] arr = str.trim().split("\\s");
			for (i = 0; i < n ; i++) {
				a[i] = Integer.parseInt(arr[i]);
			}
			int s = 0,e = n-1;
			for (i = 0; i < n-1; i++) {
				if (a[i] > a[i+1]) {
					s = i;
					break;
				}
			}
			if (i == n-1) {
				System.out.println("0 0");
				continue;
			}
			for (i = n-1; i>0 ;i-- ) {
				if (a[i] < a[i-1]) {
					e = i;
					break;
				}
			}
			
			// 0 to s and e to n-1 are sorted
			min = a[s];
			max = min;
			for (i = s+1;i<=e ;i++ ) {
				if (a[i]>max) {
					max = a[i];
				}
				if (a[i] < min) {
					min = a[i];
				}
			}
			for (i = 0; i < s ; i++ ) {
				if (a[i] > min) {
					s = i;
				}
			}
			for ( i = e+1;i<n ;i++ ) {
				if (a[i]<max) {
					e = i;
				}
			}
			System.out.println(s + " "+ e);
		}

	}
}