package blog.linkedlist.misc;

public class Pallindrome {

	
	public static void main(String[] args) {
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(3);
		n.next.next.next = new Node(4);
		n.next.next.next.next = new Node(5);
		
		Pallindrome obj = new Pallindrome();
		Node success = obj.isPallindrome(n, n);
		
		if(success == null) {
			System.out.println("Not a Pallindorme");
		}
		else {
			System.out.println("Pallindrome");
		}
	}	
	
	public Node isPallindrome(Node head, Node node) {
		if (node == null)
			return head;

		Node result = isPallindrome(head, node.next);
		if (result != null)
		{
			if (node.data == result.data) {
					return result.next == null ? head : result.next;
			}
		}
		return null;
	}
}
