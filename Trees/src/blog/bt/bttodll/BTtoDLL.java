package blog.bt.bttodll;

import blog.node.Node;

public class BTtoDLL {

	public Node BTtoDLL(Node root)
	{
		return root;
		
	}
	
	public void connectLeft(Node root)
	{
		
	}
	
	public void connectRight(Node root)
	{
		
	}
	
	public static void main(String[] args) {
		  Node root = new Node(1) ;
	        root.left= new Node(2) ;
	        root.right= new Node(3) ;
	        root.left.left= new Node(4) ;
	        root.left.right= new Node(5) ;
	}
}
