public class Rotate2dMatrix{
	public static void main(String[] args) {
		int m = 5,n = 5;
		m = 4;n = 4;
		int a[][] = {
			{ 1,  2,  3,20},
            { 5,  6,  7,30},
            { 9, 10, 11,40},
            {13, 14, 15,50}
		};
		// 		int a[][] = {
		// 	{ 1,  2,  3},
  //           { 5,  6,  7},
  //           { 9, 10, 11},
  //           {13, 14, 15},
  //           {16, 17, 18}
		// };
		// int a[][] = {   
		// 				{ 1,  2,  3,  4,20},
  //                       { 5,  6,  7,  8,30},
  //                       { 9, 10, 	11, 12,40},
  //                       {13, 14, 15, 16,50},
  //                       {17, 18, 19, 20,60}
  //                   };

		int top = 0, left = 0, right = n-1,bottom = m-1;
		int i = top;
		int j = left;
		// for (int a = 0; a< m*n ; a++ ) {
			
		// }
		top = 0;
		left = 0;
		bottom = m-1;
		right = n-1;
		int prev,current;
		while(top<bottom && left < right){
			prev = a[top+1][left];
			for ( j = left; j<= right ; j++) {
				current = a[top][j];
				a[top][j] = prev;
				prev = current;
			}
			top++;
			for(i = top; i< bottom; i++){
				current = a[i][right];
				a[i][right] = prev;
				prev = current;
			}
			right--;
			if (top<=bottom) {
				for (j = right + 1; j>=left;j-- ) {
					current = a[bottom][j];
					a[bottom][j] = prev;
					prev = current;
				}
				bottom--;
			}
			if (left<=right) {
				for (i = bottom;i>=top ;i-- ) {
					current = a[i][left];
					a[i][left] = prev;
					prev = current;
				}
				left++;
			}
		}

		for (i = 0; i<m ; i++ ) {
			for (j =0 ;j<n ;j++ ) {
				// cout<<a[i][j]<<"  ";
				System.out.print(a[i][j] + "  ");
			}
			System.out.println();
		}
	}
}