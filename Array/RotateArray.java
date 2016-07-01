import java.util.*;
import java.lang.*;
import java.io.*;
// http://www.practice.geeksforgeeks.org/problem-page.php?pid=453
class GFG {
	public static void main (String[] args) throws IOException{
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t > 0){
		    t--;
		    String s = br.readLine();
		    String []strs = s.trim().split("\\s+");
		    int n = Integer.parseInt(strs[0]);
		    int k = Integer.parseInt(strs[1]);
		    s = br.readLine();
		    strs = s.trim().split("\\s+");
		    int a[]= new int[n];
		    for(int i = 0;i<n;i++){
		        a[i] = Integer.parseInt(strs[i]);
		    }
		  //  for(int i = 1;i<=k ;i++){
		  //      rotate(a);
		  //  }
		    reversalAlgorithm(a,k);
		    for(int i = 0;i<n ;i++){
		        System.out.print(a[i] + " ");
		    }
		    System.out.println();
		}
	}
	public static void reversalAlgorithm(int a[], int k){
		int l = k-1;
		int t,i=0;
		while(i<l){
			t = a[i];
			a[i] = a[l];
			a[l] = t;
			i++;
			l--;
		}
		i = k;
		l = a.length-1;
		while(i<l){
			t = a[i];
			a[i] = a[l];
			a[l] = t;
			i++;
			l--;
		}
		i = 0; l = a.length-1;
		while(i<l){
			t = a[i];
			a[i] = a[l];
			a[l] = t;
			i++;
			l--;
		}
	}
	public static void rotate(int a[]){
	    if(a.length == 1)
	        return;
	    int n = a.length -1;
	    int t = a[0];
	    
	    for(int i = 0;i<n;i++){
	        a[i] = a[i+1];
	    }
	    a[n] = t;
	}
}