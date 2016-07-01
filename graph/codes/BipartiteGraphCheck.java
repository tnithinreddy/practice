import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;


public class BipartiteGraphCheck {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter writer = new PrintWriter(System.out,false);
	static ArrayList<Integer>[] adjacencyList;
	static boolean[] visited;
	static int[] color;
	static boolean isGraphBipartite;
	
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
		color = new int[n];
		Arrays.fill(color, -1);  // -1 indicated not colored
		isGraphBipartite=true;
		// initialization part over
		
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
	
	public static void dfs(int u,int color1)
	{
		visited[u] = true;
		color[u]=color1;
		for(int child:adjacencyList[u])
		{
			if(!visited[child])
				dfs(child,1-color1);
			else
			{
				if(color[child]==color1)
					isGraphBipartite=false;
			}
		}
	}
	
	public static void performDFS(int n)   // extended DFS used for graphs which are not connected
	{
		for(int i=0;i<n;i++)
		{
			if(!visited[i])
			   dfs(i,0);
		}
		if(isGraphBipartite)
			writer.println("Graph is Bipartite");
		else
			writer.println("Graph is not Bipartite");
	}
}
