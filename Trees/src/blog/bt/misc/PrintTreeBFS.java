package blog.bt.misc;

/**
 * BFS of Tree 
 * @author Prateek
 */
public class PrintTreeBFS {

	/**
	 * for printing BFS (recursive) 
	 * @param root
	 */
	public void printTreeBFS(Node root) {
		if(root==null)
			System.out.println("Empty Tree");
		
		int height=height(root);
		
		for(int i=1 ; i<=height ; i++){
			printLevel(root, i);
			System.out.println();
		}
	}
	
	/**
	 * Prints nodes at a given level
	 * @param root
	 * @param level
	 */
	public void printLevel(Node root, int level) {
			if(root==null)
				return ;
			
			if(level==1)
				System.out.print(root.data + "\t");
	
			printLevel(root.left, level-1) ;
			printLevel(root.right, level-1) ;
	}
	
	/**
	 * @param root of the tree
	 * @return height of the tree
	 */
	public int height(Node root) {
		if(root == null)
			return 0;
		
		int lHeight=height(root.left);
		int rHeight=height(root.right);
		
		return max(lHeight,rHeight) + 1;
	}

	/**
	 * @param val1
	 * @param val2
	 * @return maximum val
	 */
	private int max(int val1, int val2) {
		return val1 > val2 ? val1 : val2;
	}
	
	
	public static void main(String[] args) {
		Node root=new Node(52);

		root.left=new Node(30);
		root.right=new Node(76);
		root.left.left=new Node(22);
		root.left.right=new Node(82);
		root.right.left=new Node(54);
		root.right.right=new Node(12);


		PrintTreeBFS obj=new PrintTreeBFS();
		obj.printTreeBFS(root);
		
	}
}
