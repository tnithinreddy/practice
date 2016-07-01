import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

abstract class PathBackTracking{
	public static class Pair{
		int v;
		int w;
		public Pair(int ver, int wt){
			this.v = ver;
			this.w = wt;
		}
	}
	static ArrayList<Pair> adj[];
	static int n;
	static int k,e,src;
	static LinkedList<Integer> path;
	static boolean visited[];
	static BufferedReader reader;
	public static void main(String[] args) throws IOException{
		// reader = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		while(t>0){
			t--;

			n = 9; src = 0; k = 60;
			adj = (ArrayList<Pair>[]) new ArrayList[n];
			int  i = 0;
			for (;i<n ;i++ ) {
				adj[i] = new ArrayList<Pair>();
			}
			visited = new boolean[n];
		     addEdge(0, 1, 4);
		     addEdge(0, 7, 8);
		     addEdge(1, 2, 8);
		     addEdge(1, 7, 11);
		     addEdge(2, 3, 7);
		     addEdge(2, 8, 2);
		     addEdge(2, 5, 4);
		     addEdge(3, 4, 9);
		     addEdge(3, 5, 14);
		     addEdge(4, 5, 10);
		     addEdge(5, 6, 2);
		     addEdge(6, 7, 1);
		     addEdge(6, 8, 6);
		     addEdge(7, 8, 7);
			Arrays.fill(visited,false);
			visited[src] = true;
			path = new LinkedList<Integer>();
			path.addLast(src);
			if (findPath(src,0)) {
				System.out.println(path);
			}else{
				System.out.println("not found");
			}

		}

	}

	public static boolean findPath(int root, int sum){
		System.out.println("root = " + root);
		for (Pair p : adj[root] ) {
			if (visited[p.v]) {
				continue;
			}
			visited[p.v] = true;
			path.addLast(p.v);	
			System.out.println("sum = " + (sum + p.w))		;
			if (sum + p.w >= k) {
				return true;
			}
			if(findPath(p.v,sum+p.w)){
				return true;
			}
		}
		path.removeLast();
		visited[root] = false;
		return false;
	}

	public static void addEdge(int a,int b, int w){
	     adj[a].add(new Pair(b,w));
		 adj[b].add(new Pair(a,w));
	}
}