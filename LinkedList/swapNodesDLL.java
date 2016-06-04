abstract class SwapNodesDLL{
	static Node head;
	public static void insert(int d){
		Node n = new Node(d);
		if (head == null) {
			head = n;
			return ;
		}
		n.next =head;
		head.prev = n;
		head = n;
	}
	public static void print(){
		Node n = head;
		while(n!=null){
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}
	public static int getSize(){
		Node n = head;
		int count = 0;
		while(n!=null){
			count++;		
			n = n.next;
		}
	}
	public static void swap(int k){
		int size = getSize();
		if (size<k || size == 0) {
			return;
		}
		int i = 0;
		Node first = head,second = head;
		for (i=1;i<k ; i++) {
			first = first.next;
		}
		for (i=1;i<n-k+1; i++ ) {
			second = second.next;
		}

		// first and second are here
		if (first == second) {
			return;
		}
		

		if (k = 1) {
			head = second;
		}
		if (k = size) {
			head = first;
		}

	}
	public static void main(String[] args) {
		
		insert(5);
		insert(2);
		insert(20);
		insert(8);
		insert(3);
		insert(1);
		int  k =2;
		print();
		swap(k);
		print();

	}
}