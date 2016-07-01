import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;


public class TopologicalSort {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter writer = new PrintWriter(System.out,false);
	static ArrayList<Integer>[] adjacencyList;
	static boolean[] visited;
	static int[] topologicalSort;
	static int currIndexOfToplogicalArray;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException{
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
		topologicalSort=new int[n];
		currIndexOfToplogicalArray=n-1;
		// initialization part over
		
		buildDirectedGraph(m);
		performDFS(n);
		writer.flush();
		writer.close();
		reader.close();

	}
	
	public static void buildDirectedGraph(int m) throws IOException
	{
		for(int i=0;i<m;i++)
		{
			int a,b;
			String[] firstLine = reader.readLine().split(" ");
			a = Integer.parseInt(firstLine[0]);
			b = Integer.parseInt(firstLine[1]);
			a--;b--;
			adjacencyList[a].add(b);
		}
	}
	
	public static void dfs(int u)
	{
		visited[u] = true;
		topologicalSort[currIndexOfToplogicalArray--]=u;
		for(int child:adjacencyList[u])
		{
			if(!visited[child])
				dfs(child);
		}
	}
	
	public static void performDFS(int n)   // extended DFS used for graphs which are not connected
	{
		for(int i=0;i<n;i++)
		{
			if(!visited[i])
			   dfs(i);
		}
		writer.println("Tpological Array: ");
		for(int u:topologicalSort)
		{
			writer.print(u+" ");
		}
		writer.println();
	}
}
