package blog.api.unionfind;

/**
 * Union-Find Data structure 
 * @author Prateek
 * 
 */
public class UnionFind {
	// Node Holder haveing UFNode
	public UFNode[] nodeHolder;

	// number of node  (Cluster Count)
	private int count;
	private int numVertices;

	public UnionFind(int size) {
		if (size < 0)
			throw new IllegalArgumentException();

		count = size;
		numVertices=size;
		nodeHolder = new UFNode[size];
		for (int i = 0; i < size; i++) {
			nodeHolder[i] = new UFNode(i, 1); // default values, node points to
												// itself and rank is 1
		}
	}

	/**
	 * Finds the parent of a given vertex, using recursion
	 * 
	 * @param vertex
	 * @return
	 */
	public int Find(int vertex) {
		if (vertex < 0 || vertex >= nodeHolder.length)
			throw new IndexOutOfBoundsException();

		if (nodeHolder[vertex].parent != vertex)
			nodeHolder[vertex].parent = Find(nodeHolder[vertex].parent);

		return nodeHolder[vertex].parent;
	}

	/**
	 * @return the cluster count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param v1
	 *            : vertex 1 of some cluster
	 * @param v2
	 *            : vertex 2 of some cluster
	 * @return true if both vertex have same parent
	 */
	public boolean isConnected(int v1, int v2) {
		return Find(v1) == Find(v2);
	}

	/**
	 * unions two cluster of two vertices
	 * @param v1
	 * @param v2
	 */
	public void Union(int v1, int v2) {
		int i = Find(v1);
		int j = Find(v2);

		if (i == j)
			return;

		if (nodeHolder[i].rank < nodeHolder[j].rank) {
			nodeHolder[i].parent = j;
			nodeHolder[j].rank = nodeHolder[j].rank + nodeHolder[i].rank;
		} else {
			nodeHolder[j].parent = i;
			nodeHolder[i].rank = nodeHolder[i].rank + nodeHolder[j].rank;
		}
		count--;
	}
	
	public void printCluster()
	{
		for(int i=0;i<numVertices;i++)
		{
			System.out.print(nodeHolder[i].parent);
			
		}
	}
	
	public int print(int vertex)
	{
		System.out.print(vertex);
		if (nodeHolder[vertex].parent != vertex)
			nodeHolder[vertex].parent = print(nodeHolder[vertex].parent);

		return nodeHolder[vertex].parent;
	}
	
}