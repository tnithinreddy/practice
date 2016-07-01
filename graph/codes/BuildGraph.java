import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;


class BuildGraph {

	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter writer = new PrintWriter(System.out,false);
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException{

		int n,m;
		String[] firstLine = reader.readLine().split(" ");
		n = Integer.parseInt(firstLine[0]);
		m = Integer.parseInt(firstLine[1]);
		ArrayList<Integer>[] adjacencyList = (ArrayList<Integer>[])new ArrayList[n]; 
		buildGraph(m,adjacencyList);
		writer.flush();
		writer.close();
		reader.close();

	}
	
	public static void buildGraph(int m,ArrayList<Integer>[] adjacencyList) throws IOException
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

}
