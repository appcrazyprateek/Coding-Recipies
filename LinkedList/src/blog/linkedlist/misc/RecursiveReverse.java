package blog.linkedlist.misc;

public class RecursiveReverse {

	Node head;
	
	private void reverse(Node parent , Node child) {
		
		if(child.next == null)
		{
			head=child;
			return ;
		}
		reverse(parent.next, child.next);
		child.next = parent ;
	}
	
	
	private Node rev(Node parent , Node child) {
		Node result ;
		if(child.next == null)		{
			
			return child ;
		}
		
		result = rev(parent.next , child.next ) ;
		child.next = parent; 
		parent.next = null;
		
		return result;
	}
}
