public class Searching{
	public static void main(String[] args){
		int a[] = {2, 3, 4, 10, 40};
		int index = binarySearch(a,0,a.length-1,42);
		// System.out.println("found at " + index);
		index = binarySearchRecursion(a,0,a.length-1,1);
		System.out.println("found at " + index);


	}

	public static int binarySearch(int a[],int beg, int end, int e){
		int mid = (beg+end)/2;
		int res = -1;
		while(beg<=end){
			mid = (beg+end)/2;
			if (a[mid] == e) {
				res = mid;
				break;
			}
			if (a[mid] > e) {
				end = mid-1;
			}else{
				beg = mid + 1;
			}
		}
		return res;
	}
	public static int binarySearchRecursion(int a[], int beg, int end, int e){
		
		if (beg>end) {
			return -1;
		}
		int mid = beg + end;
		mid = mid/2;

		if (a[mid] == e) {
			return mid;
		}
		if (a[mid] > e) {
			return binarySearchRecursion(a,beg, mid-1,e);
		}else{
			return binarySearchRecursion(a, mid+1, end, e);
		}
	}
}