package blog.linkedlist.misc;




public class DetectAndRemoveLoop {

	static Node start;
	static Node last;
	static Node temp;
	static Node currentNode;

	public static void main(String[] args) {
		addNode(1);
		addNode(2);
		addNode(3);
		addNode(8);
		addNode(9);
		addNode(13);
		addNode(14);

		makeloop();
		detectLoopAndRemoveLoop();

		display();

	}

	private static void makeloop() {
		start.next.next.next.next.next.next.next = start.next.next;
	}

	public static void addNode(int data) {
		Node newNode = new Node(data);
		if (start == null) {
			start = newNode;
			start.next = null;
		} else {
			temp = start;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
			temp = temp.next;
			temp.next = null;
		}
	}

	private static void detectLoopAndRemoveLoop() {
		Node slow_ptr=start;
		Node fast_ptr=start;

		while(slow_ptr!=null && fast_ptr!=null && fast_ptr.next!=null )
		{
			slow_ptr=slow_ptr.next;
			fast_ptr=fast_ptr.next.next;
			if(slow_ptr==fast_ptr)
				removeLoop(slow_ptr);
		}
	}

	private static void removeLoop(Node slow_ptr) {
		Node ptr1=slow_ptr;
		Node ptr2=slow_ptr;

		// Counter number of nodes in loop
		int k=1;
		while(ptr1.next !=ptr2)
		{
			ptr1=ptr1.next;
			k++;
		}

		// Fix one pointer to head
		ptr1=start;

		ptr2=start;
		for(int i=0;i<k;i++)
		{
			ptr2=ptr2.next;
		}

		/*  Move both pointers at the same pace,
	      they will meet at loop starting node */
		while(ptr2!=ptr1)
		{
			ptr1=ptr1.next;
			ptr2=ptr2.next;
		}
		// Get pointer to the last node
		ptr2=ptr2.next;
		while(ptr2.next!=ptr1)
		{
			ptr2=ptr2.next;
		}

		/* Set the next node of the loop ending node
	      to fix the loop */
		ptr2=ptr2.next=null;

	}

	public static void display() {
		temp = start;
		while (temp != null) {
			temp = temp.next;
		}
	}

}

