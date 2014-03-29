package blog.bst.misc;


public class KthLargest {

	class Node {
		Node left;
		int data;
		Node right;

		Node(int val) 	{
			this.data=val;
		}
	}
	
	static int count=0;
	/**
	 * 
	 * @param root
	 * @param k
	 */
	public void KthSmallest(Node root ,int k)
	{

		if(root == null) 
			return ;

		KthSmallest(root.left , k) ;

		if(++count == k) {
			System.out.println( k+ " th smallest element is : " + root.data);
			return ;
		}

		KthSmallest(root.right , k);
	}

	/**
	 * 
	 * @param root
	 * @param k
	 */
	public void KthLargest(Node root ,int k)
	{

		if(root == null) 
			return ;

		KthLargest(root.right , k) ;

		if(++count == k) {
			System.out.println( k+ " th largest element is : " + root.data);
			return ;
		}

		KthLargest(root.left , k);
	}

}
