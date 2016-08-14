package blog.bt.iterativepreorder;

import java.util.Stack;
import blog.node.Node;
 
/**
 * Iterative Preorder Traversal Using Stack
 * @author PRATEEK
 */
public class IterativePreorder {

	public static void main(String[] args) {

		Node root = new Node(12);
		root.left = new Node(8);
		root.left.left = new Node(6);
		root.left.right = new Node(10);

		root.right = new Node(16);
		root.right.left = new Node(14);
		root.right.right = new Node(20);

		IterativePreorder obj = new IterativePreorder();
		obj.iterativePreorder(root);
		
		
	}
 
	/**
	 * Iterative Preorder Traversal Using Stack
	 * @param root: root of tree
	 */
	public void iterativePreorder(Node root)
	{
		Stack<Node> stack = new Stack<Node>();
		
		if(root!=null)
		stack.push(root);

		while(!stack.isEmpty())
		{
			Node item = stack.pop();
			System.out.print(item + "\t");
			if(item.right!=null)
				stack.push(item.right);
			if(item.left!=null)
				stack.push(item.left);

		}
	}

}
