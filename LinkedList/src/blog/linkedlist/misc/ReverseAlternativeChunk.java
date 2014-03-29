package blog.linkedlist.misc;

public class ReverseAlternativeChunk {
	
	public Node reverseAlternativeChunks(Node root, int k , boolean flag){
	 
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
	 
	  Node  last=reverseAlternativeChunks(current.next,k , !flag);
	  current.next=null;
	   
	  Node subHead = null;
	  if(flag){
		  subHead=reverse(first);
		  first.next=last;
	  }
	  else
	  {
		  subHead = first;
		  current.next=last;
	  }
	  
	  return subHead;
	 }
	 
	 public Node  reverse(Node head) {
	 
	  Node result;
	  if(head.next ==null) 
	   return head;
	 
	  result = reverse(head.next);
	 
	  head.next.next = head;
	 
	  head.next = null;
	 
	  return result;
	 }
	 
	 public void displayList(Node head)
		{
			Node tempNode;
			tempNode=head;
			while(tempNode!=null)
			{
				System.out.print(tempNode.data+"-->");
				tempNode=tempNode.next;
			}
			System.out.print("null");
			System.out.println();
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
	 
			ReverseAlternativeChunk obj=new ReverseAlternativeChunk();
			System.out.println("Before: ");
			obj.displayList(head);
			Node r=obj.reverseAlternativeChunks(head, 3 , true);
			System.out.println("After: ");
			obj.displayList(r);
	}
}
