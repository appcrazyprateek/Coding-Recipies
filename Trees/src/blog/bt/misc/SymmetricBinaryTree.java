package blog.bt.misc;

import blog.node.Node;

/**
 * Check if Binary Tree is Symmetric
 * @author Prateek
 */
public class SymmetricBinaryTree {
	/**
	 * Sub-routine to check if Binary Tree is Symmetric
	 */
	public boolean isSymmetric(Node left, Node right){
		if ( (left==null && right!=null) || (left!=null && right==null) )
			return false;

		if(left==null && right==null)
			return true;

		return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
	}
	
	public static void main(String[] args) {
		SymmetricBinaryTree obj = new SymmetricBinaryTree();

		Node root = new Node(1);
		
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right = new Node(3);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		boolean isSymmetric = obj.isSymmetric(root.left,root.right);
		System.out.println(isSymmetric);
	}
}
