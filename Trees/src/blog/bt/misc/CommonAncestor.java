package blog.bt.misc;

 class Node {
	Node left;
	int data;
	Node right;

	Node(int val) 	{
		this.data=val;
	}
}

public class CommonAncestor {

	//----- Least Common Ancestor in a BST
		public Node LCA(Node root, Node n1, Node n2) {

			if(root==null)
				return root;

			if(root.data > n1.data && root.data > n2.data) 
				return	LCA(root.left, n1, n2);

			if(root.data < n1.data && root.data < n2.data)
				return	LCA(root.right , n1, n2);

			return root;
		}


		public Node commonAncestor(Node root , Node n1 , Node n2) {

			if(root==null)
				return null;

			if(root==n1 || root == n2) {
				return root;
			}

			Node left = commonAncestor(root.left, n1, n2);
			Node right= commonAncestor(root.right, n1, n2);

			if ( (left == n1 && right== n2 ) ||  (left == n1 && right== n2 ) )
				return root;


			return (left != null) ? left : right;
		}
	
	public static void main(String[] args) {
		Node root=new Node(5);
		
	}
}
