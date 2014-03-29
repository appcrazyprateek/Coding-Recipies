package blog.bst.misc;

import blog.node.Node;
/**
 * Prints out all root to leaf nodes
 * @author Prateek
 */
public class Root2Leaf {
	private static final int size=10;
	/**
	 * Subroutine to print all paths from root to leaves 
	 * @param list: holds the nodes encountered, values are overriden based on the value of index
	 * @param index
	 */
	private void printRoot2LeafPaths(Node root,Node[] list, int index) {

		if(root==null)
			return  ;

		list[index++]=root;

		if(root.left==null && root.right==null)
		{
			for(int i=0;i<index;i++)
				System.out.print(list[i]+"-->\t");
			System.out.println();
		}
		printRoot2LeafPaths(root.left,list,index);
		printRoot2LeafPaths(root.right,list,index);

		return;
	}

	public static void main(String[] args) {
		/*Node root = new Node(1) ;
		root.left= new Node(2) ;
		root.right= new Node(3) ;
		root.left.left= new Node(4) ;
		root.left.right= new Node(5) ;  	
		root.right.left= new Node(6) ;
		root.right.right= new Node(7) ;  
		root.left.right.left= new Node(8) ;  
		root.left.right.right= new Node(9) ;
		root.left.right.left.right= new Node(10) ;  */

		Node root = new Node(1) ;
		root.left= new Node(2) ;
		root.right= new Node(3) ;
		root.left.left= new Node(4) ;
		root.left.right= new Node(5) ;  	
		root.right.left= new Node(6) ;
		root.right.right= new Node(7) ; 


		root.left.left.right= new Node(8) ;  
		root.left.left.right.left= new Node(9) ;

		Root2Leaf obj= new Root2Leaf();
		Node[] list = new Node[size]; 
		obj.printRoot2LeafPaths(root,list,0);
	}
}
