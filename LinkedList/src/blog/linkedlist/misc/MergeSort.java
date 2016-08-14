package blog.linkedlist.misc;
/**
 * Mergesort of linked list
 * @author PRATEEK
 */
public class MergeSort {
	
	private static Node sort(Node head) {
		if (head == null || head.next == null)
			return head;

		Node left = head, right = null,temp=head;
		int c = 1;

		int mid = getCount(head)/2;
		while (temp != null) {
			if(c==mid)	{
				right = temp.next;
				temp.next=null;
				break;
			}
			c++;
			temp = temp.next;
		}
		
		Node head1 = sort(left);
		Node head2= sort(right);
		
		Node mergedHead = merge(head1,head2);
		
		return mergedHead;
	}

	private static Node merge(Node h1, Node h2) {
		if(h1==null)
			return h2;
		if(h2==null)
			return h1;
		
		Node mergedHead = null,mergedtail=null,temp = null;
		
		while(h1!=null && h2!=null){
			
			if(h1.data > h2.data)
			{
				temp = new Node(h2.data);
				h2=h2.next;
			}
			else
			{
				temp= new Node(h1.data);
				h1=h1.next;
			}
			if(mergedHead==null)
				mergedHead=temp;
			else
				mergedtail.next=temp;
			
			mergedtail=temp;
		}
		
		if(h1==null)
		{
			while(h2!=null)	{
				temp = new Node(h2.data);
				mergedtail.next=temp;
				mergedtail=temp;
				h2=h2.next;
			}
		}
		
		if(h2==null)
		{
			while(h1!=null)
			{
				temp = new Node(h1.data);
				mergedtail.next=temp;
				mergedtail=temp;
				h1=h1.next;
			}
		}
		
		return mergedHead;
	}

	private static int getCount(Node head) {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	public static void display(Node head)
	{
		Node tempNode=head;
		while(tempNode!=null)
		{
			System.out.print(tempNode.data+"-->");
			tempNode=tempNode.next;
		}
		System.out.print("null");
		System.out.println();
	}
	
	public static void main(String[] args) {
		Node root = new Node(5);
		root.next = new Node(1);
		root.next.next = new Node(6);
		root.next.next.next = new Node(1);
		root.next.next.next.next = new Node(3);
		root.next.next.next.next.next = new Node(7);

		display(sort(root));
	}
}
