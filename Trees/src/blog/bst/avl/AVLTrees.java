package blog.bst.avl;

public class AVLTrees {

	Node root;
	Node temp;
	Node parent;
	Node child;
	Node newNode;
	
	
	class Node 
	{
		Node left;
		int value;
		Node right;
		int height;
		
		Node(int value)
		{
			this.value=value;
		}
		
	}
	
	public int max(int first, int second)
	{
		return first > second ? first : second; 
	}
	
	
	public int height(Node node)
	{
		return node.height;
	}
	
	public void inorder(Node node)
	{
		if(node!=null)
		{
			inorder(node.left);
			System.out.println(node.value);
			inorder(node.right);
		}
	}
	
	public int getBalance(Node node)
	{
		if(node==null)
			return 0;
		else
			return 	height(node.left) - height(node.right) ;
	}
	

	private int isBalance(Node root)
	{
		if(root==null)
		{
			return 0;
		}
			
		
		int lh = isBalance(root.left);
		int rh = isBalance(root.right);
		
		return Math.max(lh,rh)+1;
	}
	
	public void insert(Node root,int value)
	{
		// Node Insertion
		
		temp = root;
		if (temp == null) {
			newNode = new Node(value);
			temp = newNode;
		} else {
			if (temp.value < value) {
				insert(temp.left, value);
			} else {
				insert(temp.right, value);
			}
		}
		
		temp.height = max(height(temp.left), height(temp.right)) + 1;
		
		int balance = getBalance(temp);
		
		
		
	}
}
