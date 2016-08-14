package blog.bt.dll;
import blog.node.Node;

/**
 * Convert Binary Tree to Doubly Linked List
 * @author PRATEEK
 *
 */
public class BinaryToDLL {
	Node head, prev;

	public void BtToDLL(Node root){
		
		if(root==null)
			return ;
		
		BtToDLL(root.left);
		
		if(prev==null)
			head = root;
		else
		{
			root.left=prev;
			prev.right=root;
		}
		prev=root;
		BtToDLL(root.right);
	}

	
	void displayDLL()
	{
		Node tmp = head;
		while(tmp!=null )
		{
			System.out.println(tmp.data);
			tmp = tmp.right;
					
		}
	}
	
	public static void main(String[] args) {
		
		 Node root = new Node(1) ;
	        root.left= new Node(2) ;
	        root.right= new Node(3) ;
	        root.left.left= new Node(4) ;
	        root.left.right= new Node(5) ;
	        
	        BinaryToDLL b= new BinaryToDLL();
	        b.BtToDLL(root);
	        b.displayDLL();
		
	}
	
}
