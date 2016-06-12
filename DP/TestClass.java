/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            System.out.println("hello world");
        }
        */
		// HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		
		String text,perm;
		char ch;
		while(t>0){
			t--;
			perm = sc.nextLine();
			text = sc.nextLine();
			if (perm.length()>text.length()) {
					System.out.println("NO");
					continue;
			}
			int textLength = text.length();
			int []textFreq = new int[26];
			for (int i = 0;i< textLength ;i++ ) {
				ch = text.charAt(i);
				textFreq[ch-97]++;
			
			}
			int perLength = perm.length();

			int []permFreq = new int[26];
			for (int i = 0;i< perLength ;i++ ) {
				ch = perm.charAt(i);
				permFreq[ch-97]++;
			}
			boolean found = true;
			for (int i = 0;i<26 ;i++ ) {
				// System.out.println(permFreq[i] + " " + textFreq[i]);
				if (permFreq[i]>textFreq[i]) {
					found = false;
					break;
				}
			}
			if (found) {
				System.out.println("YES");				
			}else{
				System.out.println("NO");			

			}

			
		}
    }
}
