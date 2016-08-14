package blog.linkedlist.misc;


/**
 * Add Numbers
 * @author Prateek
 */
 public class AddLists {

	/**
	 * Procedure to calulate resultant list
	 * @param head1: head of 1st list
	 * @param head2: head of 2st list
	 * @return
	 */
	public Node addLists(Node head1 , Node head2)
	{
		int sum1 = addition(head1,0); //sum of 1st list
		int sum2 = addition(head2,0); //sum of 2nd list
		return createList(sum1 + sum2);
	}
	
	/**
	 * Adds all the elements in the list
	 * @return added sum
	 */
	public int addition(Node head ,int sum){
		if(head==null)
			  return sum;
		
		sum = sum*10 + head.data;
		return  addition(head.next , sum) ;
	}
	
	/**
	 * Creating list of the total sum Obtained
	 * @param totSum is sum of the two list obtained
	 * @return head of the new list created
	 */
	public Node createList(int totSum){
		Node head=null;
		
		while(totSum > 0){
			int val =totSum%10 ;
			totSum = totSum/10;
			head=insert(val,head);
		}
		
		return head;
	}
	
	/**
	 * Inserts node at the beggining
	 * @return head of the list
	 */
	public Node insert(int val , Node head){
		Node node= new Node(val);
		
		if(head==null)
			head=node;
		else
		{
			node.next = head;
			head=node;
		}
		return head;
	}
	
	
	/**
	 * Prints the new list created
	 * @param head
	 */
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
		Node head1=new Node(5);
		head1.next= new Node(3);
		head1.next.next= new Node(7);
		head1.next.next.next= new Node(6);
		
		
		Node head2=new Node(9);
		head2.next= new Node(4);
		head2.next.next= new Node(7);
		head2.next.next.next= new Node(2);
		
		
		AddLists obj=new AddLists();
		Node sumList= obj.addLists(head1, head2);
		obj.displayList(sumList);
	}
}
