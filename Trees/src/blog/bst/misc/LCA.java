package blog.bst.misc;

import blog.node.Node;
/**
 * LCA of binary tree
 * @author PRATEEK
 */

public class LCA {
	
	/*
	 * 
	 */
	public static Node lca(Node root , int a , int b){
		if(root==null || root.data == a || root.data==b)
			return root;
		
		Node l = lca(root.left, a, b);
		Node r = lca(root.right, a, b);
		
		if(l!=null && r!=null) 
			return root;
		
		return l!=null ? l : r;
	}

	public static void main(String[] args) {
		Node root = new Node(1) ;

		root.left= new Node(2) ;
		root.right= new Node(3) ;
		
		root.left.left= new Node(4) ;
		root.left.right= new Node(5) ;

		root.right.left= new Node(6) ;
		root.right.right= new Node(7) ;
		
		System.out.println(lca(root,6,8));
	}
}
