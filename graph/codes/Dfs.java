import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;


class Dfs {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter writer = new PrintWriter(System.out,false);
	static ArrayList<Integer>[] adjacencyList;
	static boolean[] visited;
	
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
		// initialization part over
		
		buildGraph(m);
		dfs(0);
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
		visited[u] = true;
		for(int child:adjacencyList[u])
		{
			if(!visited[child])
				dfs(child);
		}
	}

}
