public class LongestPalindrome{
	public static void main(String[] args) {
		// int length = 2;
		int n = 5;
		int i,j,k;
		char a[] = "GEEKS FOR GEEKS".toCharArray();
		n = a.length;
		int [][]length = new int[n+1][n+1];
		for (int x = 0;x<n+1 ;x++ ) {
			length[x][x] = 1;
			length[0][x] = length[x][0] = 0;
		}
		for (int L = 2; L <= n; L++ ) {
			for (i = 0; L+i-1<n;i++ ) {
				j = L+i-1;
				System.out.print("("+i + ","+ j + ")");
				int len = 0;
				// if (i<j) {
				// 	continue;
				// }
				if (i+1 == j && a[i] == a[j]) {
					length[i+1][j+1] = 2;
					System.out.println("for length "+ (i+1) + "," + (j+1) +" = " +length[i+1][j+1]);					
					continue;
				}
				if (a[i] == a[j]) {
					length[i+1][j+1] = 2 + length[i+2][j];
				}else{
					if (length[i+1][j] > length[i+2][j+1]) {
						length[i+1][j+1] = length[i+1][j];
					}else{
						length[i+1][j+1] = length[i+2][j+1];
					}
					// length[i+1][j+1] = (length[i+1][j] > length[i][j-1]) ? length[i+1][j]:length[i][j-1];
				}
				System.out.println("for length "+ (i+1) + "," + (j+1) +" = " +length[i+1][j+1]);					

			}
				System.out.println();
		}
		System.out.println(length[1][n]);
	}
}