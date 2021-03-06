public class Sorting{
	public static void main(String[] args){
		// int a[] = {64, 25, 12, 22, 11};
		int a[] = {1, 20, 6, 4, 5};

		// bubbleSort(a,a.length);
		// selectionSort(a,a.length);
		int b[] = new int[a.length];
		// System.out.println("Inversion Count " + mergeSort(a,b,0,a.length-1));

		// insertionSort(a,a.length);
		quickSort(a,0,a.length-1);
		print(a);
		


	}

	public static int partition(int a[], int beg, int end){
		int pivot = a[end];
		int i = beg-1,t;
		for (int j = beg; j < end ; j++) {
			if (a[j] <= pivot) {
				i++;
				t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}
		t = a[i+1];
		a[i+1] = a[end];
		a[end] = t;
		return i+1;
	}

	public static void quickSort(int a[],int beg,int end){
		if (beg < 0 || beg >= end) {
			return;
		}
		int p = partition(a,beg,end);
		quickSort(a,beg,p-1);
		quickSort(a,p+1,end);

	}

	public static int mergeSort(int a[],int b[], int left, int right){
		if (left >= right) {
			return 0;
		}
		int mid = left+right;
		mid/= 2;
		int leftCount = mergeSort(a,b,left,mid);
		int rightCount = mergeSort(a,b,mid+1,right);
		int i = left;
		int j = mid+1;
		int resIndex = left;
		int count = 0;
		while(i<=mid && j<=right){
			if (a[i] == a[j]) {
				b[resIndex++] = a[i];
				b[resIndex++] = a[i];
				j++;
				i++;
			}else{
				if (a[i] > a[j]) {
					b[resIndex++] = a[j];
					count = count + (mid-i+1);
					j++;
				}else{
					b[resIndex++] = a[i];
					i++;
				}
			}
		}
		while(i<=mid){
			b[resIndex++] = a[i++];
		}
		while(j<=right){
			b[resIndex++] = a[j++];
		}
		while(left<=right){
			a[left] = b[left];
			left++;
		}
		return count + leftCount + rightCount;
	}

	public static void bubbleSort(int a[], int n){
		int t;
		boolean swapped = false;
		for (int i = 0; i < n ;i++ ) {
			swapped = false;
			for (int j = 0; j< n-i-1;j++ ) {
				if (a[j] > a[j+1]) {
					t = a[j];
					a[j] = a[j+1];
					a[j+1] = t;
					swapped = true;
				}
			}
			if (swapped == false) {
				break;
			}
		}
		print(a);
	}

	public static void selectionSort(int a[], int n){
		int min,pos = -1;int t;
		for (int i = 0; i < n; i++ ) {
			min = a[i];
			for (int j = i; j < n; j++) {
				if (a[j] < min) {
					min = a[j];
					pos = j;
				}
			}
			if (min != a[i]) {
				t = a[i];
				a[i] = a[pos];
				a[pos] = t;
			}
		}
		print(a);
	}
	
	public static void insertionSort(int a[], int n){
		int j,t,current;
		for (int i = 1; i < n; i++){
			current = a[i];
			for ( j = i-1; j >= 0 ; j--){
				if (a[j] > current) {
					a[j+1] = a[j];
				}else{
					break;
				}
			}
			a[j+1] = current;
		}
		print(a);
	}

	// public static void selectionSort(int a[], int n){}

	public static void print(int a[]){
		for ( int i = 0; i < a.length ;i++ ) {
			System.out.print(a[i] + " ");
		}
		System.out.println();

	}

}