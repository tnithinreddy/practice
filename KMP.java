import java.util.*;

public class KMP{
	public static void main(String[] args) {
		// String text = "ABABDABACDABABCABAB";
		// String pattern = "ABABCABAB";1
		char text[] = "ABABDABACDABABCABAB".toCharArray();
		char pattern[] = "ABABCABAB".toCharArray();
		int lps[] = new int[pattern.length];
		fillLps(pattern,lps);
		searchPattern(text,pattern,lps);
		for (int i : lps ) {
			System.out.print(i + " ");
		}
			System.out.println();

	}
	public static void searchPattern(char text[], char pattern[], int lps[]){
		int j = 0;
		int N = text.length;
		int i = 0;
		int M = pattern.length;
		while( i < N){
			if (text[i] == pattern[j]) {
				i++;
				j++;
			}else{
				System.out.println("j = " + j + " M = " + M);
				if (j == M) {
					System.out.println("found at  = " + (i-j));
					j = lps[j-1];
				}else{
					if(j>0)
						j = lps[j-1];
					else{
						i = i + 1;
					}
				}
			}
			
		}
		if (j == M) {
					System.out.println("found at  = " + (i-j));
					// j = lps[j-1];
		}
	}
	public static void fillLps(char pattern[], int lps[]){
		lps[0] = 0;
		int j = 0;
		int i = 1;
		int M = pattern.length;
		while(i<M){
			if (pattern[i] == pattern[j]) {
				j++;
				lps[i] = j;
				i++;
			}else{
				if (j!=0) {
					j = lps[j-1];
				}else{
					lps[i] = 0;
					i++;
				}
			}
		}
	}
}