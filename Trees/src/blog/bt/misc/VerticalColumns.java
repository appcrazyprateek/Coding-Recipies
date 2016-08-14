package blog.bt.misc;

import blog.node.Node;

public class VerticalColumns {

	static int maxVal=0 ;
	static int minVal=0;
			
	public void totalCol(Node root , int col) {
		
		if(root==null)
			return ;
		
		totalCol(root.left , col - 1 );
		totalCol(root.right , col + 1 );
		
		maxVal=min(col, maxVal);
		minVal = max (col , minVal) ;
	}

	private int max(int val1, int val2) {
		return val1 > val2 ? val1 : val2;
	}

	private int min(int val1, int val2) {
		return val1 < val2 ? val1 : val2;
	}
	
	public static void main(String[] args) {
		Node root=new Node(12) ;
		root.left =new Node(6);
		root.left.right=new Node(7);
		root.left.right.left=new Node(7);
		root.left.right.left.left=new Node(7);
		
		VerticalColumns vObj=new VerticalColumns();
		vObj.totalCol(root, 0);
		
		System.out.println("Max: " + maxVal);
		System.out.println("Min: " + minVal);
	}
}
