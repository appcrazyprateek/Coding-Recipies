package blog.bt.prunepath;

import blog.node.Node;
/**
 * Remove the nodes in the binary tree for that the sum of all values from root to leaf is less than K.
 * @author PRATEEK
 */
public class PruneSumPath {

	
	public static boolean prunePath(Node root, int givenSum , int currSum)
	{
		if(root==null)	{
			if(givenSum==currSum)
				return true;
			else 	
				return false;
		}
		
		boolean leftFlag = prunePath(root.left , givenSum , currSum+root.data);
		
		boolean rightFlag = prunePath(root.right , givenSum , currSum+root.data);
		
		if(!leftFlag)
			root.left=null;
		if(!rightFlag)
			root.right=null;
		
		if(leftFlag || rightFlag )
			return true;
		
		return false;
	}
	
	public static void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + "\t");
			inorder(root.right);
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.left.left = new Node(8);
		root.left.right = new Node(5);
		root.left.right.left = new Node(8);
		root.left.right.left.right = new Node(9);
		root.left.right.left.right.left = new Node(10);

		root.right = new Node(3);
		root.right.left = new Node(6);
		root.right.left.right = new Node(5);
		root.right.right = new Node(7);

		System.out.println("Before");
		PruneSumPath.inorder(root);
		PruneSumPath.prunePath(root, 15, 0);
		System.out.println("\nAfter");
		PruneSumPath.inorder(root);
	}
}
