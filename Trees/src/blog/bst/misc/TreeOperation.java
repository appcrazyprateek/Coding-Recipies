package blog.bst.misc;

import blog.node.Node;

/**
 * BST operations
 * @author Prateek
 */
class TreeOperations {

	public Node startnode;

	// ---------------------------------------- Insert Node in Tree

	// Using recursion
	public void recinsert(Node root, int val) {
		if (val < root.data)	    {
			if (root.left != null)
				recinsert(root.left, val);
			else
				root.left = new Node(val);
		} 
		else if (val > root.data)	    {
			if (root.right != null)
				recinsert(root.right, val);
			else
				root.right = new Node(val);
		}
	}

	public void insert(int val) {
		insert( val, startnode) ;
	}

	// using non-recursion
	public void insert(int val, Node root) {
		Node newNode = new Node(val);

		// if tree is null
		if (root == null){
			root = newNode;
			startnode = newNode; // saving root in static variable
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

			Node successor = current.right;
			while (successor.left != null)
				successor = successor.left;
			
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



	// ---------------------------------------- Display Tree
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

	public void preorder() {
		preorder(startnode);
	}
	public void preorder(Node root) {
		if (root != null) {
			System.out.println(root.data);
			preorder(root.left);
			preorder(root.right);
		}
	}

	public void postorder() {
		postorder(startnode);
	}
	public void postorder(Node root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.println(root.data);
		}
	}


	//--------------------------- GET Predecessor ------------------------
	public Comparable getPredecessor(int val) {
		return getPredecessor(startnode, val );
	}

	/**
	 * @param node of tree
	 * @return Predessor of a given Node
	 */
	public Comparable getPredecessor(Node root,int val) {
		if(root == null)
			return null;

		Node pred = null;
		Node curr = root;
		while (curr!=null && curr.data != val) {
			// Move left
			if (val < curr.data) 
				curr = curr.left;

			// Move Right
			else {
				pred = curr;
				curr = curr.right;
			}
		}

		if(curr.left==null){
			return pred;
		}
		else
		{
			pred = curr.left;
			while (pred.right != null)
				pred = pred.right;
			return pred;
		}

	}


	//--------------------------- GET Successor ------------------------
	public Comparable getSuccessor (int val) {
		return getSuccessor ( startnode , val) ;
	}

	public Comparable getSuccessor (Node root , int val) {
		if(root == null)
			return null;

		Node succ = null;
		Node curr = root;
		while (curr!=null && curr.data != val) {
			// Move Right
			if (val > curr.data) 
				curr = curr.right;

			// Move left
			else {
				succ = curr;
				curr = curr.left;
			}
		}

		if(curr.left==null){
			return succ;
		}
		else
		{
			succ = root.right;
			while (succ.left != null)
				succ = succ.left;
			return succ;
		}
	}

	//-----------------------Get Minimum Value------------------------
	public int minValue(){
		return minValue(startnode);
	}


	/**
	 * Minimum value in the tree
	 * @param root of the tree
	 * @return
	 */
	public int minValue(Node root){
		if(root==null)
			return -1; // or return negative infinity

		Node temp = root;
		while(temp.left !=null)
			temp=temp.left ;

		return temp.data;
	}

	//--------------------------Get Maximum Value-----------------------------
	public int maxValue(){
		return maxValue(startnode);
	}

	/**
	 * Maximum value in the tree
	 * @param root of the tree
	 * @return
	 */
	public int maxValue(Node root){
		if(root==null)
			return -1; // or return negative infinity

		Node temp = root;
		while(temp.right !=null)
			temp=temp.right ;

		return temp.data;
	}


	//--------------------------- Has Path Sum-----------------------
	/**
	 * To find if the tree contains any path equal to given Sum
	 * @param root
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum(Node root, int sum) {
		// return true if repeated differnce has reached to 0
		if (root == null) {
			return(sum == 0);
		}
		else {
			int subSum = sum - root.data;
			return(hasPathSum(root.left, subSum) || hasPathSum(root.right, subSum));
		}
	}

	// ---------------------------- Contains Key ---------------------------------------
	public boolean contains(Comparable item) {
		return contains( item, startnode) ;
	}

	public boolean contains(Comparable item, Node root) {
		Node temp = root;

		while (temp != null) {
			int result = item.compareTo(temp.data);

			if (result == 0)
				return true;

			else if (result > 0)
				temp = temp.right;

			else
				temp = temp.left;
		}

		return false;
	}

	//------------------------------ Recursive Contains Key-----------------------------------------

	public boolean reccontains(Comparable item) {
		return reccontains( item, startnode) ;
	}
	/**
	 * IsContains
	 *
	 * @param item
	 * : Number to be searched
	 * @param root
	 * : Root of the tree
	 * @return true if contained in the tree, else false
	 */
	public boolean reccontains(Comparable item, Node root) {

		if (root == null)
			return false;

		int result = item.compareTo(root.data);

		if (result < 0)
			return reccontains(item, root.left);

		else if (result > 0)
			return reccontains(item, root.right);

		else
			return true;
	}

	// ---------------Recursive Get Operation----------------------
	public Comparable recGet(Comparable item ) {
		return recGet(item , startnode ) ;
	}

	/**
	 * Recursive Get Operations
	 *
	 * @param item
	 * : Node object for which value is being searched
	 * @param root
	 * : root of the tree
	 * @return : -1 if not found or tree is null else return the value of the
	 * Node that was being searched
	 */
	public Comparable recGet(Comparable item, Node root) {
		if (root == null)
			return -1;

		if (item.compareTo(root.data) < 0)
			return recGet(item, root.left); // retrieve from left subtree
		else if (item.compareTo(root.data) > 0)
			return recGet(item, root.right); // retrieve from right subtree
		else
			return root.data;
	}

	//--------------------------height of Tree-------------------------------

	public void height() {
		int h = height(startnode);
		System.out.println("Height of Tree is: " + h);
	}

	/**
	 * Height (recursively)
	 * @param root
	 * @return
	 */
	public int height(Node root) {
		if (root == null)
			return 0;
		else {
			int lHeight = height(root.left);
			int rHeight = height(root.right);

			if (lHeight > rHeight)
				return lHeight + 1;
			else
				return rHeight + 1;

			// return max(height(node.left),height(node.right)) + 1
		}
	}


	// ---------------------- Level Order Traversal -----------------------------
	public void printLevelOrder() {
		int h = height(startnode);
		int i;
		for (i = 1; i <= h; i++) {
			int k = h - i;
			while (k != 0) {
				System.out.print("\t");
				k--;
			}

			printGivenLevel(startnode, i);
			System.out.println();
		}
	}

	// ---- Print all nodes at given level
	public void printGivenLevel(Node root, int level) {

		if (root == null)
			return;

		if (level == 1)
			System.out.print(root.data + "\t");

		printGivenLevel(root.left, level - 1);
		printGivenLevel(root.right, level - 1);
	}

	// --------Common Ancestor --------------
	public Node commonAncestor(Node root, Node n1, Node n2) {

		if (root == null)
			return null;

		if (root == n1 || root == n2) {
			return root;
		}

		Node left = commonAncestor(root.left, n1, n2);
		Node right = commonAncestor(root.right, n1, n2);

		if ((left == n1 && right == n2) || (left == n1 && right == n2))
			return root;

		return (left != null) ? left : right;
	}

	// ------------------------kth Smallest Eleent----------------
	public int KthSmallest( int k){
		countSmallest=0;
		KthSmallest(startnode,k);
		return countSmallest;
	}

	static int countSmallest = 0;
	public void KthSmallest(Node root, int k) {

		if (root == null)
			return;

		KthSmallest(root.left, k);

		if (++countSmallest == k) {
			System.out.println(k + " th smallest element is : " + root.data);
			return;
		}

		KthSmallest(root.right, k);
		return;
	}

	// -------------kth largest element---------------------------

	public int KthLargest( int k){
		countlargest=0;
		KthLargest(startnode,k);
		return countlargest;
	}

	static int countlargest = 0;
	public void KthLargest(Node root, int k) {

		if (root == null)
			return;

		KthLargest(root.right, k);

		if (++countlargest == k) {
			System.out.println(k + " th largest element is : " + root.data);
			return;
		}

		KthLargest(root.left, k);
	}

	// -------------------Size of Tree--------------------------
	public int size() {
		return size(startnode);
	}

	public int size(Node root) {
		if (root == null)
			return 0;
		else
			return (size(root.left) + 1 + size(root.right));
	}


	// ----------------Mirrorring a Tree by creating a copy ----------------------
	public Node mirror() {
		return mirror(startnode) ;
	}

	public Node mirror(Node root) {

		if (root == null)
			return null;

		Node newRoot = new Node(root.data);
		newRoot.left = mirror(root.right);
		newRoot.right = mirror(root.left);

		return newRoot;
	}

	//---------------Check if Binary Search Tree------------------------
	public boolean isBST() {
		return( isBST(startnode, Integer.MIN_VALUE, Integer.MAX_VALUE) );
	}

	public boolean isBST(Node node, int min, int max) {
		if (node==null)
			return true;

		if (node.data < min || node.data > max)
			return false;

		boolean leftStatus = isBST(node.left, min, node.data - 1);

		if (!leftStatus)
			return false;

		boolean rightOk = isBST(node.right, node.data+1, max);

		return rightOk;

		// isBST(node.left, min, node.data - 1) && isBST(node.right, node.data+1, max)
	}


	public static void main(String[] args) {
		TreeOperations obj = new TreeOperations() ;

		Node root=new Node(5);

		obj.insert(15);
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

			obj.display();
		//System.out.println(obj.getPredecessor(15));
		// TRy other operations as well ;)
	}
}