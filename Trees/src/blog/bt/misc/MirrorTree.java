package blog.bt.misc;

import java.util.LinkedList;

import blog.node.Node;

/**
 * Mirror a Tree
 * @author Prateek
 *
 */
public class MirrorTree {

	/**
	 * Create Mirror of a Tree
	 * @param root of a tree
	 */
	public void mirror(Node root) {
		if(root== null)
			return ;
		
		else
		{
			mirror(root.left);
			mirror(root.right);

			swap(root);
		}
	}

	// Swap Sub-Trees of a Node
	private void swap(Node node) {
		Node temp=node.right;
		node.right=node.left;
		node.left=temp;
	}

	// inorder display subroutine
	public void inorder(Node r) {
		if (r != null) {
			inorder(r.left);
			System.out.println(r.data);
			inorder(r.right);
		}
	}

	public static void Test(Node root)
	{
		Node pre = null;
				if(root !=null)
				{
					Test(root.left);
					root.left = pre;
					pre = root;
					Test(root.right);
				}
	}
	
	public static void main(String[] args) {
		Node root=new Node(12);

		Node n1=new Node(14);
		Node n2=new Node(18);
		Node n3=new Node(10);
		root.left=new Node(8);
		root.right=new Node(16);
		root.left.left=new Node(6);
		root.left.right=n3;
		root.right.left=n1;
		root.right.right=n2;

		MirrorTree m=new MirrorTree();
		printLevelOrder(root);
		m.mirror(root);
		System.out.println("-------");
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
	
	

}
