
abstract class Knapsack{
	public static void main(String[] args) {
		int weights [] = {10, 20, 30};
		int values[] = {60, 100, 120};
		int W = 50;
		int [][]w = new int[50+1][values.length+1];
		for (int i = 0; i<=W ; i++ ) {
			for (int j = 0; j<=values.length ; j++ ) {
				if (i == 0 || j == 0) {
					w[i][j] = 0;
				}else{
					if (i >= weights[j-1]) {
						int k = values[j-1]+w[i-weights[j-1]][j-1] ;
						w[i][j] = java.lang.Math.max(k, w[i][j-1]);
					}else{
						w[i][j] = w[i][j-1];
					}
				}
			}
		}
		System.out.println(w[W][values.length]);
	}
}