package blog.bt.misc;

import java.util.LinkedList;

import blog.node.Node;

/**
 * Level order Traversal of Tree (Using Queue)
 * @author Prateek
 */
public class LevelOrder {
	
	public void printLevelOrder(Node root){
		if(root==null)
			return ;
		
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.addLast(root);
		queue.addLast(null);
		
		while(!queue.isEmpty()){
			Node poped = queue.removeFirst(); //dequeue  

			if (poped == null) {     
				if(queue.isEmpty()) // if last node , terminate
					continue;
				queue.addLast(null);
				System.out.println();
			} 
			else {
				
				System.out.print(poped.data + "\t");   
				
				if (poped.left != null)
				queue.addLast(poped.left);
				if (poped.right != null)
				queue.addLast(poped.right);
			}
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(8);
		root.left.right.right = new Node(9);
		root.left.right.left.left = new Node(10);

		root.right = new Node(3);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		LevelOrder obj = new LevelOrder();
		obj.printLevelOrder(root);
	}
}
