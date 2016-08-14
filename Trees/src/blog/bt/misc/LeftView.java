package blog.bt.misc;

import blog.node.Node;

public class LeftView {

	public static int maxLevel=0;
	public void leftView(Node root, int level )
	{
		if(root==null)
			return;
		
		if(maxLevel < level)		{
			System.out.println(root.data);
			maxLevel = level;
		}
	
		leftView(root.left, level+1 );
		leftView(root.right, level + 1 );
	}
	
	public static void main(String[] args) {
		Node root=new Node (12) ;
		root.left =new Node(8);
		root.left.left=new Node(6);
		root.left.right=new Node(10);
		root.left.right.left=new Node(7);
		root.left.right.right=new Node(8);
		root.left.right.right.left=new Node(5);
		
		root.right =new Node(16);
		root.right.left=new Node(14);
		root.right.right=new Node(20);
		
		/*Node root=new Node (12) ;
		root.left =new Node(10);
		root.right =new Node(30);
		root.right.left =new Node(25);
		root.right.right =new Node(40);*/
		
		
		LeftView obj=new LeftView();
		obj.leftView(root, 1);
	}
}
