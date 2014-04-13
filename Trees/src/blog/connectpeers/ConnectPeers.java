package blog.connectpeers;

import java.util.LinkedList;
import java.util.Queue;
 
/**
 * Connect Nodes to their peers on the right at the same level
 * Node is modified and additional pointer added
 * @author PRATEEK
 *
 */
public class ConnectPeers {

	private Queue<Node> queue = new LinkedList<Node>();
	/**
	 * Connect Nodes to their peers on the right at the same level,
	 * Performing BFS on the given tree and connecting peers
	 */
	public void connect(Node root) {
		queue.add(root);
		queue.add(null);
		while (!queue.isEmpty()) 
		{
			Node poped = queue.poll();
			if (poped == null) 
			{
				if (queue.isEmpty()) // if last node , terminate
					continue;
				queue.add(null);
			} 
			else 
			{
				poped.peer = queue.peek();

				if (poped.left != null)
					queue.add(poped.left);
				if (poped.right != null)
					queue.add(poped.right);
			}
		}
	}

	public void recConnect(Node root) {
		
		if(root==null || root.left==null || root.right==null)
			return ;
		
		Node temp = root;
		while(temp!=null)
		{
			if(temp.peer==null )
			{
				if(temp.left!=null)
				{
					temp.left.peer = temp.right;
				}
				temp=null;
			}
				
		}
		
		
		
	}	
	
	/**
	 * Print the modified Tree,
	 * We are using left child of every level and then printing its peers
	 */
	private static int maxLevel = 0;
	public void display(Node root, int level) {
		if (root == null)
			return;

		if (maxLevel < level) {
			Node temp = root;
			while (temp != null) {
				System.out.print(temp + "--->  ");
				temp = temp.peer;
			}
			System.out.println();
			maxLevel = level;
		}

		display(root.left, level + 1);
		display(root.right, level + 1);
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.left.right = new Node(8);

		root.right = new Node(3);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.right.left = new Node(9);

		ConnectPeers obj = new ConnectPeers();
		obj.connect(root);
		obj.display(root, 1);

	}
}

class Node {
	int data;
	Node left;
	Node right;
	Node peer;

	Node(int data) {
		this.data = data;
	}

	@Override
	public String toString() {

		return this.data + "";
	}
}
