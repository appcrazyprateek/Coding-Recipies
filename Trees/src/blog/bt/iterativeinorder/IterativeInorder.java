package blog.bt.iterativeinorder;

import java.util.Stack;

import blog.node.Node;

/**
 * Iterative Inorder Traversal Using Stack
 * @author PRATEEK
 *
 */
public class IterativeInorder {

	public static void main(String[] args) {
		Node root = new Node(12);
		root.left = new Node(8);
		root.left.left = new Node(6);
		root.left.right = new Node(10);

		root.right = new Node(16);
		root.right.left = new Node(14);
		root.right.right = new Node(20);

		IterativeInorder obj = new IterativeInorder();
		obj.iterativeInorder(root);
	}

	/**
	 * Iterative Inorder Traversal using Stack
	 * @param node
	 */
	public void iterativeInorder(Node node) 
	{
		Stack<Node> stack = new Stack<Node>();
		for (;;) 
		{
			if (node != null) 
			{
				stack.push(node);
				node = node.left;
			}
			else 
			{
				if (!stack.isEmpty()) 
				{
					node = stack.pop();
					System.out.print(node + "\t");
					node = node.right;
				}
				else
					break;
			}
		}
	}
}
