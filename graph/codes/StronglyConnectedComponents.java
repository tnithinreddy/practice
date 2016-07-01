import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;


public class StronglyConnectedComponents {

	static final int UNVISITED = 0;
	static final int EXPLORED = 1;    // in middle of DFS
	static final int VISITED = 2;
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter writer = new PrintWriter(System.out,false);
	static ArrayList<Integer>[] adjacencyList;
	static int[] startTime,lowestStartTime,visited,parent;
	static int numberOfStronglyConenctedComponents;
	static int time;
	static Stack<Integer> stack1;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException{
		int n,m;
		String[] firstLine = reader.readLine().split(" ");
		n = Integer.parseInt(firstLine[0]);
		m = Integer.parseInt(firstLine[1]);
		
		// Initializing part started
		adjacencyList = (ArrayList<Integer>[])new ArrayList[n]; 
		for(int i=0;i<n;i++)
		{
			adjacencyList[i] = new ArrayList<Integer>();
		}
		startTime = new int[n];
		lowestStartTime = new int[n];
		visited = new int[n];
		Arrays.fill(visited,UNVISITED);
		parent = new int[n];
		time = 0;
		// Initializing part over
		
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
		visited[u] = EXPLORED;
		startTime[u] = lowestStartTime[u] = time++; 
		for(int child:adjacencyList[u])   // for each type of loop
		{
			if(visited[child]==UNVISITED)   // Tree Edge
			{
				stack1.add(u);
				parent[child]=u;
				dfs(child);
				lowestStartTime[u] = Integer.min(lowestStartTime[u],lowestStartTime[child]);
			}
			else if(visited[child]==EXPLORED)  // Back Edge
			{
				if(parent[u]!=child)  // Ignoring u->parent(u) back edge 
				{
					/* you can use only 1 back edge so min is with just startTime[u] and
					not with lowestStartTime[u]*/
					lowestStartTime[u] = Integer.min(lowestStartTime[u],startTime[child]); 
				}
			}
		}
		if(lowestStartTime[u]>=startTime[u]) //new component starts from u
		{
			// printing strongly connected component starting from u 
			writer.println("COnnected Component number "+numberOfStronglyConenctedComponents);
			numberOfStronglyConenctedComponents++;
			while(stack1.peek()==u)
			{
				writer.print(stack1.pop()+" ");
			}
			writer.print(stack1.pop()+" ");  // for removing u
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
