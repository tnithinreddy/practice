import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;


public class ClassificationOfEdges {

	static final int UNVISITED = 0;
	static final int EXPLORED = 1;    // in middle of DFS
	static final int VISITED = 2;
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter writer = new PrintWriter(System.out,false);
	static ArrayList<Integer>[] adjacencyList;
	static int[] visited;
	static int[] parent;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException{
		int n,m;
		String[] firstLine = reader.readLine().split(" ");
		n = Integer.parseInt(firstLine[0]);
		m = Integer.parseInt(firstLine[1]);
		
		// Initialization Part
		adjacencyList = (ArrayList<Integer>[])new ArrayList[n]; 
		for(int i=0;i<n;i++)
			adjacencyList[i] = new ArrayList<Integer>();
		visited = new int[n];
		Arrays.fill(visited,UNVISITED);
		parent = new int[n];
		
		buildGraph(m);
		performDFS(n);
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
	
	public static void dfs(int u)
	{
		visited[u] = EXPLORED;
		for(int child:adjacencyList[u])
		{
			if(visited[child]==UNVISITED)
			{
				writer.println("Edge "+u+"--->"+child+" is a Tree Edge");
				parent[child]=u;
				dfs(child);
			}
			else if(visited[child]==EXPLORED)
			{
				if(parent[u]==child)
					writer.println("1-->2-->1 type of cycle");
				else
					writer.println("Edge "+u+"--->"+child+" is a Back Edge And hence Cycle Detected");
			}
			else
			{
				writer.println("Edge "+u+"--->"+child+" is a Forward Edge/ Cross Edge");
			}
		}
		visited[u] = VISITED;
	}
	
	public static void performDFS(int n)   // extended DFS used for graphs which are not connected
	{
		for(int i=0;i<n;i++)
		{
			if(visited[i]==UNVISITED)
				dfs(i);
		}
	}


}
