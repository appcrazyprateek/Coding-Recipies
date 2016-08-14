package blog.cluster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import blog.api.unionfind.UnionFind;

/**
 * Kruskal's Edge definition
 * @author Prateek
 *
 */
class Edge implements Comparable<Edge>{
	int src;
	int dest;
	int weight;

	public Edge(int src,int dest,int weight)	{
		this.src=src;
		this.dest=dest;
		this.weight=weight;
	}

	@Override
	public String toString()	{
		return "Edge: "+src+ " - " + dest + " | " +"  Weight: "+ weight;
	}

	@Override
	public int compareTo(Edge another) {
		return this.weight - another.weight;
	}
}


/**
 * problem statement: What is the maximum spacing of a K-clustering
 * @author r.prateek
 *
 */
public class KCluster {

	private int mNumVertices;   // Number of vertices in the graph
	private int mNumEdges;		// Number of edges in the graph
	private int maxClusterDistance; // for K cluster
	private UnionFind muf;

	// Input Edge List
	private List<Edge> mEdgeList;		


	public KCluster(int numVertices,int numEdges) {
		this.mNumVertices=numVertices;
		this.mNumEdges=numEdges;

		this.mEdgeList=new ArrayList<Edge>(numEdges);
	}

	public int getMaxSpacing(int clusterCount)
	{

		Collections.sort(mEdgeList);

		UnionFind uf=new UnionFind(mNumVertices);

		if(clusterCount > uf.getCount())		{
			try {
				throw new Exception("Cluster counter is lesser than input");
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		else
		{
			for(int i=0;i<mNumVertices;i++)
			{
				Edge edge=mEdgeList.get(i);

				// if parents do not match, consider edge list for MST and , union the two vertex
				if(!uf.isConnected(edge.src, edge.dest))
				{
					if(uf.getCount()==clusterCount)
					{
						uf.printCluster();
						return maxClusterDistance=edge.weight;
					}
					int v1 = uf.Find(edge.src);  //parent vertex for source
					int v2 = uf.Find(edge.dest); //parent vertex for destinition
					uf.Union(v1, v2);
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		KCluster graph=new KCluster(9, 13);
		graph.helper();

	}

	public void helper()
	{
		mEdgeList.add(new Edge(1 ,2 ,4));
		mEdgeList.add(new Edge(2 ,3 ,8));
		mEdgeList.add(new Edge(3 ,4 ,7));
		mEdgeList.add(new Edge(4 ,5 ,9));
		mEdgeList.add(new Edge(5 ,6 ,10));
		mEdgeList.add(new Edge(6 ,3 ,4));
		mEdgeList.add(new Edge(6,7, 2));
		mEdgeList.add(new Edge(7,8 ,1));
		mEdgeList.add(new Edge(8 ,1, 8));
		mEdgeList.add(new Edge(8 ,2 ,11));
		mEdgeList.add(new Edge(8 ,0 ,7));
		mEdgeList.add(new Edge(0 ,3 ,2));
		mEdgeList.add(new Edge(0, 7 ,6));

		int k=4;
		maxClusterDistance=getMaxSpacing(k);
		if(maxClusterDistance!=-1)
			System.out.println("Maximum Cluster Spacing for "+k + " cluster is "+maxClusterDistance);
		else
			System.out.println("Something went Wrong");
	}
	
}
