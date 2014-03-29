package blog.api.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

import blog.api.edge.UndirectedEdge;


/**
 * Weighted Undirected Graph API
 * @author Prateek
 */
public class WeightedUndirectedGraphAPI {

	protected int mNumVertices; //number of vertices
	protected int mNumEdges; // number of edges

	protected Map<Integer,Boolean> mVisitStatus; //visit status of vertices
	
	protected Set<Integer> mVertexList ; //List of all vertices in Graph
	protected Queue<UndirectedEdge> mEdgeList; // All edges in the graph
    protected List<UndirectedEdge> mMSTedgeList;
	
	protected Map<Integer,List<UndirectedEdge>> adjList; //Adjacency List holding Edges
    
	public WeightedUndirectedGraphAPI() {
		this.mVisitStatus = new HashMap<Integer,Boolean>();
		this.mVertexList = new TreeSet<Integer>();
		this.mEdgeList = new PriorityQueue<UndirectedEdge>();
		this.adjList = new HashMap<Integer,List<UndirectedEdge>>();
		this.mMSTedgeList = new ArrayList<UndirectedEdge>();
	}
	
	public WeightedUndirectedGraphAPI(int V , int E) {
		this.mNumVertices = V ;
		this.mNumEdges = E ;
		this.mVisitStatus = new HashMap<Integer,Boolean>(V);
		this.mVertexList = new TreeSet<Integer>();
		this.mEdgeList = new PriorityQueue<UndirectedEdge>();
		this.adjList = new HashMap<Integer,List<UndirectedEdge>>(V);
		this.mMSTedgeList = new ArrayList<UndirectedEdge>();
	}
	
	/**
	 * Add Weighted Undirect Edge
	 * @param edge
	 */
	public void addEdge(UndirectedEdge edge){
		mEdgeList.offer(edge);
		
		int src=edge.either();
		int dest = edge.other(src);
		
		mVisitStatus.put(src,false);
		mVisitStatus.put(dest,false);
		
		mVertexList.add(src);
		mVertexList.add(dest);
		
		/* Forward Edge */
		List<UndirectedEdge> edgeList = adjList.get(src);
		if(edgeList==null)
			edgeList = new ArrayList<UndirectedEdge>();
		
		edgeList.add(edge);
		adjList.put(src, edgeList);
		
		
		/* Reverse Edge */
		edgeList = adjList.get(dest);
		if(edgeList==null)
			edgeList = new ArrayList<UndirectedEdge>();
		
		edgeList.add(edge);
		adjList.put(dest, edgeList);
	}
	
	public List<UndirectedEdge> adj(int vertex){
		return adjList.get(vertex);
	}
}
