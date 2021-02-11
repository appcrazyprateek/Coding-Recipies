package blog.linkedlist.misc;

/**
 * Reverse Linked List in Chunks
 * @author Prateek
 *
 */
public class ReverseInChunks {
	public Node reverseInchunks(Node root, int k){

		if(root==null)
			return null;

		Node first=root;
		Node current=first;

		int count = k-1;
		while(current.next!=null && count > 0)
		{
			current=current.next;
			count--;
		}

		Node  last=reverseInchunks(current.next,k);
		current.next=null;
		
		Node subHead=reverse(first);

		first.next=last;

		return subHead;
	}

	private Node  reverse(Node head) {

		Node result;
		if(head.next ==null) 
			return head;

		result = reverse(head.next);

		head.next.next = head;

		head.next = null;

		return result;
	}

	public void displayList(Node root)
	{

		Node temp=root;
		while(temp!=null)
		{
			System.out.print(temp.data+"-->");
			temp=temp.next;
		}
		System.out.print("null");
		System.out.println();
	}

	public Node reverseChunkIterative(Node head, int k){

		if(head==null)
			return null;
		
		Node first, previous,last;
		first= previous=last=null;
	
		Node current=head;
		
		while(current!=null){
			

			Node temp=current; 
			previous =null;
            Node next=null;
            int count =k;
            
			while(current!=null  && count>0){
				next = current.next;
				current.next = previous ;
				previous = current ;
				current = next;
				count--;
			}
			
			if(first == null)
				first = previous;
			else
				last.next=previous;

			last=temp;
		}
		return first;
	}



	public static void main(String[] args) {
		Node head= new Node(1);
		head.next= new Node(2);
		head.next.next= new Node(3);
		head.next.next.next= new Node(4);
		head.next.next.next.next= new Node(5);
		head.next.next.next.next.next= new Node(6);
		head.next.next.next.next.next.next= new Node(7);
		head.next.next.next.next.next.next.next= new Node(8);

		ReverseInChunks obj=new ReverseInChunks();
		obj.displayList(head);
		//Node r=obj.reverseInchunks(head, 3);
		Node r=obj.reverseChunkIterative(head, 3);
		obj.displayList(r);

	}
}
