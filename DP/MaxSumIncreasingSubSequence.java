abstract class Test{
	public static void main(String[] args) {
		// int a[] = {1, 101, 2, 3, 100, 4, 5};
		int a[]= {10, 5, 4, 3};
		int [] sum = new int[a.length];
		int i=0;
		sum[0] = a[0];
		int n = a.length;
		for (i = 1; i < n; i++) {
			sum[i] = a[i];
			for (int j = i-1;j>=0 ; j--) {
				if (a[i]>=a[j] && sum[j]+a[i]>=sum[i]) {
					sum[i] = a[i] + sum[j];
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int k = 0;k<n ;k++ ) {
			if (max < sum[k]) {
				max = sum[k];
			}
		}
		System.out.println(max);
	}
}