package blog.bst.misc;

import blog.node.Node;
/**
 * Longest Zig-Zag Path:
 * Find the longest zig-zag path in binary Tree
 * It can be LRLRLRLRL....  or  RLRLRL....
 * @author Prateek Rathore
 */
public class LongestZigZagPath {

	/**
	 * Calculates Longest Zig-Zag Path in Binary Tree
	 * @return max value of longest path
	 */
	public int longestZigZag(Node root,int max){
		
		if(root==null)
			return 0;
		
		int lh=countUtil(root,true,0);
		int rh=countUtil(root,false,0);
	
		max= Math.max(lh, rh);
		max=  Math.max(max,longestZigZag(root.left, max));
		max=  Math.max(max,longestZigZag(root.right,max));
		return max;
	}

	/**
	 * Count Utility to count the steps covered, for a given node
	 * @param node
	 * @param moveLeft : if true , move left , else move right
	 * @param count: current count
	 * @return the count of ZIG-ZAG path traversed
	 */
	public int countUtil(Node node, boolean moveLeft , int count){
		if(node==null)
			return count;
		
		if(moveLeft)
			count=countUtil(node.left,!moveLeft,count+1);
		else
			count=countUtil(node.right,!moveLeft,count+1);
		
		return count;
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
		
		LongestZigZagPath obj= new LongestZigZagPath();
		System.out.println("Longest ZIG-ZAG Path : "+obj.longestZigZag(root,0));
	}
}
