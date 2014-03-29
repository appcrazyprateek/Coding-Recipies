package blog.scc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Directed Graph API
 * @author Prateek
 */
public class Graph {

	protected int numVertices;
	protected int numEdges;

	//Map to maintain adjacency List
	protected Map<Integer,List<Integer>> adjList;
	// Map to maintain visit status
	protected Map<Integer, Boolean> vistedStatus;

	/*
	 * Constructor when number of vertices are not known
	 */
	public Graph() {
		this.adjList = new HashMap<Integer,List<Integer>>();
		this.vistedStatus = new HashMap<Integer, Boolean>() ; 
	}

	/*
	 * Constructor when number of vertices are known
	 */
	public Graph(int V) {
		this.numVertices = V;
		this.adjList = new HashMap<Integer,List<Integer>>(V);
		this.vistedStatus = new HashMap<Integer, Boolean>(V) ; 
	}

	/**
	 * Edge in a un-directed graph
	 */
	protected void addEdge(int src, int dest) {
		List<Integer> list=adjList.get(src);			
		if(list==null)
			list=new ArrayList<Integer>();

		list.add(dest);
		adjList.put(src,list);	
		vistedStatus.put(src, false);  //visit status set to false
		vistedStatus.put(dest, false);
	}

	public void dfsUtil(int vertex){
		List <Integer> list = adjList.get(vertex) ;

		vistedStatus.put(vertex, true) ;
		System.out.print(vertex + "\t");
		
		if(list!=null){
			int size = list.size();
			for(int i = 0;i < size ; i++){
				int v=list.get(i);
				if(!vistedStatus.get(v))
					dfsUtil(v);
			}
		}
	}
}
