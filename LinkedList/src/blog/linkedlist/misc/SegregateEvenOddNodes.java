package blog.linkedlist.misc;


/*Given a Linked List of integers, write a function to modify the linked list such that all even numbers appear before all the odd numbers in the modified linked list. Also, keep the order of even and odd numbers same.
Examples:
Input: 17->15->8->12->10->5->4->1->7->6->NULL
Output: 8->12->10->4->6->17->15->5->1->7->NULL*/


public class SegregateEvenOddNodes {

	static Node start;
	static Node temp;
	static Node even_ptr;
	static Node odd_ptr;
	static Node first_odd_ptr;

	public static void main(String[] args) {
		addNode(3);
		addNode(5);
		addNode(6);
		addNode(7);
		addNode(4);
		addNode(3);
		addNode(1);
		addNode(8);
		addNode(12);
		addNode(15);
		segregate();
		display();
		
	}

	public static void segregate()
	{
		temp=start;
		while(temp.next!=null)
		{
			// For Even Data 
 			if(temp.data%2==0)
			{
				if(even_ptr==null)
				{
					start=temp;
					even_ptr=temp;
					
				}
				else
				{
					even_ptr.next=temp;
					even_ptr=temp;
					
				}
			}
			else // For Odd Data
			{
				if(odd_ptr==null)
				{
					first_odd_ptr=temp;
					odd_ptr=temp;
				}
				else
				{
					odd_ptr.next=temp;
					odd_ptr=temp;
					
				}
			}
 			temp=temp.next;
		}
		
		if(even_ptr!=null)
		{
			even_ptr.next=first_odd_ptr;
		}
		if(odd_ptr!=null)
		{
			odd_ptr.next=null;
		}
		
	}
	
	public static void addNode(int data)
	{
		Node newNode=new Node(data);
		if(start==null)
		{
			start=newNode;
			start.next=null;
		}
		else
		{
			temp=start;
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			temp.next=newNode;
			temp=temp.next;
			temp.next=null;
		}
	}
	
	public static void display()
	{
		temp=start;
		while(temp!=null)
		{
			System.out.print(temp.data+"--->");
			temp=temp.next;
		}
		
	}
}
