package blog.bt.treeoperations;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import blog.node.Node;
/**
 * Basic Tree Operations, Applies to BST and BT
 * @author rpratee
 *
 */
public class TreeOperations {

	/**
	 * Number of nodes in a tree
	 * @param node
	 * @return
	 */
	public int size(Node node) {
		if (node == null)
			return 0;
		else
			return size(node.left) + 1 + size(node.right);
	}
	
	/**
	 * Height of the tree
	 * @param node
	 * @return
	 */
	public int height(Node node) {
		if(node == null) 
			return 0;
		else 
			return Math.max(height(node.left), height(node.right)) + 1;
	}
	
	/**
	 * Traversal - Inorder (LNR)
	 * @param root
	 */
	public void inorder(Node root) {
		if(root!=null) {
			inorder(root.left);
			System.out.println(root.data);
			inorder(root.right);
		}
	}
	
	/**
	 * Traversal - Preorder (NLR)
	 * @param root
	 */
	public void preorder(Node root) {
		if(root!=null) {
			System.out.println(root.data);
			inorder(root.left);
			inorder(root.right);
		}
	}
	
	/**
	 * Traversal - postorder (LRN)
	 * @param root
	 */
	public void postorder(Node root) {
		if(root!=null) {
			inorder(root.left);
			inorder(root.right);
			System.out.println(root.data);
		}
	}
	
	/**
	 * Iterative Traversal - Inorder (LNR)
	 * @param root
	 */
	public void inorderIterative(Node root) {
		if(root == null) return;
		
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		Node curr = root;
		while (!stack.isEmpty()) {
			
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			System.out.println(curr.data + "==>");
			curr = curr.right;
		}
	}
	
	/**
	 * Iterative Traversal - PReorder (NLR)
	 * @param root
	 */
	public void iterativePreOrder(Node root) {
		if(root == null) return;
		
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		
		while (!stack.isEmpty()) {
			Node curr = stack.pop();
			
			if(curr.right!=null)
				stack.push(curr.right);
			
			if(curr.left!=null)
				stack.push(curr.left);
		}
	}
	
	/**
	 * Iterative Traversal - Postorder (LRN)
	 * @param root
	 */
	public void iterativePostOrder(Node root) {
		if (root == null)
			return;

		Stack<Node> stack = new Stack<>();
		stack.push(root);
		Node prev = null;

		while (!stack.isEmpty()) {
			Node curr = stack.peek();
			if (prev == null || prev.left == curr || prev.right == curr) {
				if (curr.left != null)
					stack.push(curr.left);
				else if (curr.right != null)
					stack.push(curr.right);
			} else if (prev == curr.left) { //This will happen when we have to move right
				if (curr.right != null)
					stack.push(curr.right);
			} else //When prev and curr are same
				System.out.println(stack.pop());
			
			prev = curr;
		}
	}
	

	/**
	 * Check if Trees are mirror images
	 * @param root1 - root of first tree
	 * @param root2 - root of second tree
	 * @return true if trees are mirror.
	 */
	public boolean checkMirrorTree(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;
		else if (root1 == null || root2 == null)
			return false;

		else if (root1.data != root2.data)
			return false;

		else
			return checkMirrorTree(root1.left, root2.right) && checkMirrorTree(root1.right, root2.left);
	}
	
	/**
	 * Convert to Mirror Tree
	 * @param root
	 * @return
	 */
	public Node convertMirrorTree(Node root) {
		if(root != null) {
			convertMirrorTree(root.left);
			convertMirrorTree(root.right);
			
			//Swap
			Node temp = root.left;
			root.left = root.right;
	        root.right = temp;		
		}
        return root;
	}
	
	/**
	 * Sum all the nodes in a tree
	 * @param root
	 * @return
	 */
	public int sumAll(Node root) {
		if(root == null)
			return 0;
		
		return root.data + sumAll(root.left) + sumAll(root.right);
	}
	
	/**
	 * Check if tree has a path which has the given Sum
	 * @param root
	 * @param sum Given Sum
	 * @return
	 */
	public boolean hasPathSum(Node root, int sum) {
		if(root == null)
			return sum == 0;
		
		return hasPathSum(root.left, sum - root.data) || hasPathSum(root.right, sum - root.data);
	}
	
	/**
	 * Count the leaf nodes
	 * @param root
	 * @return
	 */
	public int countLeaf(Node root) {
		if(root == null)
			return 0;
		
		else if(root.left == null && root.right == null)
			return 1;
		
		else 
			return countLeaf(root.left) + countLeaf(root.right);
	}
	
	/**
	 * Delete the tree
	 * @param root
	 * @return
	 */
	public Node deleteTree(Node root) {
		if(root == null)
			return null;
		
		root.left = deleteTree(root.left);
		root.right = deleteTree(root.right);
	    //delete(root)
		
		return null; // return to previous Node
	}
	
	/**
	 * Check if Two trees are identically same(structurally)
	 * @param root1 : root of first tree
	 * @param root2 : root of second tree
	 * @return true if the trees have same structure
	 */
	public boolean areIdentical(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;

		else if (root1 == null || root2 == null)
			return false;

		return areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right);
	}
	
	/**
	 * Level Order traversal Using Queue
	 * @param root
	 */
	public void levelOrderTraversal(Node root) {
		if (root == null)
			return;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null); // The separator for levels
		while (!queue.isEmpty()) {
			Node curr = queue.poll();
			
			//When null is encounter
			if(curr == null)
			{
				//when no item is present in the queue. exit
				if(queue.isEmpty())
					break;
				
				queue.add(null);
				System.out.println();//print next line beforr printing next number of next level
				continue;
			}
			
			System.out.print(curr + "-->");
			if(curr.left != null) 
				queue.add(curr.left);
			if(curr.right != null) 
				queue.add(curr.right);
		}
	}
	
	
	public void levelWithMaximumSum(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while (!queue.isEmpty()) {
			//TODO : complete code 
		}
	}
	public static void main(String[] args) {
		Node root  = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.left.left = new Node(9);

		root.right = new Node(3);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		root.right.left.left = new Node(8);
		
		
		TreeOperations obj = new TreeOperations();
		
		obj.levelOrderTraversal(root);
		
	}
}
