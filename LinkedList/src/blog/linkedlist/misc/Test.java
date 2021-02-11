package blog.linkedlist.misc;

import java.util.Collections;
import java.util.HashSet;

public class Test {

	public static void main(String[] args) {
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(3);
		n.next.next.next = new Node(2);
		n.next.next.next.next = new Node(1);
		Test t = new Test();
	
		
		Node rVal = t.isPallindrome(n, n);
		if(rVal == null)
		{
			System.out.println("Not a pallindrome");
		}else 
			System.out.println("LinkedList is a pallindrome");
		
	}
	
	Node isPallindrome(Node node1, Node node2) {

		Collections.sort(new HashSet());
		if (node2 == null)
			return node1;

		Node rVal = isPallindrome(node1, node2.next);
		if (rVal == null)
			return null;

		if (rVal.data == node2.data) {
			return rVal.next != null ? rVal.next : rVal;
		}
		return null;

	}
	
	public void displayList(Node root)
	{

		Node temp=root;
		while(temp!=null)
		{
			System.out.print(temp.data+"-->");
			temp=temp.next;
		}
		System.out.print("null");
		System.out.println();
	}
	
}
