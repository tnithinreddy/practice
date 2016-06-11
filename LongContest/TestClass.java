/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/

import java.util.*;
class TestClass {
	
	public static int gcd(int a,int b){
		if(a%b == 0){
			return b;
		}else{
			return gcd(b,a%b);
		}
	}
    public static void main(String args[] ) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int row,col;
		int cost[][];
		int a[][];
		int s,d;
		while(t>0){
			t--;
			row = sc.nextInt();
        	col = sc.nextInt();
        	a = new int[row][col];
        	cost = new int[row][col];
        	
        	for(int i=0;i<row;i++){
        		for(int j=0;j<col;j++){
        			cost[i][j] = -1;		
        		}
        	}
        	for(int i=0;i<row;i++){
        		for(int j=0;j<col;j++){
        			a[i][j] = sc.nextInt();		
        		}
        	}
        	cost[0][0] = a[0][0];
        	
        	for(int i=1;i<row;i++){
        		
        		if(cost[i-1][0]>a[i][0])
        			{ s = cost[i-1][0]; d = a[i][0];}
        		else{
        			d = cost[i-1][0]; s = a[i][0];
        		}
        		cost[i][0] = gcd(s,d);
        	}
        	for(int j=1;j<col;j++){
        		if(cost[0][j-1]>a[0][j])
        			{ s = cost[0][j-1]; d = a[0][j];}
        		else{
        			d = cost[0][j-1]; s = a[0][j];
        		}
        		cost[0][j] = gcd(s,d);
        	}
        	int max,g1,g2;
        
        	for(int i=1;i<row;i++){
        		for(int j=1;j<col;j++){
        			// i-1,j
        			if(cost[i-1][j] > a[i][j]){
        				s = cost[i-1][j]; d = a[i][j];
        			}else{
        				d = cost[i-1][j]; s = a[i][j];
        			}
        				
        			g1 = gcd(s,d); 
        			// i,j-1
        			if(cost[i][j-1] > a[i][j]){
        				s = cost[i][j-1]; d = a[i][j];
        			}else{
        				d = cost[i][j-1]; s = a[i][j];
        			}
        			g2 = gcd(s,d);
        			
 					if(g1>g2)
 						cost[i][j] = g1;
 					else
 						cost[i][j] = g2;
        		}
        	}
        	if(cost[row-1][col-1] == 1)
        		System.out.println("HOLD THE DOOR!");
        	else
        		System.out.println(cost[row-1][col-1]);
		}
        
    }
}
