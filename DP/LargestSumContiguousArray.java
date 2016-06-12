public class LargestSumContiguousArray{
	public static void main(String[] args) {
		int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		int a[][] = new int[arr.length][arr.length];
		int i = 0,j;
		int n = arr.length;
		for (i=0;i<arr.length ;i++ ) {
			a[i][i] = arr[i];
		}
		int max = Integer.MIN_VALUE;
		for ( i =0; i < n; i++ ) {
			for (j = i+1; j < n;j++ ) {
				a[i][j] = a[i][j-1] + arr[j];
				if (max < a[i][j]) {
					max = a[i][j];
				}
			}
		}
		// for ( i =0; i < n; i++ ) {
		// 	for (j = 0; j < n;j++ ) {
		// 		System.out.print(a[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }
		System.out.println(max);
	}
}