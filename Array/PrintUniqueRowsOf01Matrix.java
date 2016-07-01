import java.util.*;
abstract class PrintUniqueRows{
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		int a[][] = {
							{0, 1, 0, 0, 1},
					        {1, 0, 1, 1, 0},
					        {0, 1, 0, 0, 1},
					        {1, 0, 1, 0, 0}
    					};
    	int rows = 4;
    	int col = 5;
    	boolean print = false;
    	int p = 0;
    	for(int  i = 0 ;i < rows; i++){
    		int value = getDecimalValue(a[i],col);
    		if (!set.contains(value)) {
    			set.add(value);
    			// print the row
    			for (int x :a[i] ) {
    				
    				System.out.print( x+ " ");
    			
    			}
    		
    				System.out.println();
    			
    		}
    	}
		System.out.println("done");
	}

	public static int getDecimalValue(int a[], int col){
		int res = a[0] ;
		for (int i = 1; i < col ; i++) {
			res= res << i + a[i] ;
		}

		return res;
	}

}