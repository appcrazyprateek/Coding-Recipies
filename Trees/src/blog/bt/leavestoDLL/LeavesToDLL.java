package blog.bt.leavestoDLL;

import blog.bt.dll.BinaryToDLL;
import blog.node.Node;

/**
 * Extract Leaves of the binary tree to DLL
 * and the tree should get rid of those nodes
 * @author PRATEEK
 *
 */
public class LeavesToDLL {

	static Node head=null;
	private static Node extractLeaves(Node root){
		
		if(root==null)
			return null;
		
		if(root.left==null && root.right==null ){
			
			if(head!=null)
			{
				head.left=root;
				root.right=head;
			}
			
			head=root;
			return null;
		}
		
		root.right=extractLeaves(root.right);
		root.left=extractLeaves(root.left);
		
		return root;
		
	}
	
	public static void main(String[] args) {
		 Node root = new Node(1) ;
	        root.left= new Node(2) ;
	        root.right= new Node(3) ;
	        root.left.left= new Node(4) ;
	        root.left.right= new Node(5) ;
	        
	     
	        LeavesToDLL b= new LeavesToDLL();
	        b.extractLeaves(root);
	        
	        System.out.println("List ");
	        printList(head);
	        System.out.println("\nTree");
	        printTree(root);
	}

	private static void printTree(Node root) {
		if(root==null)
			return ;
		
		printList(root.left);
		System.out.println(root.data);
		printList(root.right);
		
	}

	private static void printList(Node head) {
		Node temp = head;
		while(temp!=null)
		{
			System.out.print(temp.data + "-->");
			temp=temp.right;
		}
		
	}
	
	
	
}
