package blog.node;

public class Node implements Comparable<Node> {
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
