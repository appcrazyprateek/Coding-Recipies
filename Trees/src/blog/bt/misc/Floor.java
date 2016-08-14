package blog.bt.misc;

import blog.node.Node;

public class Floor {

	public static void main(String[] args) {
		Node root=new Node(12);
		root.left=new Node(8);
		root.left.left= new Node(6);
		root.left.right=new Node(10);

		root.right=new Node(15);
		root.right.left=new Node(14);
		root.right.right=new Node(17);

		Floor f=new Floor();
		f.floor(root);
	}

	public void floor(Node root) {

		Node returnVal;

		if(root==null)
			return ;


		floor(root.left);
		
		if(root.left == null)
		System.out.println(root.data);
		
		return ;

	}
}
