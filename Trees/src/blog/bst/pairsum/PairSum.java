package blog.bst.pairsum;

import blog.node.Node;
/**
 * Given a Sum , print the pairs having sum equal to the given Sum
 * @author PRATEEK
 *
 */
public class PairSum {

	/**
	 * Sub-routine which will eventully print the pairs having given sum
	 * @param root
	 * @param sum
	 */
	private static void pairSum(Node root , int sum)
	{
		Node subRoot= getSubTree(root, sum);
		
		//if all Nodes are greater than the given sum
		if(subRoot==null)
			System.out.println("No pair Exists");
		else
			printSum(subRoot, subRoot, sum);
	}
	
	/**
	 * Returns a sub Root which is lesser than sum
	 * @param root
	 * @param sum
	 * @return
	 */
	private static Node getSubTree(Node root, int sum)
	{
		if(root==null)
			return root;

		Node temp=root;
		while(temp.left!=null && temp.data > sum)
			temp=temp.left;
		
		return temp;
	}
	
	/**
	 * Iteating over all nodes in the tree (in-order manner), 
	 * it will print pairs with 1st number as small
	 * @param subHead
	 * @param currRoot
	 * @param sum
	 */
	private static void printSum(Node subHead , Node currRoot, int sum) {
		if(currRoot==null)
			return ;
		
		printSum(subHead, currRoot.left, sum);
		
		//Searches for number if the number is greater than root.data , 
		//This avoids duplication of pairs
		if(sum - currRoot.data > currRoot.data)
		{
			boolean flag = findNum(subHead , sum - currRoot.data );
			if(flag)
				System.out.println(currRoot.data  + " ----->"  + (sum - currRoot.data));
		}
		
		if(sum  > 2 *currRoot.data)
		   printSum(subHead, currRoot.right, sum);
	}

	/**
	 * Searches for the number in the binary Tree
	 * @return true if found else false
	 */
	private static boolean findNum(Node currRoot , int data) {
	
		if(currRoot==null)
			return false;
		if(currRoot.data==data)
			return true;
		else if(currRoot.data > data)
			return	findNum(currRoot.left, data);
		else 
			return findNum(currRoot.right, data);
		
	}

	
	public static void main(String[] args) {
		Node root= new Node(12);
		root.left = new Node(8);
		root.left.left = new Node(6);
		root.left.left.right = new Node(7);
		root.left.left.left = new Node(5);
		
		root.right = new Node(14);
		root.right.left = new Node(13);
		root.right.right = new Node(16);
		root.right.right.left = new Node(15);
		root.right.right.right = new Node(17);
		
		pairSum(root,20);
		
	}
	
}
