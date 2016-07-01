import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;


public class MazeDFS {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter writer = new PrintWriter(System.out,false);
	static boolean[][] visited;
	static char[][] matrix;  // ? indicates danger and - indicates safe
	static final int[] rowIncrement = {0,0,1,-1};   // possible moves in rows
	static final int[] colIncrement = {1,-1,0,0};   // possible moves in columns
    public static void main(String[] args) throws IOException
    {
    	int n,m;
    	String[] firstLine = reader.readLine().split(" ");
		n = Integer.parseInt(firstLine[0]);
		m = Integer.parseInt(firstLine[1]);
		
		//initialization part
		visited = new boolean[n][m];
		Arrays.fill(visited, false);
		for(int i=0;i<n;i++)
		{
			String input = reader.readLine();
			for(int j=0;j<m;j++)
				matrix[i][j]=input.charAt(j);
		}
		// initialization part over
		
		performDFS(n,m);
		writer.flush();
		writer.close();
		reader.close();
		
    }
    
    public static boolean isValid(int i,int j,int n,int m)
    {
    	if(i>=0 && i<n && j>=0 && j<m)
    	{
    		return matrix[i][j]!='?';  // it should not be a danger block
    	}
    	else
    		return false;
    }
    
    public static void dfs(int i,int j,int n,int m)
    {
    	visited[i][j]=true;
    	for(int k=0;k<rowIncrement.length;k++)
    	{
    		int newI = i + rowIncrement[k];
    		int newJ = j + colIncrement[k];
    		if(isValid(newI, newJ, n, m) && !visited[newI][newJ])
    		   dfs(newI,newJ,n,m);	
    	}
    	
    }
    
    public static void performDFS(int n,int m)  // extended DFS
    {
    	for(int i=0;i<n;i++)
    	{
    		for(int j=0;j<m;j++)
    		{
    			if(!visited[i][j])
    				dfs(i,j,n,m);
    		}
    	}
    }
}
