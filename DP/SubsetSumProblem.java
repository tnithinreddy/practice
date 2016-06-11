import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SubsetSumProblem{
	public static void main(String[] args) throws IOException {
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		String s = b.readLine();
		int t = Integer.parseInt(s);
		int []a;
		String[] strings;
		int i,n;
		while(t>0){
			t--;
			s = b.readLine();
			n = Integer.parseInt(s);
			a = new int[n+1];
			s = b.readLine();
			strings = s.trim().split("\\s");
			for (i=1; i <= n ;i++ ) {
				a[i] = Integer.parseInt(strings[i-1]);
			}
			subset(a,n,9);
		}
	}
	public static boolean subset(int a[],int n, int sum){
		boolean sumArray[][] = new boolean[sum+1][n+1];
		int i,j;
		for (i=0;i<=n ;i++ ) {
			sumArray[0][i] = true;
			sumArray[i][0] = false;
		}
		sumArray[0][0] = true;
		for (i = 1;i<=sum ;i++ ) {
			for ( j = 1;j<=n ;j++ ) {
				if (i == a[j]) {
					sumArray[i][j] = true;
				}else{
					sumArray[i][j] = sumArray[i][j-1];
					if (i-a[j]>=0) {
						sumArray[i][j] = sumArray[i][j] || sumArray[i-a[j]][j-1];						
					}
				}
			}
		}
		System.out.println(sumArray[sum][n]);
		return sumArray[sum][n];
	}	
}