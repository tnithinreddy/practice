import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AllPairShortestPath{
	public static class Pair{
		int v;
		int w;
	}
	static int distance[];
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static boolean visited[];
	static int parent[];
	static ArrayList<Integer> adjacencyList[];
	static ArrayList<Integer> reverseList[];
	static final int INF = -1;
	static		Stack<Integer> time = new Stack<Integer>();
	static int n;
	static ArrayList<Integer> list;
	// @SuppressWarnings("unchecked");
	public static void main(String[] args) throws IOException{
		
		int t = Integer.parseInt(reader.readLine());
		while(t>0){
			t--;
			String firstLine[] = reader.readLine().trim().split(" ");
			n = Integer.parseInt(firstLine[0]);
			int e = Integer.parseInt(firstLine[1]);
			adjacencyList = (ArrayList<Integer>[])new ArrayList[n];
			for (int i = 0;i<n ; i++ ) {
				adjacencyList[i] = new ArrayList<Integer>();
			}
			buildGraph(adjacencyList, e);
			indegree();
			visited = new boolean[n];
			Pair p = new Pair();
			distance = new int[n];
			Arrays.fill(visited,false);
			Arrays.fill(distance,INF);
			// int root = Integer.parseInt(reader.readLine());
			// bfs(root-1);
			// for(int d:distance){
			// 	if (d!=0) {
			// 		System.out.print(d + " ");				
			// 	}
			// }
			// System.out.println();
			reverseList = (ArrayList<Integer>[])new ArrayList[n];
			for (int i =0; i<adjacencyList.length;i++ ) {
				if (visited[i]) {
					continue;
				}
				// visited[i] = true;
				dfs(i);
			}
			reverse(n);
			// for (int i =0; i<adjacencyList.length;i++ ) {
			// 	System.out.println(adjacencyList[i]);
			// }
			// 	System.out.println("after reversal");
			// for (int i =0; i<adjacencyList.length;i++ ) {
			// 	System.out.println(reverseList[i]);
			// }
			Arrays.fill(visited,false);
			// System.out.println(visited.toString());
			for (boolean b :visited ) {
			System.out.println(b);
				
			}
			while(!time.isEmpty()){
				int top = time.pop();

				if (visited[top]) {
					System.out.println("in true");
					continue;
				}
				list = new ArrayList<Integer>();
				System.out.println("top = " + top	);

				dfs2(top);
				System.out.println(list);
			}

		}
	}
	// @SuppressWarnings("unchecked") ;
	public static void buildGraph(ArrayList<Integer>[] adjacencyList, int e) throws IOException{
		for (int i = 0;i<e ; i++) {
			String words[] = reader.readLine().trim().split(" ");
			int a = Integer.parseInt(words[0]);
			int b = Integer.parseInt(words[1]);
			// a--;b--;
			adjacencyList[a].add(b);
			adjacencyList[b].add(a);
		}
	}
	// @SuppressWarnings("unchecked");
	public static void bfs(int root){
		Queue<Integer> queue = new LinkedList<Integer>();
		int weight = 6;
		queue.add(root);
		visited[root] = true;
		distance[root] = 0;
		while(!queue.isEmpty()){
			int parent = queue.remove();
			for(int child:adjacencyList[parent]){
				if (visited[child]) {
					continue;
				}
				queue.add(child);
				visited[child] = true;
				distance[child] = distance[parent] + weight;
			}
		}
	}
	// @SuppressWarnings("unchecked");
	public int connectedComponents(){
		int count = 0;
		for(int node = 0;node<adjacencyList.length;){
			count++;
			dfs(node);
			for ( ;node<adjacencyList.length; ) {
				if(visited[node])
					node++;
				else
					break;
			}
		}
		return count;
	}

	// @SuppressWarnings("unchecked");
	public static void dfs(int root){
		if (visited[root] == true) {
			return;
		}
		visited[root] = true;
		for(int child:adjacencyList[root]){
			dfs(child);
		}
		time.push(root);
		// System.out.println("top = " + root);
	}
	public static void dfs2(int root){
		if (visited[root] == true) {
			return;
		}
		visited[root] = true;
		for(int child:reverseList[root]){
			dfs2(child);
		}
		list.add(root);
	}
	public static void reverse(int n){
		int i = 0;
		for (i = 0 ;i< n  ;i++ ) {
			reverseList[i] = new ArrayList<Integer>();
		}

		for(i = 0;i<n;i++){
			for(int j = 0;j<adjacencyList[i].size();j++){
				reverseList[adjacencyList[i].get(j)].add(i);
			}
		}
	}

	public static void indegree(){
		int indegree[] = new int[n];
		Arrays.fill(indegree,0);
		for (ArrayList<Integer> list :adjacencyList ) {
			for (int v : list ) {
				indegree[v]++;
			}
		}
		Stack<Integer> stk = new Stack<Integer>();
		for (int i = 0;i< n ;i++ ) {
			if (indegree[i] == 0) {
				stk.push(i);
			}
		}
		while(!stk.isEmpty()){
			int t = stk.pop();
			for (int v : adjacencyList[t] ) {
					indegree[v]--;
					if (indegree[v] == 0) {
						stk.push(v);
					}
			}
			System.out.print(t + " ");
		}
		System.out.println("done----");
	}

}