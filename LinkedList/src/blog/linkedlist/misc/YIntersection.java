package blog.linkedlist.misc;
/**
 * Find the intersection of Linked Lists
 * @author Prateek Rathore
 */
public class YIntersection {
	/**
	 * Detect Intersection of linked Lists
	 * @return null if no intersection , else return the intersecting node
	 */
	public static Node detectIntersection(Node head1, Node head2){
		int len1=0, len2=0,offset =0;
		Node temp1,temp;
		
		//Step1
		//==== length calculation starts
		temp = head1;
		while(temp!=null){
			temp=temp.next;
			len1++;
		}

		temp=head2;
		while(temp!=null){
			temp=temp.next;
			len2++;
		}

		//==== length calculation ends

		//Step 2
		//==== Pointer advancement on the basis of offset starts
		offset = len1 > len2 ? (len1 - len2) : (len2 - len1) ;
		if(len1>len2){
			temp = head1;
			temp1= head2;
		}
		else {	
			temp = head2;
			temp1 = head1;
		}
		
		while(offset > 0){
			temp=temp.next;
			offset--;
		}
		
		//==== Pointer advancement on the basis of offset ends
		
		//Step 3
		// Final Step of Running the pointers
		while(temp!=null && temp1!=null){
			if(temp1 == temp)
			   return temp;
			
			temp=temp.next;
			temp1=temp1.next;
		}
		return null;
	}
	
	public static void main(String[] args) {

		Node head= new Node(4);
		head.next= new Node(3);
		head.next.next= new Node(2);
		head.next.next.next= new Node(1);

		Node head1= new Node(18);
		head1.next= new Node(17);
		head1.next.next = head;  //deliberate joining

		Node head2= new Node(14);
		head2.next= new Node(13);
		head2.next.next= new Node(12);
		head2.next.next.next= new Node(11);
		head2.next.next.next.next=head;   //deliberate joining

		//Prints the intersecting Node
		System.out.println(detectIntersection(head1,head2));
	}
}
