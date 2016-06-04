import java.util.*;
public class StackOper{
	boolean isEmpty;
	private class Node{
		int data;
		Node next;
		public Node(int d){
			this.data = d;
			next = null;
		}
	}
	Node top;
	public StackOper(){
		isEmpty = true;
		top = null;
	}
	public void push(int data){
		Node n = new Node(data);
		if (top == null) {
			top = n;
			return;
		}
		n.next = top;
		top = n;

	}
	public int pop(){
		if (top == null) {
			return INT_MIN;
		}
		int d = top.data;
		top = top.next;
		if (top ==null) {
			isEmpty = true;
		}
	}
	public boolean isEmpty(){
		System.out.println("isEmpty");
		return true;
	}
}