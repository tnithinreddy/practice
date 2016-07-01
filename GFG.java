// import java.util.*;
// import java.lang.*;
// import java.io.*;
// // http://www.practice.geeksforgeeks.org/problem-page.php?pid=453
// class GFG {
// 	public static void main (String[] args) throws IOException{
// 		//code
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		int t = Integer.parseInt(br.readLine());
// 		while(t > 0){
// 		    t--;
// 		    String s = br.readLine();
		    
// 		    int n = Integer.parseInt(s);
		    
// 		    s = br.readLine();
// 		    String []strs = s.trim().split("\\s+");
// 		    int a[]= new int[n];
// 		    for(int i = 0;i<n;i++){
// 		        a[i] = Integer.parseInt(strs[i]);
// 		    }		    
// 		}
// 	}
// }
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
		    
		    int n = Integer.parseInt(s);
		    
		    s = br.readLine();
		    String []strs = s.trim().split("\\s+");
		    int a[]= new int[n];
		    for(int i = 0;i<n;i++){
		        a[i] = Integer.parseInt(strs[i]);
		    }
		    s = br.readLine();
		    strs = s.trim().split("\\s+");
		    int b[]= new int[n];
		    for(int i = 0;i<n;i++){
		        b[i] = Integer.parseInt(strs[i]);
		    }
		    System.out.println( getMedian(a,b,0,n-1,0,n-1));
		}
	}
	public static int getMedian(int a[],int b[],int i,int m,int j,int n){
		// System.out.println("here" + " i = "+ i+" m = "+m+" j = "+j+" n = "+ n);
	    if(n-j == 1){
	        // System.out.println("here" + " i = "+ i+" m = "+m+" j = "+j+" n = "+ n);
	        // System.out.println("first = " + Math.max(a[i],b[j]) + " second = "+ Math.min(a[m],b[n]));
	    	// System.out.println("a = " + a[i] + " "+a[m] + " b = "+ b[j] + " "+b[n]);
	        return Math.min(a[m],b[n]) + Math.max(a[i],b[j]);
	    }
	    int m1 = median(a,i,m);
	    int m2 = median(b,j,n);
	    // System.out.println("m1 = " + m1 + " m2 = "+ m2);

	    
	    // if(m1 == m2){
	        
	    //     // return 2*m1+1;

	    // }
	    
	    if(m1>m2){
	    // System.out.println(i +" " +(m+i)/2+ " " +(n-j)/2+ " " +n);
	    	int p = (int)Math.floor(((double)(m+i))/2);
	    	int q = (int)Math.ceil(((double)(n+j))/2);
	        return getMedian(a,b,i,p,q,n);


	    }else{
	    // System.out.println((m-i)/2+ " " +m +" "+ j+ " " +(n-j)/2);
	    	int p = (int)Math.ceil(((double)(m+i))/2);
	    	int q = (int)Math.floor(((double)(n+j))/2);
	        return getMedian(a,b,p,m,j,q);



	    }
	    // return 5;
	    
	}
	public static int median(int a[], int i,int j){
	    int n = j-i+1;
	    if(n%2 == 1){
	        return  a[(i+j)/2];
	    }else{
	        int x = (i+j)/2;
	        return (a[x] + a[x+1])/2;
	    }
	}
}
