import java.util.*;
import java.io.*;
public class SortByFrequencies{
	public class myComparator implements Comparator{
		public int compare(){

		}
	}
	public class Element{
		public int data,index,count;
	}
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
		}
	}
}

