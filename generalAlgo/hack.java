/* IMPORTANT: Multiple classes and nested static classes are supported */


import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
         line = br.readLine();
        String strs[] = line.trim().split("\\s");
         
         boolean primes[] = new boolean[N+1];
         Arrays.fill(primes,true);
         primes[0] = false;
         primes[1] = false;
         for(int  i = 2; i*i<=N;i++){
         	if(primes[i] == true){
         		for(int j = 2*i; j<=N;j=j+i){
         			primes[j] = false;
         		}
         	}
         }
         int a[] = new int[N+1];
         long sumArray[] = new long[N+1];
         sumArray[0] = 0;
        for (int i = 0; i < N; i++) {
            a[i+1] = Integer.parseInt(strs[i]);
            sumArray[i+1] = sumArray[i] + a[i+1];
        }
        long s;
        long maxSum = 0;
        for(int i=1;i<=N;i++){
        	
        	for(int j = i+1;j<=N;j++ ){
        		if(primes[j-i+1]){
        			s = (sumArray[j]-sumArray[i])+a[i];
        			if(s > maxSum)
        				maxSum = s;
        		}
        		
        	}
        }
        
        System.out.println(maxSum);
    }
}
