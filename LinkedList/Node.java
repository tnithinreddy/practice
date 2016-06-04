public class Node{
  public int data;
  public Node next;
  public Node random;
  public Node prev;
  public Node(int data){
  	this.data = data;
  	this.next = this.random =this.prev = null;
  }
}
