package blog.linkedlist.misc;

public class Subtract {

	public static Node subtract(Node a) {
			subtract(a,a);
			display(a);
		return a;
	}
	
	

	private static void display(Node a) {
	
		Node temp = a;
		while(temp!=null)
		{
			System.out.print(temp.data + " --- >" );
			temp = temp.next;
		}
			
			
	}



	private static  Node subtract(Node head, Node curr) {
		if(curr == null)
			return head;
		
		Node rval = subtract(head, curr.next);
		
		if(rval!=null)
		{
			if(rval == curr || curr.next == rval)
				return null;
			rval.data = curr.data - rval.data;
			return rval.next == null ? rval : rval.next ;
			
		}
		return null ;
	}
	
	
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.next = new Node(2);
		root.next.next = new Node(3);
		root.next.next.next = new Node(4);
		root.next.next.next.next = new Node(5);
		root.next.next.next.next.next = new Node(6);
		subtract(root);
	}
}
