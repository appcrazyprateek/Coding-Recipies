package blog.bt.misc;

import blog.node.Node;

public class HasSum {

	private boolean pathToSum(Node n, int sum) {
	    if (null != n) {
	        sum -= n.data;
	        boolean found = pathToSum(n.left, sum);

	        if (!found) {
	            found = pathToSum(n.right, sum);
	        }
	        if (found) {
	            System.out.println(n.data);
	                            return found;
	        }
	    }
	    return 0 == sum ? true : false;
	}
	
	public static void main(String[] args) {
		Node root=new Node (28) ;
		root.left =new Node(99);
		root.left.left=new Node(11);
		root.left.right=new Node(67);
		root.left.right=new Node(-45);
		
		root.right =new Node(0);
		root.right.right=new Node(-5);
		root.right.left=new Node(10);
		
		
		HasSum d=new HasSum();
		System.out.println(d.pathToSum(root,93));
	}
	
}
