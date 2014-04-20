package blog.bst.constuct;

import blog.node.Node;

/**
 * Costruct Binary Tree from the given level order traversal
 * 0's represent null node in between the complete binary tree
 * @author PRATEEK
 */
public class ConstructTreeFromLevelOrder {

	public static final int NULL_NODE = 0;
	public Node constructTree(int[] arr)
	{
		Node root=null;
		if(arr!=null && arr[0]!=NULL_NODE)
			root=constructFromLevelOrder(new Node(arr[0]), arr, 0);
		return root;
	}

	/**
	 * if node is at i, then its left child is at 2*i+1 and right child at 2*i+2  
	 * @param curr: index of the current node
	 * @return: root of the tree
	 */
	private Node constructFromLevelOrder(Node root, int[] arr, int curr) {

		if (root == null) 
			return null;

		int left = 2 * curr + 1; //index of the left child
		int right = 2 * curr + 2; //index of the right child

		Node lnode = null;
		Node rnode = null;

		//left child creation 
		if (left < arr.length && arr[left]!=NULL_NODE) 
			lnode = new Node(arr[left]);
		
		//right child cretion
		if (right < arr.length && arr[right]!=NULL_NODE) 
			rnode = new Node(arr[right]);

		//Connection childs to their parent
			root.left = lnode;
			root.right = rnode;

		constructFromLevelOrder(root.left, arr, left);
		constructFromLevelOrder(root.right, arr, right);

		return root;
	}

	
	public static void main(String[] args) {

		int[] levelorder = { 1, 2, 3, 4, 5, 6, 7, 0, 8, 0, 0, 0, 0, 9,0 };

		ConstructTreeFromLevelOrder obj = new ConstructTreeFromLevelOrder();
		Node root =obj.constructTree(levelorder);
        obj.display(root);
		
	}
	
	public void display(Node root) {
		System.out.println("Inorder Traversal : ");
		inorder(root);
	}

	public void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + "\t");
			inorder(root.right);
		}
	}
}
