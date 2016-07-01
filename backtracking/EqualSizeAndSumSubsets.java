import java.util.*;
public class EqualSizeAndSumSubsets{
	static int a[] = {3, 4, 5, -3, 100, 1, 89, 54, 23, 20};
	static int length;
	static boolean solution[];
	static boolean current[];
	static int diff = Integer.MAX_VALUE;
	public static void main(String[] args) {
		length = a.length;
		current = new boolean[length];
		solution = new boolean[length];
		Arrays.fill(current, false);
		Arrays.fill(solution,false);
		int sum = 0;
		for (int i = 0;i<length;i++ ) {
			sum += a[i];
		}
		// matrix, length, current position, numofelementsselected till now,sum till now
		findSubsets(a,length,sum,0,0,0);
		for (int l = 0; l < length; l++ ) {
			if (solution[l] == true) {
				System.out.print(a[l] + " ");				
			}
		}
		System.out.println("second ");
		for (int l = 0; l < length; l++ ) {
			if (solution[l] == false) {
				System.out.print(a[l] + " ");				
			}
		}
		System.out.println();
	}

	public static void findSubsets(int a[], int length,int sum, int currentPosition, int selectedCount, int sumTillNow){
		if(currentPosition == length){
			return;
		}
		if (length/2 - selectedCount > length - currentPosition) {
			return;
		}
		if (selectedCount > length/2) {
			return;
		}

		findSubsets(a,length,sum,currentPosition+1,selectedCount,sumTillNow);
		selectedCount++;
		current[currentPosition] = true;
		sumTillNow = sumTillNow+a[currentPosition];
		if (selectedCount == length/2) {
			// check for sum if sum's difference 
			int otherSum = 0;
			for (int j = 0;j<length;j++ ) {
				if (current[j] == false) {
					otherSum += a[j];
				}
				if (Math.abs(otherSum-sumTillNow) < diff) {
					System.out.println("there is a min");
					diff = Math.abs(otherSum-sumTillNow);
					// solution 
					System.out.println("there is a min = " + diff );
					for (int k = 0 ; k<length;k++ ) {
						solution[k] = current[k];
					}
				}
			}
		}else{
		findSubsets(a,length,sum,currentPosition+1,selectedCount,sumTillNow);
		}
		sumTillNow = sumTillNow - a[currentPosition];
		selectedCount--;
		current[currentPosition] = false;
	}
}