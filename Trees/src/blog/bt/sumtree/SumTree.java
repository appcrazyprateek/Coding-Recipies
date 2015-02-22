package blog.bt.sumtree;

import java.util.LinkedList;

import blog.node.Node;

public class SumTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		sumTree(root);
		printLevelOrder(root);
	}
	
	public static int sumTree(Node root)
	{
		if(root==null)
			return 0;
		root.data = sumTree(root.left) + sumTree(root.right) + root.data ;
		
		return root.data ;
	}
	
	public static void printLevelOrder(Node root){
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
}
