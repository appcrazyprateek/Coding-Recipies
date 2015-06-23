package blog.bst.misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import blog.node.Node;

/**
 * BST operations
 * @author Prateek
 */
class TreeOperations {

	public Node starNode;

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
		insert( val, starNode) ;
	}

	// using non-recursion
	public void insert(int val, Node root) {
		Node newNode = new Node(val);

		// if tree is null
		if (root == null){
			root = newNode;
			starNode = newNode; // saving root in static variable
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
	

	public static Node insert2(Node head, Node parent, int val,
			boolean isLeft) {
		Node root = head;
		if (root == null) {
			root = new Node(val);
			if (parent != null) {
				if (isLeft)
					parent.left = root;

				else
					parent.right = root;
			}
		} else if (root.data > val)
			insert2(root.left, root, val, true);
		else
			insert2(root.right, root, val, false);
		return root;
	}

	public static Node insert1(Node head, int val) {
		if (head == null)
			return new Node(val);

		Node parent = null;
		Node child = head;
		while (child != null) {
			parent = child;
			if (child.data > val) {
				child = child.left;
			} else {
				child = child.right;
			}
		}
		Node temp = new Node(val);
		if (parent.data > val) {
			parent.left = temp;
		} else {
			parent.right = temp;
		}
		return head;
	}

	
	

	// ---------------------------------------- Delete Node in Tree ------------------------------
	public boolean deleteNode(int val) {

		if(starNode==null)
			return false;


		Node current=starNode;
		Node parent=starNode;
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
			if(current==starNode)
				starNode=null;
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

			if(current==starNode)
				starNode=current.right;

			else{
				if(isLeftChild)
					parent.left = current.right;
				else
					parent.right = current.right;
			}
		}

		//Case 2b: No right child
		else if(current.right == null){
			if(current == starNode)
				starNode=current.left;
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

				if(current==starNode)
					starNode=successor;
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

				if(current==starNode)
					starNode=successor;
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

//------------------- Alternative Code to DElete a Node in Tree
	
	public static boolean deleteNode(Node root, Node node) {
		boolean isLeft = false;
		if (root == null)
			return false;

		Node curr = root;
		Node parent = root;

		// Logic to find the node
		while (curr.data != node.data) {
			parent = curr;
			if (node.data > curr.data) {
				isLeft = false;
				curr = curr.right;
			} else {
				isLeft = true;
				curr = curr.right;
			}

			if (curr == null)
				return false;
		}

		// Case 1; No Childs
		if (curr.left == null && curr.right == null) {
			if (isLeft)
				parent.left = null;
			else
				parent.right = null;
		}

		// Case 2a: Left Child Present and Right Child is Null
		else if (curr.left != null && curr.right == null) {
			if (isLeft) {
				parent.left = curr.left;
			} else {
				parent.right = curr.left;
			}
			curr.left = null;
		}
		// Case 2b: Left Child Null and Right Child is Present
		else if (curr.left == null && curr.right != null) {
			if (isLeft) {
				parent.left = curr.right;
			} else {
				parent.right = curr.right;
			}
			curr.right = null;
		} else // 3. Both the Children present
		{
			Node child = curr.right;
			parent = null;

			while (child.left != null) {
				parent = child;
				child = child.left;
			}

			curr.data = child.data;
			if (parent == null) {
				curr.right = child.right;
			} else {
				parent.left = child.right;
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
		display(starNode) ;
	}

	public void display(Node root) {
		System.out.println("Inorder Traversal");
		inorder(root);
		//postorder(root);
		//preorder(root);
	}

	public void inorder() {
		inorder(starNode);
	}
	public void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + "\t");
			inorder(root.right);
		}
	}

	public void preorder() {
		preorder(starNode);
	}
	public void preorder(Node root) {
		if (root != null) {
			System.out.println(root.data);
			preorder(root.left);
			preorder(root.right);
		}
	}

	public void postorder() {
		postorder(starNode);
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
		return getPredecessor(starNode, val );
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
		return getSuccessor ( starNode , val) ;
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
		return minValue(starNode);
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
		return maxValue(starNode);
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
		return contains( item, starNode) ;
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
		return reccontains( item, starNode) ;
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
		return recGet(item , starNode ) ;
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
		int h = height(starNode);
		System.out.println("Height of Tree is: " + h);
	}

	/**
	 * Height (recursively)
	 * @param root
	 * @return
	 */
	public static int height(Node root) {
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

	private static int getHeight2(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		int count = 0;
		queue.offer(root);
		queue.offer(null);
		while (!queue.isEmpty()) {
			Node poppedNode = queue.poll();
			if (poppedNode != null) {
				// System.out.print(poppedNode.data + "\t");
				if (poppedNode.left != null) {
					queue.offer(poppedNode.left);
				}
				if (poppedNode.right != null) {
					queue.offer(poppedNode.right);

				}
			} else {
				count++;
				if (queue.isEmpty())
					break;
				queue.offer(poppedNode);
			}
		}
		return count;
	}
	

	// ---------------------- Level Order Traversal -----------------------------
	public void printLevelOrder() {
		int h = height(starNode);
		int i;
		for (i = 1; i <= h; i++) {
			int k = h - i;
			while (k != 0) {
				System.out.print("\t");
				k--;
			}

			printGivenLevel(starNode, i);
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

	
	public static void printLevelNodes(Node root, int level, int currlevel) {
		if (root == null)
			return;
		if (level == currlevel)
			System.out.print(root.data + "\t");
		printLevelNodes(root.left, level, currlevel + 1);
		printLevelNodes(root.right, level, currlevel + 1);
	}
	

	public static void levelOrder(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		queue.offer(null);
		while (!queue.isEmpty()) {
			Node poppedNode = queue.poll();
			if (poppedNode != null) {
				System.out.print(poppedNode.data + "\t");
				if (poppedNode.left != null) {
					queue.offer(poppedNode.left);
				}
				if (poppedNode.right != null) {
					queue.offer(poppedNode.right);

				}
			} else {
				if (queue.isEmpty())
					break;

				queue.offer(poppedNode);
				System.out.println();
			}
		}
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
		KthSmallest(starNode,k);
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
		KthLargest(starNode,k);
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
		return size(starNode);
	}

	public int size(Node root) {
		if (root == null)
			return 0;
		else
			return (size(root.left) + 1 + size(root.right));
	}
	
	private static int getSize2(Node root) {
		int count = 0;
		if (root != null) {
			Queue<Node> queue = new LinkedList<Node>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				Node poppedNode = queue.poll();
				count++;
				if (poppedNode.left != null)
					queue.offer(poppedNode.left);

				if (poppedNode.right != null)
					queue.offer(poppedNode.right);
			}
		}
		return count;
	}



	// ----------------Mirrorring a Tree by creating a copy ----------------------
	public Node mirror() {
		return mirror(starNode) ;
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
		return( isBST(starNode, Integer.MIN_VALUE, Integer.MAX_VALUE) );
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

	
	// -----------------------Deepest Node-----------------------
	
	
	static int max = -9999;
	static Node temp = null;

	static Node deepesNode(Node root, int curr) {
		if (root == null)
			return temp;

		if (curr > max) {
			max = curr;
			temp = root;
		}
		deepesNode(root.left, curr + 1);
		deepesNode(root.right, curr + 1);
		return temp;
	}
	
	//----------------------------Delete Tree---------------------------------
	public static void deleteTree(Node root) {
		if (root == null)
			return;
		deleteTree(root.left);
		deleteTree(root.right);
		root = null;
	}
		

	//------------Search A node in the Tree ------------------------
	

	private static Node search1(int data, Node root) {
		if (root == null)
			return null;

		if (data < root.data)
			return search1(data, root.left);
		else if (data > root.data)
			return search1(data, root.right);
		else
			return root;
	}

	private static Node search2(int data, Node root) {
		Node curr = root;
		while (curr != null) {
			if (data < curr.data)
				curr = curr.left;
			else if (data > curr.data)
				curr = curr.right;
			else
				break;
		}
		return curr;
	}

	
	//------------------ Count Leaves in a Tree
	
	static int countLeaves(Node root) {
		int count = 0;
		if (root != null) {
			Queue<Node> queue = new LinkedList<Node>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				Node poppedNode = queue.poll();
				if (poppedNode.left == null && poppedNode.right == null) {
					count++;
					continue;
				}
				if (poppedNode.left != null)
					queue.offer(poppedNode.left);

				if (poppedNode.right != null)
					queue.offer(poppedNode.right);
			}
		}
		return count;
	}

	// static int count=0;
	static int countLeaves2(Node root, int count) {
		if (root == null)
			return count;

		if (root.left == null && root.right == null)
			return ++count;

		return countLeaves2(root.left, count) + countLeaves2(root.right, count);
	}

	
	//----------------------- Are Trees Isomorphic 
	
	static boolean isIsomorphic(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;

		if (root1 == null || root2 == null)
			return false;

		return isIsomorphic(root1.left, root2.left)
				&& isIsomorphic(root1.right, root2.right);
	}
	
	//--------------  ROOT to leaf paths 
	

	static void rootToLeafPaths(Node root, String path) {
		if (root == null)
			return;

		if (root.left == null && root.right == null)
			System.out.println(path.toString() + "\t" + root.data);

		rootToLeafPaths(root.left, path + "\t" + root);
		rootToLeafPaths(root.right, path + "\t" + root);
	}

	
	//----------------- Connect Peers in Binary Tree 
	
	public static Node connectPeers(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		queue.offer(null);
		while (!queue.isEmpty()) {
			Node poppedNode = queue.poll();
			if (poppedNode != null) {
				poppedNode.peer = queue.peek();
				if (poppedNode.left != null) {
					queue.offer(poppedNode.left);
				}
				if (poppedNode.right != null) {
					queue.offer(poppedNode.right);
				}
			} else {
				if (queue.isEmpty())
					break;

				queue.offer(poppedNode);
			}
		}
		return root;
	}

	public static void displayPeerConnection(Node root) {
		Node temp = root;
		while (temp != null) {
			System.out.print(temp.data + "--->");
			temp = temp.peer;
		}
		System.out.println("null");

		if (root.left == null && root.right == null)
			return;

		if (root.left != null)
			displayPeerConnection(root.left);
		else
			displayPeerConnection(root.right);
	}
	
	//--------------------Zig Zag Traversal -----------
	
	public static void zigZagTraversal(Node root) {
		int height = height(root);
		boolean reverseOrder = false;
		for (int level = 0; level < height; level++) {
			zigZag1(root, 0, level, reverseOrder);
			System.out.println();
			reverseOrder = !reverseOrder;
		}
	}

	public static void zigZag1(Node root, int currLevel, int level,
			boolean reverseOrder) {
		if (root == null)
			return;

		if (level == currLevel) {
			System.out.print(root.data + "\t");
			return;
		}

		if (!reverseOrder)
			zigZag1(root.left, currLevel + 1, level, reverseOrder);

		zigZag1(root.right, currLevel + 1, level, reverseOrder);

		if (reverseOrder)
			zigZag1(root.left, currLevel + 1, level, reverseOrder);
	}

	public static void zigZagTraversal1(Node root) {
		Stack<Node> evenStack = new Stack<Node>();
		Stack<Node> oddStack = new Stack<Node>();
		evenStack.push(root);
		
		while (!evenStack.isEmpty() || !oddStack.isEmpty()) {
			while (!evenStack.isEmpty()) {
				Node item = evenStack.pop();
				System.out.print(item.data + "\t");
				if (item.left != null)
					oddStack.push(item.left);
				if (item.right != null)
					oddStack.push(item.right);
			}
			System.out.println();
			while (!oddStack.isEmpty()) {
				Node item = oddStack.pop();
				System.out.print(item.data + "\t");
				if (item.right != null)
					evenStack.push(item.right);
				if (item.left != null)
					evenStack.push(item.left);

			}
			System.out.println();
		}

	}
	
	public static boolean hasPathSum(Node root, int sum, String path) {
		if (root == null) {
			if (sum == 0)
				System.out.println(path);
			return sum == 0;
		}
		return hasPathSum(root.left, sum - root.data, path + "-->" + root.data)
				|| hasPathSum(root.right, sum - root.data, path + "-->"
						+ root.data);
	}

	public Node LCA(int n1, int n2, Node root) {
		if (root == null)
			return null;

		if (root.data == n1 || root.data == n2)
			return root;

		Node left = LCA(n1, n2, root.left);
		Node right = LCA(n1, n2, root.right);

		if (left != null && right != null)
			return root;

		return left != null ? left : right;
	}

	public static Node successor(Node root, Node node, Node parent) {
		if (root == null)
			return null;

		if (root.data > node.data) {
			parent = successor(root.left, node, root);
		} else if (root.data < node.data) {
			parent = successor(root.right, node, parent);
		} else {
			if (root.right != null) {
				return nextMinValue(root);
			} else {
				return parent;
			}
		}
		return parent;
	}
	
	public static Node nextMinValue(Node root) {
		root = root.right;
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}
	
	public static void verticalTraversal(Node root, int col,
			Map<Integer, ArrayList<Node>> hash) {
		if (root == null)
			return;
		
		ArrayList<Node> list  = hash.get(col);
		if(list==null)
			list= new ArrayList<Node>();
		
		list.add(root);
		hash.put(col, list);
		
		verticalTraversal(root.left, col-1, hash);
		verticalTraversal(root.right, col+1, hash);
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