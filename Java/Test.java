import java.util.Scanner;
  class Test{
  	// static int i;
  	static{
  		// i = 0;
  		int x = 5;
  		System.out.println("Executed before main " + ++x);
  		System.out.println("enter a number ==" );
  		Scanner sc = new Scanner(System.in);
  		System.out.println(sc.nextLine());
  	}
	// static int fun(){
	// 	return 1;
	// }
	public static void main(String[] args) {
		// System.out.println("Static function");
		// Node n = new Node();
		// n.print();
	}
}