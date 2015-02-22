package blog.bt.AncestorsIterative;

import java.util.Stack;

import blog.node.Node;
//TODO Complete the prog
/**
 * Print Ancestors for given input in a binary tree
 * @author PRATEEK
 *
 */
public class PrintAncestorsIterative {

	public static void printAncestors(Node root, int key)
	{
		Stack<Node> stack = new Stack<>();
		if(root==null)
			return ;
		
		while(true)
		{
			while(root!=null && root.data !=key)
			{
				stack.push(root);
				root = root.left;
			}
			
			if(root!=null && root.data==key)
				break;
			
			if(!stack.isEmpty())
			{
				if(stack.peek().right==null)
				{
					root = stack.pop();

						while(!stack.isEmpty() && stack.peek().right==root)
							root = stack.pop();
				}

			}
			else
				break;
						
			root = stack.isEmpty() ? null : stack.peek().right;
		} 
		
		System.out.println(stack.toString());
	}
	
	public static void main(String[] args) {
		 Node root = new Node(1) ;
	        root.left= new Node(2) ;
	        root.right= new Node(3) ;
	        root.left.left= new Node(4) ;
	        root.left.right= new Node(5) ;
	        
	        printAncestors(root,3);
	        
	}
}
