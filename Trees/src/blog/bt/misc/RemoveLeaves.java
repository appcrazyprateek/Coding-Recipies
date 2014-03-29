package blog.bt.misc;

import blog.node.Node;

/**
 * Remove Leaf Nodes from a Given Binary Tree
 * @author Prateek
 */
 class RemoveLeaves {
	/**
	 *Remove Leave Nodes 
	 */
	public Node pruneLeaves(Node root){
		if(root.left== null && root.right==null)
			return null;
		else
		{
			if(root.left!=null)
			root.left = pruneLeaves(root.left);
			if(root.right!=null)
			root.right = pruneLeaves(root.right);
		}
		return root;
	}

	/**
	 * Inorder Traversal
	 */
	public void inorder(Node root) {
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
		root.left.right = new Node(5);
		root.left.right.left = new Node(8);
		root.left.right.left.right = new Node(9);
		root.left.right.left.right.left = new Node(10);

		root.right = new Node(3);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		RemoveLeaves obj=new RemoveLeaves();
		System.out.println("Before: ");
		obj.inorder(root);
		obj.pruneLeaves(root);
		System.out.println("\nAfter: ");
		obj.inorder(root);
	}
}


