import java.util.*;
import java.lang.*;
import java.io.*;

abstract class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

    // System.out.println("t = " + t);
		int n;
		int a[];
		int x = 0;
		int zeroes=0,ones=0,twos=0;
		while(t>0){
		    zeroes=0;ones=0;twos=0;

		    n = sc.nextInt();

        // System.out.println("n = " + n);
		    a = new int[n];


		    for(int i = 0; i < n; i++){
		        x = sc.nextInt();
            // System.out.println("x = " + x);
		        if(x == 0){
		            zeroes++;
		        }
		        if(x == 1){
		            ones++;
		        }
		        if(x == 2){
		            twos++;
		        }
		    }

    		int k = 0;
    		while(zeroes > 0){
    		    a[k++] = 0;
    		    zeroes --;
    		}
    		while(ones > 0){
    		    a[k++] = 1;
    		    ones --;
    		}
    		while(twos > 0){
    		    a[k++] = 2;
    		    twos --;
    		}
    		for(int j = 0; j<a.length;j++)
    		  System.out.print(a[j] + " ");
		    t--;
        System.out.println();
		}


	}
}
