package blog.bt.misc;

import blog.node.Node;



public class Diameter {
	
	public int diameter(Node root) {
		
		if(root==null)
			return 0;
		
		int lh=diameter(root.left);
		int rh=diameter(root.right);
		
		root.data = lh+rh ;

		return  1 + max(lh, rh) ;
		
	}
	
	int max(int a , int b) {
		return a > b ? a : b ;
	}
	
	public static void main(String[] args) {
		Node root=new Node (12) ;
		root.left =new Node(8);
		root.left.left=new Node(6);
		root.left.right=new Node(10);
		
		root.right =new Node(16);
		root.right.left=new Node(14);
		root.right.right=new Node(20);
		
		
		Diameter d=new Diameter();
		System.out.println(d.diameter(root));
	}
	
}
