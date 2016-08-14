package blog.mst.krushkal.ver2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
 * Kruskal's MST graph
 * @author Prateek
 *
 */
public class Graph {
	
	private int mNumVertices;   // Number of vertices in the graph
	private int mNumEdges;		// Number of edges in the graph
	
	// Input Edge List
	private List<Edge> mEdgeList;		
	
	// Processed Edge List of Kruskal Algo
	private List<Edge> mResultantEdgeList;

	public Graph(int numVertices,int numEdges) {
		this.mNumVertices=numVertices;
		this.mNumEdges=numEdges;
		
		this.mEdgeList=new ArrayList<Edge>(numEdges);
		this.mResultantEdgeList=new ArrayList<Edge>(mNumVertices-1);
	}
	
	/**
	 * Kruskal's Subroutine to find MST
	 */
	private  void KruskalMST()
	{
		// sort the edge list
		Collections.sort(mEdgeList);
		
		UnionFind uf=new UnionFind(mNumVertices);
		
		// Iterating over the sorted input edgeList
		for(int i=0;i<mNumVertices;i++)
		{
			Edge edge=mEdgeList.get(i);
			int v1 = uf.Find(edge.src);  //parent vertex for source
	        int v2 = uf.Find(edge.dest); //parent vertex for destinition
	        
	        
	        // if parents do not match, consider edge list for MST and , union the two vertex
	        if(v1!=v2)
	        {
	        	mResultantEdgeList.add(edge);
	        	uf.Union(v1, v2);
	        }
		}
		// print the final MST
		printKruskalEdges();
	}
	
	/**
	 * Printing the Kruskal MST edges
	 */
	private void printKruskalEdges()
	{
		for(Edge edge:mResultantEdgeList)
		{
			System.out.println(edge);
		}
	}
	
	public static void main(String[] args) {
		Graph graph=new Graph(7, 11);
		graph.helper();
		
	}
	
	public void helper()
	{
		
		mEdgeList.add(new Edge(0, 1, 2));
		mEdgeList.add(new Edge(0, 5, 3));
		
		mEdgeList.add(new Edge(1, 2, 11));
		mEdgeList.add(new Edge(1, 6, 12));
		
		mEdgeList.add(new Edge(2, 6, 1));
		mEdgeList.add(new Edge(2, 3, 9));
		
		mEdgeList.add(new Edge(3, 6, 4));
		mEdgeList.add(new Edge(3, 4, 6));
		
		mEdgeList.add(new Edge(4, 6, 13));
		mEdgeList.add(new Edge(4, 5, 5));
		
		mEdgeList.add(new Edge(5, 6, 7));
		KruskalMST();
	}
}
