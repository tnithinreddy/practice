import java.util.*;
import java.lang.*;
import java.io.*;
// http://www.practice.geeksforgeeks.org/problem-page.php?pid=453
class NextPalin {
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
		    if(checkIf99(a)){
		    	String ing = "";
		    	for(int i = 1; i<n;i++)
		    		ing = ing + "0";
		    	ing = "1" + ing +"1";
		        System.out.println(ing);
		    }else{
		        if(checkIfPalindrome(a)){
		            if (n%2 == 0) {
		            	a[n/2]++;
		            	a[n/2 - 1]++;
		            }else{
		            	a[n/2]++;
		            }
		        }else{
		            int status = 0;
		            int i = 0; int j = a.length-1;
		            while(i < j){
		            	if (i+1 == j) {
		            		if (status == -1) {
		            			if (a[i] == a[j]) {
		            				a[i]++;a[j]++;
		            			}else{
		            				if (a[i]>a[j]) {
		            					a[j] = a[i];
		            				}else{
		            					a[i] = a[j];
		            				}
		            			}
		            		}else{
		            			if (status == 1) {
		            				if (a[i] > a[j]) {
		            					a[j] = a[i];
		            				}else{
		            					a[i] = a[j];
		            				}
		            			}
		            		}
		            		i++;j--;
		            	}else{
		            		if (i == j) {
		            			if (status == -1) {
		            				a[i]++;
		            			}
		            		}else{
		            			if (a[i] == a[j]) {
				            		i++; j--; continue;
				            	}
				            	if (a[j] > a[i]) {
				            		a[j] = a[i];
				            		status = -1;
				            	}else{
				            		a[j] = a[i];
				            		status = 1;
				            	}
				            	i++;
				            	j--;
		            		}
		            	}

		            }
		        }
		        for (int e : a) {
		        	System.out.print(e);
		        }
		        System.out.println();
		    }
		}
	}

	public static boolean checkIf99(int a[]){
		for ( int i : a ) {
			if (i != 9) {
				return false;
			}
		}
		return true;
	}

	public static boolean checkIfPalindrome(int a[]){
		int i =0; int j = a.length -1;
		while(i<j){
			if (a[i] != a[j]) {
				return false;
			}
			i++; j--;
		}
		return true;
	}
}