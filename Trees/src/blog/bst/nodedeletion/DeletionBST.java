package blog.bst.nodedeletion;

/**
 * Node Class of Tree
 * @author Prateek
 *
 */
class Node implements Comparable<Node> {
	public Node left;
	public int data;
	public Node right;

	public Node(int val)
	{
		this.data=val;
	}

	@Override
	public int compareTo(Node that) {
		return this.data - that.data ;
	}

	@Override
	public String toString(){
		return this.data + "";
	}

}

/**
 * BST operations
 * @author Prateek
 */
public class DeletionBST {

	public static Node startnode;

	
	public void insert(int val) {
		insert( val,  startnode) ;
	}

	// using non-recursion
	public void insert(int val, Node root) {
		Node newNode = new Node(val);

		// if tree is null
		if (root == null){
			root = newNode;
			startnode = newNode;   // saving root in static variable
		}

		else {
			Node parent = null;
			Node child = root;

			while (true) {
				parent = child;

				// Move left
				if (newNode.data < child.data) { // Move left
					child = child.left;
					if (child == null) {
						parent.left = newNode;
						return;
					}

					// Move Right
				} else {
					child = child.right;
					if (child == null) {
						parent.right = newNode;
						return;

					}
				}
			}
		}
	}

	// ---------------------------------------- Delete Node in Tree ------------------------------
	public boolean deleteNode(int val) {

		if(startnode==null)
			return false;
		

		Node current=startnode;
		Node parent=startnode;
		boolean isLeftChild=true;

		// Find the node Logic Starts Here
		while(current.data!=val){

			parent=current;

			if(val <current.data){
				isLeftChild=true;
				current = current.left;
			}

			else 
			{
				isLeftChild=false;
				current =current.right;
			}

			if(current==null)
				return false;
		}

		//Node to be deleted found and stored in current

		//Case 1: No childs of current
		if(current.left == null && current.right == null)
		{
			if(current==startnode)
				startnode=null;
			else
			{
				if(isLeftChild)
					parent.left=null;
				else
					parent.right=null;
			}
		}

		// Case 2a: No left child
		else if(current.left == null ){

			if(current==startnode)
				startnode=current.right;

			else{
				if(isLeftChild)
					parent.left = current.right;
				else
					parent.right = current.right;
			}
		}

		//Case 2b: No right child
		else if(current.right == null){
			if(current == startnode)
				startnode=current.left;
			else{
				if(isLeftChild)
					parent.left=current.left;
				else
					parent.right=current.left;
			}
		}

		//Case 3 both children
		else {

			Node successor = (Node) getSuccessor(current);

			//Case 3a: Successor is right child of node to be deleted
			if(current.right==successor)
			{
				successor.left=current.left;
				
				if(current==startnode)
					startnode=successor;
				else
				{

					if(isLeftChild)
						parent.left=successor;
					else
						parent.right=successor;
				}
			}
			// Case 3b: Successor is not the right child of node to be deleted but in the right sub-tree
			else
			{
				Node successorParent=getSuccessorParent(current);
				successorParent.left= successor.right;
				
				if(current==startnode)
					startnode=successor;
				else
				{
					if(isLeftChild)
						parent.left=successor;
					else
						parent.right=successor;
				}
				successor.left=current.left;
				successor.right=current.right;
			}
		}
		return true;
	}

	//--------------------------------Parent of Inorder Successor ------------------------------------------------
	public Node getSuccessorParent(Node node){
		Node temp=node;
		temp=temp.right;

		while(temp.left.left!=null)
			temp=temp.left;

		return temp;
	}

	//--------------------------- GET Successor ------------------------
		public Comparable getSuccessor () {
			return getSuccessor ( startnode) ;
		}

		public Comparable getSuccessor (Node root) {
			if(root == null)
				return null;

			Node temp = root.right;
			while (temp.left != null)
				temp = temp.left;
			return temp;
		}
		
	// ---------------------------------------- Display Tree ----------------------------------
	public void display() {
		display(startnode) ;
	}

	public void display(Node root) {
		System.out.println("Inorder Traversal");
		inorder(root);
		//postorder(root);
		//preorder(root);
	}

	public void inorder() {
		inorder(startnode);
	}
	public void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + "\t");
			inorder(root.right);
		}
	}

	public static void main(String[] args) {
		DeletionBST obj = new DeletionBST() ;

		Node root=new Node(15);
		startnode = root;
		obj.insert(5);
		obj.insert(16);
		obj.insert(3);
		obj.insert(12 );
		obj.insert(20);
		obj.insert(10);
		obj.insert(13);
		obj.insert(18);
		obj.insert(23);
		obj.insert(6);
		obj.insert(7);

		obj.deleteNode(15);
		obj.deleteNode(6);
		obj.display();

		 
	}
}
