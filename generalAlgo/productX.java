import java.util.*;
abstract class ProductX{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = sc.nextInt();
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		int i=0;
		int other;
		Integer s;
		int res1 = -1,res2 = -1;
		while(i<n){
		 	other = sc.nextInt();
		 	System.out.println(other);
			s =  map.get(x/other);
			if (s  == 1) {
				res1 = s;
				res2 = other;
				System.out.println("found = "+ s + " " + res2 );
				break;
			}
			map.put(other,1);
			i++;
		}
	}
}