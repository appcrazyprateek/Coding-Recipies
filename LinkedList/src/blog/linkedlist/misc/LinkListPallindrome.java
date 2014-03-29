package blog.linkedlist.misc;

/**
 * To check if Linked list is pallindrome or not
 * @author Prateek
 */
public class LinkListPallindrome {
	
	public boolean checkPallindrome(Node head){
		Node n =isPallindrome(head,head);
		if(n==null)
			return false;
		return true;
	}
	
	public Node isPallindrome(Node head , Node curr){
		
		if(curr == null)
			return head;
		
		Node rval = isPallindrome(head, curr.next);
		
		if(rval!=null)
			if(rval.data == curr.data)
				return rval = (rval.next!=null) ? rval.next : rval;
		
		return null ;
	}
	
	public static void main(String[] args) {
		
		Node head= new Node(1);
		head.next= new Node(2);
		head.next.next= new Node(3);
		head.next.next.next= new Node(2);
		head.next.next.next.next= new Node(2);
		
		LinkListPallindrome obj = new LinkListPallindrome();
		System.out.println(obj.checkPallindrome(head));
	}
}
