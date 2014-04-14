package blog.bt.iterativepostorder;

import java.util.Stack;

import blog.node.Node;

/**
 * Iterative Post Order Traversal using two stacks
 * @author PRATEEK
 */
public class IterativePostOrderDoubleStack {

	public static void main(String[] args) {
		Node root = new Node(12);
		root.left = new Node(8);
		root.left.left = new Node(6);
		root.left.right = new Node(10);

		root.right = new Node(16);
		root.right.left = new Node(14);
		root.right.right = new Node(20);

		IterativePostOrderDoubleStack obj = new IterativePostOrderDoubleStack();
		obj.iterativePostOrder(root);
	}
	
	/**
	 * Iterative Pre-order traversal using two stacks 
	 */
	public void iterativePostOrder(Node root)
	{
		 Stack<Node> processed = new Stack<Node>();
		 Stack<Node> current = new Stack<Node>();
		 
		 current.push(root);
		 while(!current.isEmpty())
		 {
			 Node item = current.pop();
			 processed.push(item);
			 
			 if(item.left!=null)
			 current.push(item.left);
			 if(item.right!=null)
			 current.push(item.right);
			 
		 }
		 while(!processed.isEmpty())
		 {
			 System.out.print(processed.pop() + "\t");
		 }
	}
}
