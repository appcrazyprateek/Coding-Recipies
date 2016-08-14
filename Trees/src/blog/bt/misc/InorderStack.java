package blog.bt.misc;

import java.util.Stack;

import blog.node.Node;

/**
 *Inorder Traversal using Stack 
 * @author Prateek
 */
public class InorderStack {
	public void inorderTravese(Node root) {

		if (root == null)
			return;
		Stack<Node> stack = new Stack<Node>();
		
		Node current= root;
		while (true) {
			if(current!=null)
			{
				stack.push(current);
				current = current.left ;
			}
			else
			{
				if(!stack.isEmpty()){
					Node item = stack.pop() ;
					System.out.print(item + "\t");
					current=item.right;
				}
				else
					break;
			}
		}
	}

	
	public static void main(String[] args) {
		InorderStack obj = new InorderStack();

		Node root = new Node(12);
		root.left = new Node(8);
		root.left.left = new Node(6);
		root.left.left.right = new Node(7);
		root.left.right = new Node(10);
		root.left.right.left = new Node(9);

		root.right = new Node(16);
		root.right.left = new Node(14);
		root.right.left.right = new Node(15);
		root.right.right = new Node(20);
		root.right.right.left = new Node(18);

		System.out.println("Inorder Traversal is :");
		obj.inorderTravese(root);
	}
}
