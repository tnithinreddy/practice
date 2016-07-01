import java.util.*;

public class PrimeFactors{
	public static void print(int n){
		System.out.print(n + " ");
	}
	public static void main(String[] args) {
		int n = 1000000001;
		int count = 0;
		while(n%2==0){
			n = n/2;
			print(2);
			count++;
		}
		for (int i =3;i*i <= n ;i+=2 ) {
			while(n%i==0){
				print(i);
				n/=i;
				count++;
			}
				count++;
			
		}
		if (n > 2) {
			print(n);
		}
		System.out.println();

		System.out.println("count = " + count);
	}
	
}