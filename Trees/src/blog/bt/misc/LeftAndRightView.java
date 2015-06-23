package blog.bt.misc;

import java.util.LinkedList;
import java.util.Queue;

import blog.node.Node;

public class LeftAndRightView {

	
	private Queue<Node> queue = new LinkedList<Node>();
	/**
	 * Connect Nodes to their peers on the right at the same level,
	 * Performing BFS on the given tree and connecting peers
	 */
	public void print(Node root) {
		queue.add(root);
		queue.add(null);
		Node poped =null;
		while (!queue.isEmpty()) 
		{
			 poped = queue.poll();
			if (poped == null) 
			{
				if (queue.isEmpty()) // if last node , terminate
					continue;
				queue.add(null);
			} 
			else 
			{
				if(queue.peek()==null)
					System.out.println(poped.data);

				if (poped.left != null)
					queue.add(poped.left);
				if (poped.right != null)
					queue.add(poped.right);
			}
		}
	}
	
	
	public static void main(String[] args) {
		Node root=new Node (1) ;
		root.left =new Node(2);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.left.right.left=new Node(7);
		root.left.right.right=new Node(8);
		root.left.right.right.left=new Node(5);
		
		root.right =new Node(3);
		root.right.right=new Node(7);
		
		LeftAndRightView obj=new LeftAndRightView();
		obj.print(root);
	}
}
