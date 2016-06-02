

abstract class Clone{

	public static void main(String[] args) {

		Node head = new Node(5);
		head.next = new Node(3);
		head.next.next = new Node(1);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(4);
		head.next.next.next.next.next = new Node(9);
		Node newList = clone(head);
		head.random = head.next.next;
	}
}