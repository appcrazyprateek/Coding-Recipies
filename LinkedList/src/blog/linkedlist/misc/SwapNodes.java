package blog.linkedlist.misc;

/**
 * Swap K and N-K nodes in a singly Linked List
 * @author PRATEEK
 *
 */
public class SwapNodes {

	
	public static Node swapNodes(Node head,int k)
	{
		return head;
		
	}
	
	public static Node swap(Node head, Node curr, int i,int K)
	{
		if (curr.next.next == null) {
			return head;
		}
		i++;
		Node result = swap(head, curr.next,i, K);
		
		System.out.println(i);
		if(i==K-2)
		{
		  	System.out.println("Caught" + result.data + ":"+curr.data);
		}
		
		return curr;
		
	}
	
	public void replace(Node p1,Node p2)
	{
		if(p1!=p2 & p1!=null & p2!=null)
		{
			Node c1 = p1.next ;
			p1.next = p2.next; 
			p2.next.next = c1;
			
			Node n1= c1.next;
			
		}
		
	}
	
	public static void displayList(Node head) {
		Node tempNode;
		tempNode = head;
		while (tempNode != null) {
			System.out.print(tempNode.data + "-->");
			tempNode = tempNode.next;
		}
		System.out.print("null");
		System.out.println();
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.next = new Node(2);
		root.next.next = new Node(3);
		root.next.next.next = new Node(4);
		root.next.next.next.next = new Node(5);
		root.next.next.next.next.next = new Node(6);
		root.next.next.next.next.next.next = new Node(7);
		displayList(root);
		displayList(swap(root, root, 0, 2));

	}
}
