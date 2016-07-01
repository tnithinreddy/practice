import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
/*
   Cut Vertex or Cut Edge is a vertex or edge such that by removing the vertex or edge 
   graph gets divided into more than 1 components.
 */
/*
     Note: lowestStartTime[i] indicates what is lowest startTime index
     one can go starting from i by using only 1 back edge and not 
     allowed to use edge connecting i and parent of i. This is because 
     we can know if component Ci is connected to parent component C1.
 */
/*
    There is exception for root as root has no parent Component. So it has to 
    just check if it has 1 child or more than 1 child.
 */
public class CutVertexCutEdge {

	static final int UNVISITED = 0;
	static final int EXPLORED = 1;    // in middle of DFS
	static final int VISITED = 2;
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter writer = new PrintWriter(System.out,false);
	static ArrayList<Integer>[] adjacencyList;
	static int[] startTime,lowestStartTime,visited,parent;
	static boolean[] cutVertex;
	static int time;
	static int root;
	static int rootChildren;
	
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
		cutVertex=new boolean[n];
		Arrays.fill(cutVertex, false);
		time = 0;
		// Initializing part over
		
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
		startTime[u] = lowestStartTime[u] = time++; 
		for(int child:adjacencyList[u])   // for each type of loop
		{
			if(visited[child]==UNVISITED)   // Tree Edge
			{
				if(u==root)     // maintaining boundary condition
					rootChildren++;
				parent[child]=u;
				dfs(child);
				// Component described by child is not connected to C1 (Component of Parent)
				if (lowestStartTime[child] >= startTime[u])  
				    cutVertex[u] = true;
				if (lowestStartTime[child] > startTime[u])  // think why greater sign used here?? 
				    writer.println(" Edge "+u+"--->"+child+" is a Cut Edge\n");
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
		visited[u] = VISITED;
	}
	
	public static void performDFS(int n)   // extended DFS used for graphs which are not connected
	{
		for(int i=0;i<n;i++)
		{
			if(visited[i]==UNVISITED)
			{
				root = i;
				rootChildren = 0;
				dfs(i);
				if(rootChildren>1)         // boundary condition for root
					cutVertex[root]=true;
				else
					cutVertex[root]=false;
			}
		}
	}

}
