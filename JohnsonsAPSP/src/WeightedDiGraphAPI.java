

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
/**
 * 
 * @author Prateek Rathore
 *
 */
class WeightedDiGraphAPI {

	protected int mNumVertices; //number of vertices
	protected int mNumEdges; // number of edges

	public Map<Integer,Boolean> mVisitStatus; //visit status of vertices
	
	public Set<Integer> mVertexList ; //List of all vertices in Graph
	protected Queue<DirectedEdge> mEdgeList; // All edges in the graph
    protected List<DirectedEdge> mMSTedgeList;
	
	public Map<Integer,List<DirectedEdge>> adjList; //Adjacency List holding Edges
    
	public WeightedDiGraphAPI() {
		this.mVisitStatus = new HashMap<Integer,Boolean>();
		this.mVertexList = new TreeSet<Integer>();
		this.mEdgeList = new PriorityQueue<DirectedEdge>();
		this.adjList = new HashMap<Integer,List<DirectedEdge>>();
		this.mMSTedgeList = new ArrayList<DirectedEdge>();
	}
	
	public WeightedDiGraphAPI(int V , int E) {
		this.mNumVertices = V ;
		this.mNumEdges = E ;
		this.mVisitStatus = new HashMap<Integer,Boolean>(V);
		this.mVertexList = new TreeSet<Integer>();
		this.mEdgeList = new PriorityQueue<DirectedEdge>();
		this.adjList = new HashMap<Integer,List<DirectedEdge>>(V);
		this.mMSTedgeList = new ArrayList<DirectedEdge>();
	}
	
	/**
	 * Add Weighted Directed Edge
	 * @param edge
	 */
	public void addEdge(DirectedEdge edge){
		mEdgeList.offer(edge);
		
		int src=edge.from();
		int dest = edge.to();
		
		mVisitStatus.put(src,false);
		mVisitStatus.put(dest,false);
		
		mVertexList.add(src);
		mVertexList.add(dest);
		
		/* Forward Edge */
		List<DirectedEdge> edgeList = adjList.get(src);
		if(edgeList==null)
			edgeList = new ArrayList<DirectedEdge>();
		
		edgeList.add(edge);
		adjList.put(src, edgeList);
	}
	
	public List<DirectedEdge> adj(int vertex){
		return adjList.get(vertex);
	}
}
