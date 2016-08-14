package blog.bt.construct;

import java.util.LinkedList;

import blog.node.Node;
/**
 * Construct Tree from Inorder and Post order traversal
 * @author PRATEEK
 *
 */
public class BTfromPostandInorder {

	public static void main(String[] args) {
		 int[] in= {4,2,5,6,1,3,8,7};
		 int[] post= {4,5,6,2,8,7,3,1};
		 
	        Node root=constructTree(in,post);
	        displayTree(root);
	}

	private static void displayTree(Node root) {
		printLevelOrder(root);
		
	}

	public static void printLevelOrder(Node root){
		if(root==null)
			return ;
		
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.addLast(root);
		queue.addLast(null);
		
		while(!queue.isEmpty()){
			Node poped = queue.removeFirst(); //dequeue  

			if (poped == null) {     
				if(queue.isEmpty()) // if last node , terminate
					continue;
				queue.addLast(null);
				System.out.println();
			} 
			else {
				
				System.out.print(poped.data + "\t");   
				
				if (poped.left != null)
				queue.addLast(poped.left);
				if (poped.right != null)
				queue.addLast(poped.right);
			}
		}
	}
	
	private static Node constructTree(int[] in , int[] post) {
		
		return constructTree(in, 0 , in.length-1 , post , 0 , post.length-1);
		
	}
	
	public static Node constructTree(int[] in, int inStart , int inEnd , int[] post , int postStart , int postEnd)
	{
		if(inStart>inEnd || postStart>postEnd)
			return null;
		
		Node root = new Node(post[postEnd]);
		
		int index = find(in,inStart, post[postEnd]);
		
		root.left = constructTree(in,inStart , index-1 , post , postStart , postStart + (index-1 - inStart));
		root.right = constructTree(in, index+1 , inEnd , post , postStart + (index - inStart) , postEnd-1);
		
		return root;
		
	}

	private static int find(int[] in,int start, int num) {
		for(int i=start;i<in.length;i++)
		{
			if(in[i]==num)
			return i;
		}
		return 0;
	}
}
