public class RotateMatrix{
	public static void main(String[] args) {
		int m =4;int n = 4;
		int a[][] = {
			{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}
		};
		int rows = 5;int col = 4;
		int rect[][] = {
			{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20}
		};
		int i = 0;
		int j = 1;
		int t;
		for(i = 0;i < m;i++){
			for(j = 0; j < n; j++){
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		///
		int top = 0,left = 0, right = n-1, bottom = m-1;
		for(int k = 0;k < m/2; k++){
			
			for(j = left; j < right; j++){
				t = a[top+j][left];
				a[top+j][left] = a[top][right-j];
				a[top][right-j] = a[bottom-j][right];
				a[bottom-j][right] = a[bottom][left+j];
				a[bottom][left+j] = t;
			}
			top ++; right--;left++;bottom--;
		}
			System.out.println();
		
		for(i = 0;i < m;i++){
			for(j = 0; j < n; j++){
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		///
		// for(i = 0;i < m;i++)
		// 	for(j = i+1; j < n; j++){
		// 		t = a[i][j];
		// 		a[i][j] = a[j][i];
		// 		a[j][i] = t;
		// 	}
		
		// System.out.println("rotating matrix ...");
		// for (i = 0; i < m ; i++) {
		// 	for (j = 0; j<n/2 ;j++ ) {
		// 		t = a[i][j];
		// 		a[i][j] = a[i][n-1-j];
		// 		a[i][n-1-j] = t;
		// 	}
		// }
		// for(i = 0;i < m;i++){
		// 	for(j = 0; j < n; j++){
		// 		System.out.print(a[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }
		// int [][]res = new int[col][rows];
		// for (i = 0;i< rows ;i++ ) {
		// 	for (j = 0; j < col;j++) {
		// 		res[j][i] = rect[i][j];
		// 	}
		// }
		// for(i = 0;i < col;i++){
		// 	for(j = 0; j < rows; j++){
		// 		System.out.print(res[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }
	}
}