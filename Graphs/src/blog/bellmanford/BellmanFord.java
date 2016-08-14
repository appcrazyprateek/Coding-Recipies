package blog.bellmanford;
import java.util.ArrayList;
import java.util.List;

import blog.api.edge.DirectedEdge;
import blog.api.graph.WeightedDiGraphAPI;
/**
 * Bellman's Algorithm for Single Source Shortest Path
 * @author Prateek
 */
public class BellmanFord extends WeightedDiGraphAPI{

	private static final int MAX_INF=999999;

	private int mNumVertices;   // Number of vertices in the graph
	private int mNumEdges;		// Number of edges in the graph
	public int[] dist;
	// Input Edge List
//	public List<DirectedEdge> mEdgeList;		
	List<DirectedEdge> edgeList;
	
	public BellmanFord(int numVertices,int numEdges) {
		this.mNumVertices=numVertices;
		this.mNumEdges=numEdges;

	//	this.mEdgeList=new ArrayList<DirectedEdge>(numEdges);
	}

	public BellmanFord(int numVertices,int numEdges, List<DirectedEdge> mEdgeList) {
		this.mNumVertices=numVertices;
		this.mNumEdges=numEdges;
		this.edgeList = mEdgeList;
	}
	
	public  boolean bellmanFord(int src)
	{
		if(edgeList==null)
		edgeList = new ArrayList<DirectedEdge>(mEdgeList);
	
		// maintains the updated distance
		dist=new int[mNumVertices];

		//Initialisation
		for(int i=0;i<mNumVertices ; i++) 
			dist[i] = MAX_INF;
		dist[src]=0;

		for(int i=0;i<= mNumVertices ; i++)
		{
			for(int j=0;j< mNumEdges ; j++) 
			{
				DirectedEdge edge=edgeList.get(j);
				int u=edge.from();
				int v=edge.to();
				int weight=edge.weight;

				// Relaxing the edge
				if(dist[v] > dist[u]+weight)
				{   
					if(dist[u]+weight > 1000 && dist[u]+weight<MAX_INF)
						dist[v] = weight;
					else
						dist[v]=dist[u]+weight;
				}
			}
		}

		//check for negative cycles, by inspecting the distance of all vertices
		// if we find any dist[v] greater distance than dist[u]+ weight, that means 
		// we have already cycled through some edge more than once
		for(int i=0 ;i< mNumEdges ;i++)
		{
			DirectedEdge edge=edgeList.get(i);
			int u=edge.from();
			int v=edge.to();
			int weight=edge.weight;

			if(dist[u]+weight < dist[v])
			{
				System.out.println("Undefined Graph , Shortest path cant be calculated");
				return false;
			}
		}

		//printShortestPath(src , dist);
		return true;
	}

	private void printShortestPath(int src , int[] dist)	{
		for(int i=0;i<mNumVertices ;i++)
			System.out.println(src + " ---> " + i + "    "   +dist[i]);
	}

	public static void main(String[] args) {
		BellmanFord graph=new BellmanFord(5, 6);
		graph.helper();

	}

	public void helper()	{

		mEdgeList.add(new DirectedEdge(0, 1, 2));
		mEdgeList.add(new DirectedEdge(0, 2, 4));

		mEdgeList.add(new DirectedEdge(1, 3, 2));
		mEdgeList.add(new DirectedEdge(1, 2, 1));

		mEdgeList.add(new DirectedEdge(2, 4, 4));

		mEdgeList.add(new DirectedEdge(3, 4, 2));

		int sourceVertex = 0;
		bellmanFord(sourceVertex);
	}
}
