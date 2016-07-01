import java.util.*;
public class Dijkstra{
	public static Node{
		int v;
		int w;
		public Node(int a, int b){
			this.v = x;
			this.w = b;
		}
	}
	static int n;
	static int e;
	static BufferedReader reader;
	static ArrayList<Integer> adj[];
	public static PriorityQueue<Integer> heap;
	public static void main(String[] args) {
		int t = Integer.parseInt(reader.readLine());
		while(t > 0){
			t--;
			heap = new PriorityQueue<Integer>();
			String firstLine[] = reader.readLine().trim().split(" ");
			n = Integer.parseInt(firstLine[0]);
			int e = Integer.parseInt(firstLine[1]);
			int i = 0;
			adj = (ArrayList<Integer>[])new ArrayList[n];
			for ( i = 0;i<n;i++ ) {
				adj[i] = new ArrayList<Integer>();
			}
			buildGraph(adj,e);
			
			while(treeSet.size() < n){

			}
		}

	}
	public static void buildGraph(ArrayList<Integer>[] adjacencyList, int e) throws IOException{
		for (int i = 0;i<e ; i++) {
			String words[] = reader.readLine().trim().split(" ");
			int a = Integer.parseInt(words[0]);
			int b = Integer.parseInt(words[1]);
			int w = Integer.parseInt(words[2]);
			// a--;b--;
			adjacencyList[a].add(new Node(b,w));

		}
	}
}