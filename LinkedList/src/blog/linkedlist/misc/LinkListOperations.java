package blog.linkedlist.misc;

/**
 * 
 * @author r.prateek
 *
 */
public class LinkListOperations {

	static Node startNode;
	Node currentNode;
	Node parentNode;
	Node childNode;

	//--------------- Add Element in the Beginining   ----------------------------------------------------------------------	
	public void addFirst(int val)
	{
		Node newNode=new Node(val);
		if(startNode==null)
			startNode=newNode;	
		else
			newNode.next=startNode;
		startNode=newNode;
	}

	//--------------- Add Element at Last  ----------------------------------------------------------------------
	public void addLast(int val)
	{
		Node tempNode;
		Node newNode=new Node(val);
		newNode.next=null;

		if(startNode==null)
			startNode=newNode;	
		else
		{
			tempNode=startNode;
			while(tempNode.next!=null)
				tempNode=tempNode.next;

			tempNode.next=newNode;
		}
	}

	//-----------------------Delete a node-----------------------------
	public boolean deleteNode(int val)
	{
		boolean isDeleted=false;
		if(val==startNode.data)
		{
			startNode=startNode.next;
		}
		else
		{
			parentNode=startNode;
			childNode=startNode.next;
			while(childNode!=null)
			{
				if(childNode.data==val)
				{
					parentNode.next=childNode.next;
					isDeleted=true;
					break;
				}

				parentNode=childNode;
				childNode=childNode.next;
			}
		}
		return isDeleted;
	}

	//-----------------------Delete a node at specified Index----------------------------
	public boolean deleteIndex(int index)
	{
		boolean isDeleted=false;
		int nodeCounter=0;
		parentNode=startNode;
		childNode=startNode.next;
		while(childNode!=null)
		{
			if(nodeCounter==index)
			{
				parentNode.next=childNode.next;
				isDeleted=true;
				break;
			}
			parentNode=childNode;
			childNode=childNode.next;
			nodeCounter++;
		}
		return isDeleted;
	}

	//---------------------reverse List without Recursion---------------------
	public boolean reverseList()
	{
		Node tempNode;
		childNode=startNode;
		if(childNode==null)
			return false;

		parentNode=null;
		while(childNode!=null)
		{
			tempNode=parentNode;
			parentNode=childNode;
			childNode=childNode.next;
			parentNode.next=tempNode;
		}

		childNode=startNode;
		return true;
	}

	//---------------------reverse List with Recursion---------------------
	/**
	 * Reverse List Using recursion
	 * @param head
	 * @return
	 */
	private Node  reverse(Node head) {

		Node result;
		if(head.next ==null) 
			return head;

	    result = reverse(head.next);

	    head.next.next = head;

	    head.next = null;

	    return result;
	}
	
	
	// ---------------------------Display List-----------------------------
	public void displayList()
	{
		Node tempNode;
		tempNode=startNode;
		while(tempNode!=null)
		{
			System.out.print(tempNode.data+"-->");
			tempNode=tempNode.next;
		}
		System.out.print("null");
		System.out.println();
	}

	//------------ Value at a specifed Index-------------------------
	public int valueAtIndex(int index)
	{   
		Node tempNode;
		int nodeCounter=0;
		tempNode=startNode;
		while(tempNode!=null)
		{
			if(nodeCounter==index)
				return tempNode.data;

			tempNode=tempNode.next;
			nodeCounter++;
		}
		return -1;
	}

	//------------ Get number of Nodes-------------------------
	public int getNumberofNodes()
	{
		int count=0;

		Node tempNode=startNode;
		while(tempNode!=null)
		{
			++count;
			tempNode=tempNode.next;
		}
		System.out.println("Number of Nodes: "+count);
		return count;
	}

	//---------------------Check if Pallindrome----------------------------

	public boolean isPallindrome()
	{
		int count= getNumberofNodes();  // get the number of nodes in the list

		int mid; // to get the next element of mid
		if(count%2==0)
			mid=count/2;
		else
			mid=count/2+1;


		// advancing to set the 2nd half of linked list
		Node tempNode=startNode;
		while(mid>0)
		{
			tempNode=tempNode.next;
			mid--;
		}

		parentNode=null;
		childNode=tempNode;
		while(childNode!=null)
		{
			tempNode=parentNode;
			parentNode=childNode;
			childNode=childNode.next;
			parentNode.next=tempNode;
		}

		Node rightPointer=parentNode;
		Node leftPointer=startNode;

		int i=0;
		while(i<count/2)
		{
			if(leftPointer.data!=rightPointer.data)
			{
				System.out.println();
				System.out.println("Not A Pallindrome");
				return false;
			}
			leftPointer=leftPointer.next;
			rightPointer=rightPointer.next;
			i++;
		}
		System.out.println();
		System.out.println(" A Pallindrome");
		return true;
	}

	//---------------------Sort List----------------------------	
	public void sort()
	{
		//TODO
		/*tempNode=startNode;

		while(tempNode!=null)
		{

		}*/
	}

	//-----------------------Rotate list by a specified number -------------------------------
	/*
	 * we need to change next of kth node to NULL, next of last node to previous head node,
	 *  and finally change head to (k+1)th node. So we need to get hold of three nodes: kth node, (k+1)th node and last node.
	 */
	public void rotate(int k)	{
		System.out.println("Before Rotation the list is:");
		displayList();

		int N=getNumberofNodes();
		k=N - k%N;  // the nodes actually rotated in N-k  (mod is taken if k>N) 

		Node kthNode = null;
		Node tempNode=startNode;
		int count=0;
		while(tempNode.next!=null )
		{
			count++;
			tempNode=tempNode.next;
			if(count == k)
			{
				kthNode=tempNode;
			}
		}
		Node lastNode=tempNode;


		lastNode.next=startNode;
		startNode=kthNode.next;
		kthNode.next=null;

		System.out.println("After Rotation the list is:");
		displayList();
	}

	//------------------------------------------------------------------------

	public void printReverse(Node start)
	{
		if(start==null)
			return ;

		printReverse(start.next);
		System.out.println(start.data);
	}


	public Node skipAndDelete(int m, int n, Node start)
	{
		Node temp=start;
		Node storeTemp = null;
		if(m > getSize(start))
		{
			System.err.println("The linked list is too small to Skip");
		}
		else
		{
			for(int i=0;i<=m;i++)
			{
				temp=temp.next;
			}

			if(n > getSize(temp))
			{
				System.err.println("The linked list is too small to Delete");
			}
			else
			{
				storeTemp=temp;
				for(int i=0;i<n-1;i++)
				{
					temp=temp.next;
				}
				storeTemp.next=temp;
				storeTemp=temp;
			}
		}
		return storeTemp;
	}

	public int  getSize(Node start)
	{
		int count=0;
		Node temp=start;
		while(temp.next!=null)
		{	
			count++;
			temp=temp.next;
		}
		return count;
	}

	public static void main(String[] args) {

		LinkListOperations l=new LinkListOperations();
		l.addFirst(4);
		l.addFirst(3);
		l.addFirst(2);
		l.addFirst(1);
		/*l.addFirst(5);
		l.addFirst(6);
		l.addFirst(7);
		l.addFirst(8);
		l.addFirst(9);
		l.addFirst(10);*/

	    l.printList(startNode);
		//l.printList(l.rev(startNode , startNode.next));
		//l.displayList();
		//l.skipAndDelete(2, 4, startNode);
		//l.displayList();
		//l.printReverse(startNode);

	}

	Node head;

	
	
	private void printList(Node head)
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
}
