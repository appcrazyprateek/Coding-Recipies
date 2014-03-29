package blog.linkedlist.misc;

/**
 * Reverse Linked List(recursively)
 * @author Prateek
 */
public class ReverseList {

	/**
	 * Reverse Linked List (recursively) 
	 * @param head
	 * @return
	 */
   public Node reverse(Node head){
	   Node revHead ; // to store the new Head pointer
	   
	   if( head== null || head.next==null ) 
		   return head;
	   
	   revHead=reverse(head.next) ;
	   
	   head.next.next = head; // points to itself to create loop
	   head.next = null;      // breaks the loop (old link)
	   
	   return revHead ;
   }
   
   public static void main(String[] args) {
	   //   1 -> 2 - > 3 -> 4 -> NUll
		ReverseList obj = new ReverseList() ;
		Node root = new Node(1) ;
		root.next =new Node(2) ;
		root.next.next =new Node(3) ;
		root.next.next.next =new Node(4) ;
		
		System.out.println("Original List :");
		obj.display(root);
		
		System.out.println("\n\nReversed List :");
		obj.display(obj.reverse(root)) ;
		
	}
   
   private void display(Node head) {
	 Node temp = head ;
	 while(temp!=null) {
		 System.out.print(temp + "\t");
		 temp=temp.next ;
	 }
   }
}
