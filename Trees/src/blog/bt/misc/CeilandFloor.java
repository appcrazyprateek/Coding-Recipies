package blog.bt.misc;


public class CeilandFloor {

	public Node ceil(Node root , int num) {
		if(root == null)
			return root;

		Node right = root;
		if(root.data < num ){
			right=ceil(root.right, num);
			return right;
		}

		Node left = root;
		if(root.data < num ){
			left=ceil(root.left, num);
			return left;
		}

		if(root.data == num)
			return root;

		if(num < right.data  && num > left.data )
			return root;

			return root;

	}

	public Node floor(Node root , int num) {
		return root;

	}
}
