package blog.linkedlist.misc;
/**
 * Swap pair wise node using Iteration
 * @author Prateek
 */
public class PairSwapIterative {

	/**
	 * Iterative Subroutine to swap pairs of nodes of linked list
	 * @return new Head of the linked list
	 */
	public Node pairSwap(Node head){
		Node temp=head;
		head=head.next; //new head
		
		Node front,back;
		while(temp!=null && temp.next!=null)
		{
			back=temp;
			front=temp.next;
			
			back.next=front.next;
			front.next=back;
			
			if(temp.next!=null)
				temp=temp.next;
			if(temp.next!=null)
				back.next=temp.next;
		}
		return head;
	}

	public static void main(String[] args) {
		PairSwapIterative obj = new PairSwapIterative() ;

		Node root = new Node(1) ;
		root.next =new Node(2) ;
		root.next.next =new Node(3) ;
		root.next.next.next =new Node(4) ;
		root.next.next.next.next =new Node(5) ;
		//root.next.next.next.next.next =new Node(6) ;
		
		//Node head=obj.pairSwap(root);
		Node head=obj.pairSwapRecursive(root);
		obj.display(head);
	}
	
	public Node pairSwapRecursive(Node head){
		Node curr=head;
		Node front=null;
 
		if(curr!=null && curr.next!=null){
			front=curr.next;
			curr.next = pairSwap(front.next);
			front.next=curr;
		}
		return (front!=null) ? front : curr;
	}
 
	
	/**
	 * Display the nodes of the linked list
	 */
	public void display(Node root)	{
		Node tempNode;
		tempNode=root;
		while(tempNode!=null){
			System.out.print(tempNode.data+"-->");
			tempNode=tempNode.next;
		}
		System.out.print("null");
		System.out.println();
	}

}
