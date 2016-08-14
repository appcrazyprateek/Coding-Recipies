package blog.bt.misc;

import blog.node.Node;

/**
 * Inorder Morris Traversal(Threaded Binary Concept used)
 * @author Prateek http://ideone.com/f3lN0T
 */
public class InorderMorrisTraversal {

	public void inorderMorrisTraversal(Node root){
		
		if(root==null)
			return ;
		
		Node current=root;
		while(current!=null){
			
			if(current.left == null)
			{
				System.out.println(current.data); 
				current = current.right;
			}
			else
			{
				Node pre =  current.left;
				while(pre.right != null && pre.right!=current)
					pre = pre.right;
				
				//pre = predessor of current node
				
				if(pre.right==null) //make the link
				{
					pre.right = current ;
					current = current.left;
				}
				else //Break the link
				{
					pre.right = null ;
					System.out.println(current.data);
					current = current.right;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		InorderMorrisTraversal obj = new InorderMorrisTraversal();

		/*Node root = new Node(12);
		
		root.left = new Node(8);
		root.left.left = new Node(6);
		root.left.left.right = new Node(7);
		root.left.right = new Node(10);
		root.left.right.left = new Node(9);

		root.right = new Node(16);
		root.right.left = new Node(14);
		root.right.left.right = new Node(15);
		root.right.right = new Node(20);
		root.right.right.left = new Node(18);
*/
Node root = new Node(1);
		
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(7);
		
		
		root.right = new Node(3);
		root.right.right = new Node(8);
		root.right.right.left = new Node(9);
		
		System.out.println("Inorder Traversal is :");
		obj.inorderMorrisTraversal(root);
	}
}
