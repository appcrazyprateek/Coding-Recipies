package blog.bt.misc;

import blog.node.Node;

/**
 * Mirror a Tree
 * @author Prateek
 *
 */
public class MirrorTree {

	/**
	 * Create Mirror of a Tree
	 * @param root of a tree
	 */
	public void mirror(Node root) {
		if(root== null)
			return ;
		
		else
		{
			mirror(root.left);
			mirror(root.right);

			swap(root);
		}
	}

	// Swap Sub-Trees of a Node
	private void swap(Node node) {
		Node temp=node.right;
		node.right=node.left;
		node.left=temp;
	}

	// inorder display subroutine
	public void inorder(Node r) {
		if (r != null) {
			inorder(r.left);
			System.out.println(r.data);
			inorder(r.right);
		}
	}

	public static void main(String[] args) {
		Node root=new Node(12);

		Node n1=new Node(14);
		Node n2=new Node(18);
		Node n3=new Node(10);
		root.left=new Node(8);
		root.right=new Node(16);
		root.left.left=new Node(6);
		root.left.right=n3;
		root.right.left=n1;
		root.right.right=n2;


		MirrorTree m=new MirrorTree();
		//m.mirror(root);
		
	}

	
	

}
