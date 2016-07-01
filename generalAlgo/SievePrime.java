import java.util.*;
public class SievePrime{
	public static void main(String[] args) {

		int n = 5000;
		long s = 5000*100000;
		// boolean primes[] = new boolean[n+1];
		// Arrays.fill(primes,true);
		// int i;
		// for( i = 2; i*i<=n;i++){
		// 	if (primes[i] == true) {
		// 		for (int j = 2*i; j <=n;j+=i) {
		// 			primes[j] = false;
		// 		}
		// 	}
		// }	
			// Java program to find prime number greater than a
			// given number using built in method
			// import java.util.*;
			// import java.math.*;
			 
			// class NextPrimeTest
			// {
			//     // Function to get nextPrimeNumber
			//     static long nextPrime(long n)
			//     {
			//         BigInteger b = new BigInteger(String.valueOf(n));
			//         return Long.parseLong(b.nextProbablePrime().toString());
			//     }
			 
			//     // Driver method
			//     public static void main (String[] args)
			//                     throws java.lang.Exception
			//     {
			//         long n = 14;
			//         System.out.println(nextPrime(n));
			//     }
			// }

		int N = 5000;
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
		int count = 0;
		for (int  i = 2; i<=n ;i++ ) {
			if (primes[i] == false) {
				continue;
			}
			count++;
			// System.out.print(i + " ");
		}
			System.out.println(count);
		
	}
}