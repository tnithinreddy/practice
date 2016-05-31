import java.util.*;
public class Matrix_spiral{
  public static void main(String[] args){
    int m = 4, n=4;
    int matrix[][] = new int[m][n];
    Scanner sc = new Scanner(System.in);
    int i,j;
    for (i = 0; i < m; i++ ) {
      for (j = 0; j < n; j++ ) {
        matrix[i][j] = sc.nextInt();
      }
    }
    // for (i = 0; i < m; i++ ) {
    //   for (j = 0; j < n; j++ ) {
    //     System.out.println(matrix[i][j]);
    //   }
    // }
    int k = 0, l = 0;
    // k is starting row
    // l is starting column
    // m ending row
    // n ending column
    i = 0; // current row
    while(k < m && l < n){
      // print first row in the remaining rows
      // print last coloumn  in the remaining coloumns
      // print last row in remaining rows
      // print last coloumn from the remaining coloumns
      for (i = l; i < n; i++ ) {
        System.out.print(matrix[k][i] + " ");
      }
      k++;
      for ( i = k; i < m ; i++ ) {
            System.out.print(matrix[i][n-1] + " ");
      }
      n--;
      if (k < m) {
        for (i = n-1; i >= l; i-- ) {
          System.out.print(matrix[m-1][i] + " ");
        }
        m--;
      }
      if (l < n) {
        for (i = m-1 ;i >= k;i--) {
          System.out.print(matrix[i][l] + " ");
        }
        l++;
      }
    }

  }
}
