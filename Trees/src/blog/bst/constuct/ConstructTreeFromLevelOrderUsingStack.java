package blog.bst.constuct;

import java.util.Stack;

import blog.node.Node;


//TODO clarify and then write code ....getting stuck
public class ConstructTreeFromLevelOrderUsingStack {

	public static final int NULL_NODE = 0;

	static class Item {
		Node node;
		int index;

		Item(Node node, int index) {
			this.node = node;
			this.index = index;
		}
		
		@Override
		public String toString() {
			return this.node + ":"+this.index;
		}
	}

	/**
	 * if node is at i, then its left child is at 2*i+1 and right child at 2*i+2
	 * 
	 * @param curr
	 *            : index of the current node
	 * @return: root of the tree
	 */
	private Node constructFromLevelOrder(int[] arr) {

		Node root = new Node(arr[0]);
		if (arr != null & arr[0] != NULL_NODE) {

			Stack<Item> stack = new Stack<Item>();
			Item item = new Item(root, 0);
			stack.push(item);

			Item curr = new Item(new Node(arr[0]), 0);

			for (;;) {

				if (curr != null) {
					
					int index = curr.index;
					int left = 2 * index + 1; // index of the left child
					int right = 2 * index + 2; // index of the right child

					Node lnode = null;
					Node rnode = null;

					// left child creation
					if (left < arr.length && arr[left] != NULL_NODE)
						lnode = new Node(arr[left]);

					// right child cretion
					if (right < arr.length && arr[right] != NULL_NODE)
						rnode = new Node(arr[right]);

					// Connection childs to their parent
					root.left = lnode;
					root.right = rnode;
					
					if(curr.node.right!=null)
					{
						stack.push(new Item(root.right,right));
					}
					stack.push(curr);
					
				}
				
				else
				{
					if (!stack.isEmpty())
					{
						curr = stack.pop();
						
						if(!stack.isEmpty() && curr.node.right == (stack.peek()).node.right )
						
						
						// odd case, exchange curr and top element
						if (!stack.isEmpty() && curr.node.right == (stack.peek()).node.right) 
						{
							stack.pop();
							stack.push(curr);
							Item item1 = new Item(curr.node.right ,2*curr.index + 2);
							curr = item;
						}
						else
						{
							System.out.print(curr+"\t");
							curr=null; //move to right or null
						}

					} else
						break;
				}

				break;
			}
		}
		return root;
	}

	public static void main(String[] args) {

		int[] levelorder = { 1, 2, 3, 4, 5, 6, 7, 0, 8, 0, 0, 0, 0, 9, 0 };

		ConstructTreeFromLevelOrderUsingStack obj = new ConstructTreeFromLevelOrderUsingStack();
		Node root = obj.constructFromLevelOrder(levelorder);
		obj.display(root);

	}

	public void display(Node root) {
		System.out.println("Inorder Traversal : ");
		inorder(root);
	}

	public void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + "\t");
			inorder(root.right);
		}
	}

}
