package blog.bt.misc;
import java.util.Stack;

import blog.node.Node;

/**
 * Zig Zag Level Order Traversal ( 2 stacks used)
 * @author Prateek Rathore
 */
public class ZigZagTraversal {

	public void zigzagTraverse(Node root){

		if(root == null)
			return;

		Stack<Node> oddstack = new Stack<Node>();  //holds root as first element
		Stack<Node> evenstack = new Stack<Node>();

		oddstack.add(root);

		while(!oddstack.isEmpty() || !evenstack.isEmpty())
		{
			while(!oddstack.isEmpty())
			{
				Node item=oddstack.pop();
				System.out.print(item.data+"\t");
				
				if(item.left!=null)
					evenstack.push(item.left);
				
				if(item.right!=null)
					evenstack.push(item.right);
			}

			System.out.println();
			while(!evenstack.isEmpty())
			{
				Node item=evenstack.pop();
				System.out.print(item.data+"\t");

				if(item.right!=null)
					oddstack.push(item.right);
				
				if(item.left!=null)
					oddstack.push(item.left);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		ZigZagTraversal obj = new ZigZagTraversal();

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

		System.out.println("Zig Zag Traversal is :");
		obj.zigzagTraverse(root);
	}
}
