package blog.linkedlist.misc;

public class DeleteNode {
	
	public void deleteNode(Node current){
		Node nextNode = current.next;
		current.data=nextNode.data ;
		current.next = nextNode.next;
	}
}
