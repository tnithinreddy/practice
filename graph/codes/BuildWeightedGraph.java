import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;


class BuildWeightedGraph {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter writer = new PrintWriter(System.out,false);
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException{

		int n,m;
		String[] firstLine = reader.readLine().split(" ");
		n = Integer.parseInt(firstLine[0]);
		m = Integer.parseInt(firstLine[1]);
		ArrayList<Pair<Integer,Integer>>[] adjacencyList = (ArrayList<Pair<Integer,Integer>>[])new ArrayList[n]; 
		buildWeightedGraph(m,adjacencyList);
		writer.flush();
		writer.close();
		reader.close();

	}
	
	public static void buildWeightedGraph(int m,ArrayList<Pair<Integer,Integer>>[] adjacencyList) throws IOException
	{
		for(int i=0;i<m;i++)
		{
			int a,b,w;
			String[] firstLine = reader.readLine().split(" ");
			a = Integer.parseInt(firstLine[0]);
			b = Integer.parseInt(firstLine[1]);
			w = Integer.parseInt(firstLine[2]);
			a--;b--;
			adjacencyList[a].add(new Pair<Integer,Integer>(b, w));
			adjacencyList[b].add(new Pair<Integer,Integer>(a, w));
		}
	}

}

class Pair<T1 extends Comparable<T1>,T2 extends Comparable<T2>> implements Comparable<Pair<T1,T2>>{
	private T1 first;
	private T2 second;
	
	public Pair(T1 first, T2 second) {
		this.first = first;
		this.second = second;
	}
	
	public T1 getFirst() {
		return first;
	}
	public void setFirst(T1 first) {
		this.first = first;
	}
	public T2 getSecond() {
		return second;
	}
	public void setSecond(T2 second) {
		this.second = second;
	}

	@Override
	public int compareTo(Pair<T1, T2> pair2) {
		int compare1 = (this.first).compareTo(pair2.first);
		if(compare1!=0)
		   return compare1;
		else
		   return (this.second).compareTo(pair2.second);
	}
	
}
