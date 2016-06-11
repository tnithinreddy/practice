
public class RodCutting{
	public static void main(String[] args) {
		int a[] = {1, 5, 8, 9, 10, 17, 17, 20};
		int size = a.length;
		getMaxValue(a,size); 		
	}
	public static void getMaxValue(int[] a, int size){
		int i,j;
		int[] val = new int[size+1];
		val[0] = 0;
		int max;
		i = j = 0;
		try{
			for (i = 1; i<=size; i++) {
				max = a[i-1];
				for (j = 0;j < i ; j++ ) {
					if (max < a[j]+val[i-j-1]) {
						max =	a[j]+val[i-j-1];				
					}
				}
				val[i] = max;
			}
		}catch (Exception e) {
		System.out.println("Exception => i-j = " + (i-j));
			
		}
		System.out.println(val[size]);
	}
}