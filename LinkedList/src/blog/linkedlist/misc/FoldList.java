package blog.linkedlist.misc;

/**
 * Folding LInked List
 * 
 * @author PRATEEK
 */
public class FoldList {

	public static Node foldList(Node head) {
		return fold(head, head);
	}

	/**
	 * Linked List Folding Sub-routine
	 * @param head: head pointer
	 * @param curr: current pointer
	 * @return: head of the folded list
	 */
	private static Node fold(Node head, Node curr) {
		if (curr == null)
			return head;

		Node result = fold(head, curr.next);

		// condition to stop execution if result is head and curr is not the
		// last node
		if (result != head || curr.next == null) 
		{
			// handling odd and even number of nodes
			if (result != curr && result.next!=curr) 
			{
				curr.next = result.next;
				result.next = curr;
				return curr.next;
			}
			curr.next = null;
		}
		return head;
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
		displayList(root);
		displayList(foldList(root));

	}
}
