import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Bfs {

	static final int INF = 1000000000;   // not taking Integer.MAX to avoid overflow errors
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter writer = new PrintWriter(System.out,false);
	static ArrayList<Integer>[] adjacencyList;
	static boolean[] visited;
	static int[] distance;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int n,m;
		String[] firstLine = reader.readLine().split(" ");
		n = Integer.parseInt(firstLine[0]);
		m = Integer.parseInt(firstLine[1]);
		
        // initialization part started
		adjacencyList = (ArrayList<Integer>[])new ArrayList[n]; 
		for(int i=0;i<n;i++)
			adjacencyList[i] = new ArrayList<Integer>();
		visited = new boolean[n];
		Arrays.fill(visited, false);
		distance = new int[n];
		Arrays.fill(distance,INF);	
		// initialization part over
		
		buildGraph(m);
		bfs(0);
		writer.flush();
		writer.close();
		reader.close();

	}
	
	public static void buildGraph(int m) throws IOException
	{
		for(int i=0;i<m;i++)
		{
			int a,b;
			String[] firstLine = reader.readLine().split(" ");
			a = Integer.parseInt(firstLine[0]);
			b = Integer.parseInt(firstLine[1]);
			a--;b--;
			adjacencyList[a].add(b);
			adjacencyList[b].add(a);
		}
	}
	
	/*
	 * will calculate single source shortest distance on unweighted graphs
	 * distance[i]=INF means it cannot be reached from root
	 */
	public static void bfs(int root) 
	{
	     Queue<Integer> queue = new LinkedList<Integer>();
	     visited[root] = true;
	     distance[root] = 0;
	     queue.add(root);
	     while(!queue.isEmpty())
	     {
	           int u = queue.remove();
	           for (int child : adjacencyList[u] )
	           {
	                 if(!visited[child])
	                 {
	                     visited[child]=true;
	                     distance[child]=distance[u]+1;
	                     queue.add(child);
	                 }
	           }
	     }
	}
}
