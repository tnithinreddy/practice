public class RotatedArray{
	public static void main(String[] args){


		int a[] = { 1, 2, 3, 4};

		int pivot = findPivot(a,0,a.length-1);
		System.out.println("pivot = " + pivot);
		// if (pivot == a.length-1) {
		// 	System.out.println("array is not rotated");
		// }else{
		// 	if (a[pivot] < a[pivot+1]) {
		// 		System.out.println("array is not rotated");
		// 	}
		// }
		print(a);
		


	}

	

	public static int findPivot(int a[], int beg, int end){
		int mid = beg + end;
		mid = mid/2;
		if (beg > end) {
			return -1;
		}
		if (beg == end) {
			return beg;
		}
		if (mid+1<=end && a[mid] > a[mid+1]) {
			return mid;
		}
		if (mid - 1 >=beg && a[mid] > a[mid]) {
			return mid-1;
		}
		if (a[beg] <= a[mid]) {
			return findPivot(a,mid+1,end);
		}else{
			return findPivot(a,beg,mid-1);
		}
	}
	// public static int findPivot(int arr[], int low, int high)
	// {
	//    // base cases
	//    if (high < low)  return -1;
	//    if (high == low) return low;
	 
	//    int mid = (low + high)/2;   /*low + (high - low)/2;*/
	//    if (mid < high && arr[mid] > arr[mid + 1])
	//        return mid;
	//    if (mid > low && arr[mid] < arr[mid - 1])
	//        return (mid-1);
	//    if (arr[low] >= arr[mid])
	//        return findPivot(arr, low, mid-1);
	//    return findPivot(arr, mid + 1, high);
	// }

	public static void print(int a[]){
		for ( int i = 0; i < a.length ;i++ ) {
			System.out.print(a[i] + " ");
		}
		System.out.println();

	}

}