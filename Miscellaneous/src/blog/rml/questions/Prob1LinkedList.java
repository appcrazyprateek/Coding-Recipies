package blog.rml.questions;

class Node{
	public int data;
	public Node next;
	
	public Node(int data){
		this.data = data;
	}
	
	@Override
	public String toString(){
		return this.data+"";
	}
}

/**
 * Men in circular queue, eliminate men in given step size.
 * @author Aditya
 */
public class Prob1LinkedList {

	/**
	 * @param N : number of men
	 * @param M: step size
	 * @return : one of the safest positon, from where it loops back to itself.
	 */
	public int getSafePosition(int N, int M){

		// Creat Circular Linked List
		Node head = new Node(1);
		Node node= head;
		
		for(int i=2; i<= N ; i++)	
			node = (node.next = new Node(i)) ;
		
		node.next = head; //connecting last to first node
		
		
		while(node!=node.next)
		{
			for(int i=1;i<M;i++)     //just of step size 
				node = node.next;
			
			node.next = node.next.next;
		}
		
		System.out.println(node.data);
		return node.data;
	}
	
	public static void main(String[] args) {
		Prob1LinkedList obj = new Prob1LinkedList();
		obj.getSafePosition(14, 3);
	}
}
