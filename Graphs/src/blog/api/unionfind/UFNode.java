package blog.api.unionfind;
/**
 * Union-Find DS node
 * @author Prateek
 * 
 */
class UFNode {
	int parent; // parent of Vertex at i in the nodeHolder
	int rank; // Number of object present in the tree/ Cluster

	public UFNode(int parent, int rank) {
		this.parent = parent;
		this.rank = rank;
	}
	
	@Override
	public String toString()
	{
		return ""+parent;
	}
}
