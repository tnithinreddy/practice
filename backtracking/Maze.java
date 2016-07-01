import java.util.*;
public class Maze{
	static public class Point{
		int x;
		int y;
		public Point(int a, int b){
			this.x = a;
			this.y = b;
		}
	} 
	static int a[][] = {
			{ 3, 5, 4, 4, 7, 3, 4, 6, 3 },
	        { 6, 7, 5, 6, 6, 2, 6, 6, 2 },
	        { 3, 3, 4, 3, 2, 5, 4, 7, 2 },
	        { 6, 5, 5, 1, 2, 3, 6, 5, 6 },
	        { 3, 3, 4, 3, 0, 1, 4, 3, 4 },
	        { 3, 5, 4, 3, 2, 2, 3, 3, 5 },
	        { 3, 5, 4, 3, 2, 6, 4, 4, 3 },
	        { 3, 5, 1, 3, 7, 5, 3, 6, 4 },
	        { 6, 2, 4, 3, 4, 5, 4, 5, 1 }
		};
	static LinkedList<Point> list;
	static boolean visited[][];
	public static void main(String[] args) {
		
		list = new LinkedList<Point>();
		visited = new boolean[9][9];
		// findPath(0,0);
		Iterator it = list.iterator();
		// while(it.hasNext()){
		// 	Point p = (Point)it.next();
		// 	System.out.println(p.x + " "+ p.y);
		// }
		list.clear();
		for (boolean [] x : visited ) {
			Arrays.fill(x,false);
		}
		findPath(0,8);
		it = list.iterator();
		while(it.hasNext()){
			Point p = (Point)it.next();
			System.out.println(p.x + " "+ p.y);
		}
		

		System.out.println("done");

	}
	public static boolean findPath(int x,int y){
		if (!safe(x,y)) {
			return false;
		}
		if (visited[x][y]) {
			return false;
		}
		list.add(new Point(x,y));

		if (x == 4 && y == 4) {
			return true;
		}
		visited[x][y] = true;
		if(findPath(x+a[x][y],y))
			return true;
		if (findPath(x-a[x][y],y)) {
			return true;
		}
		if (findPath(x,y+a[x][y])) {
			return true;
		}
		if (findPath(x,y-a[x][y])) {
			return true;
		}
		list.removeLast();
		visited[x][y] = false;
		return false;
	}
	public static boolean safe(int x, int y){
		if (x < 0 || x >= 9 || y < 0 || y >= 9) {
			return false;
		}
		return true;
	}
}