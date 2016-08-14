package blog.bst.misc;

import blog.node.Node;

public class PruneLeaves {

	public void prune(Node root) {
		
		if(root.left!=null)
		if(root.left.left==null)
			root.left=null;
		
		if(root.right!=null)
		if(root.right.right==null)
			root.right=null;
		
		if (root != null) {
			prune(root.left);
			//System.out.print(root.data + "\t");
			prune(root.right);
		}
	}
	public void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + "\t");
			inorder(root.right);
		}
	}
	
	public static void main(String[] args) {
		  Node root = new Node(1) ;
	        root.left= new Node(2) ;
	        root.right= new Node(3) ;
	        root.left.left= new Node(4) ;
	        root.left.right= new Node(5) ;
	        
	        root.right.left= new Node(6) ;
	        root.right.right= new Node(7) ;
	        
	        PruneLeaves obj = new PruneLeaves();
	        obj.prune(root);
	        
	        obj.inorder(root);
	}
}
