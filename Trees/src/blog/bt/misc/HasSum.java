package blog.bt.misc;

import blog.node.Node;

/** 
 * Detect if a tree has path sum or not
 * @author PRATEEK
 *
 */
public class HasSum {

	private boolean hasSum(Node root, int sum) {
	    if (null != root) 
	    {
	        sum -= root.data;
	        boolean found = hasSum(root.left, sum);

	        if (!found) 
	            found = hasSum(root.right, sum);
	        else 
	           return found;
	    }
	    return 0 == sum ? true : false;
	}
	
	public static void main(String[] args) {
		Node root=new Node (28);
		root.left =new Node(99);
		root.left.left=new Node(11);
		root.left.right=new Node(67);
		root.left.right=new Node(-45);
		
		root.right =new Node(0);
		root.right.right=new Node(-5);
		root.right.left=new Node(10);
		
		
		HasSum d=new HasSum();
		System.out.println(d.hasSum(root,93));
	}
	
}
