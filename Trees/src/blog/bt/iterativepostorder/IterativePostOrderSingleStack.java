package blog.bt.iterativepostorder;

import java.util.Stack;

import blog.node.Node;

/**
 * Iterative Post-order traversal using Single Stack 
 * @author PRATEEK
 */
public class IterativePostOrderSingleStack {

	/**
	 * Iterative Pre-order traversal using single stacks
	 */
	public void iterativePostOrder(Node root) {
		Stack<Node> stack = new Stack<Node>();
		Node curr = root;
		for (;;) 
		{
			if (curr != null) 
			{
				if (curr.right != null)
					stack.push(curr.right);
				
				stack.push(curr);
				curr = curr.left;
			} 
			else 
			{
				if (!stack.isEmpty())
				{
					curr = stack.pop();
					// odd case, exchange curr and top element
					if (!stack.isEmpty() && curr.right == stack.peek()) 
					{
						stack.pop();
						stack.push(curr);
						curr = curr.right;
					}
					else
					{
						System.out.print(curr+"\t");
						curr=null; //move to right or null
					}

				} else
					break;
			}
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(12);
		root.left = new Node(8);
		root.left.left = new Node(6);
		root.left.right = new Node(10);

		root.right = new Node(16);
		root.right.left = new Node(14);
		root.right.right = new Node(20);

		IterativePostOrderSingleStack obj = new IterativePostOrderSingleStack();
		obj.iterativePostOrder(root);
	}
}
