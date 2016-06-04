import java.util.Queue;
import java.util.LinkedList	;
import java.util.*;

abstract class Petrol{

	public static void main(String[] args) {
		Queue<Node> q = new LinkedList<Node>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i =0;
		Node node;
		System.out.println("petrol =     distance =");
		while(i<n){
			int p = sc.nextInt();
			int d = sc.nextInt();
			node = new Node(d,p);;
			q.add(node);
			i++;
		}
		while(!q.isEmpty()){
			
		}

	}
}