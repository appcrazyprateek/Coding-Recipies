package blog.bst.constuct;

import blog.node.Node;

public class ConstructTreeFromPreorder {

	private static int index =0 ;
	
	public static void main(String[] args) {
		
		 int pre[] = {10, 5, 1, 7, 40, 50};
		/*Node root=new Node (12) ;
		root.left =new Node(8);
		root.left.left=new Node(6);
		root.left.right=new Node(10);
		
		root.right =new Node(16);
		root.right.left=new Node(14);
		root.right.right=new Node(20);*/
		
		ConstructTreeFromPreorder obj = new ConstructTreeFromPreorder();
		Node root=obj.constructFromPreorder(-99, 999999,pre);
		obj.display(root);
		
		
	}
	
	public Node constructFromPreorder(int min , int max, int[] pre)
	{
		if(index==pre.length)
			return null;
		
		Node root = null;
		
		int val = pre[index];
		if( min < val && val < max)
		{
			root  = new Node(val);
			index = index + 1;
			if(index < pre.length)
			{
				root.left = constructFromPreorder(min , val ,  pre);

				root.right = constructFromPreorder(val , max ,  pre);
			}
			
		}
		return root; 
	}
	
	public void display(Node root) {
		System.out.println("Inorder Traversal");
		inorder(root);
		//postorder(root);
		//preorder(root);
	}
	
	public void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + "\t");
			inorder(root.right);
		}
	}
}
