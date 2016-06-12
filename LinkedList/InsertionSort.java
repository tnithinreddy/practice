

public class InsertionSort{

	public static void main(String[] args) {

		Node head = new Node(-1);
		head.next = new Node(0);
		head.next.next = new Node(1);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(4);
		head.next.next.next.next.next = new Node(9);
		
		Node sorted,current,prev,next;
		sorted = head;
		head = head.next;
		sorted.next = null;

		while(head != null){
			next = head.next;
			if (sorted.data > head.data) {
				head.next = sorted;
				sorted = head;
				print(sorted);
			}else{
				current = sorted.next;
				prev = sorted;
				while(current != null){
					if (current.data > head.data) {
						break;
					}
					current = current.next;
					prev = prev.next;
				}
				prev.next = head;
				head.next = current;
				print(sorted);

			}
			head = next;
		}
		head = sorted;
		while(head!=null){
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();		
	}

	public static void print(Node head){
		while(head!=null){
			System.out.print(head.data + " ");
			head = head.next;
		}
				System.out.println();
	}
}