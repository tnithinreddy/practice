// http://www.practice.geeksforgeeks.org/problem-page.php?pid=384
import java.util.*;
import java.io.*;
abstract class GFG{
	public static void main(String[] args) throws IOException{	
		int n = 218765;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t>0){t--;
			n = Integer.parseInt(br.readLine());
			String s = Integer.toString(n);
			int []digits = new int[s.length()];
			int i,pos,temp,pos2;
			for (i = digits.length-1; i >=0; i-- ) {
				digits[i] = s.charAt(i) - '0';
			}
			if(isSorted(digits,digits.length)){
				System.out.println("not possible");
			}else{
				i = digits.length-1;
				pos = i;
				for (i=0;i<digits.length-1 ;i++ ) {
					if (digits[i] < digits[i+1]) {
						pos = i;
					}
				}
				pos2 = pos + 1;

				for (i = digits.length-1; i >= pos+1;i-- ) {
					if (digits[i] > digits[pos]) {
						pos2 = i;
						break;
					}
				}
				temp = digits[pos];
				digits[pos] = digits[pos2];
				digits[pos2] = temp;
				// sort from pos+1 to end
				quickSort(digits,pos+1,digits.length-1);
				for (int j : digits) {
				System.out.print(j);
				}
				System.out.println();
			}
		}

	}


	public static boolean isSorted(int a[], int length){
	
		boolean res = true;
		for (int  i = 1;i<length ;i++ ) {
			if (a[i] > a[i-1]) {
				res = false;
				break;
			}
		}
		return res;
	}
		public static int partition(int a[], int beg, int end){
		int pivot = a[end];
		int i = beg-1,t;
		for (int j = beg; j < end ; j++) {
			if (a[j] <= pivot) {
				i++;
				t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}
		t = a[i+1];
		a[i+1] = a[end];
		a[end] = t;
		return i+1;
	}

	public static void quickSort(int a[],int beg,int end){
		if (beg < 0 || beg >= end) {
			return;
		}
		int p = partition(a,beg,end);
		quickSort(a,beg,p-1);
		quickSort(a,p+1,end);

	}
}