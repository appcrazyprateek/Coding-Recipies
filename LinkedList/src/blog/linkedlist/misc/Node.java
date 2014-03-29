package blog.linkedlist.misc;

/**
 * Linked List Node
 * @author Prateek
 */
class Node {

	public int data;
	public Node next;
	public Node prev;
	
	public Node(int data){
		this.data=data;
	}
	
	public String toString(){
		return ""+data;
	}
}
