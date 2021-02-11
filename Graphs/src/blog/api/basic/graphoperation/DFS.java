package blog.api.basic.graphoperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * BFS in a Undirected Graph, Connected Graph
 * @author Prateek
 */
public class DFS {

	private int numVertices;
	private int numEdges;
	
	//Map to maintain adjacency List
	private Map<Integer,ArrayList<Integer>> adjList;
	// Map to maintain visit status
	private Map<Integer, Boolean> vistedStatus;

	/*
	 * Constructor when number of vertices are not known
	 */
	public DFS() {
		this.adjList = new HashMap<Integer,ArrayList<Integer>>();
		this.vistedStatus = new HashMap<Integer, Boolean>() ; 
	}

	/*
	 * Constructor when number of vertices are known
	 */
	public DFS(int V) {
		this.numVertices = V;
		this.adjList = new HashMap<Integer,ArrayList<Integer>>(V);
		this.vistedStatus = new HashMap<Integer, Boolean>(V) ; 
	}

   /**
    * Edge in a un-directed graph
    */
	private void addEdge(int src, int dest) {

		/*Forward Edge */
		ArrayList<Integer> list=adjList.get(src);			
		if(list==null)
			list=new ArrayList<Integer>();

		list.add(dest);
		adjList.put(src,list);	
		vistedStatus.put(src, false);  //visit status set to false

		/* Reverse Edge */
		list=adjList.get(dest);			
		if(list==null)
			list=new ArrayList<Integer>();

		list.add(src);
		adjList.put(dest,list);	
		vistedStatus.put(dest, false);  //visit status set to false

	}

	/**
	 * Procedure for Recursive DFS
	 */
	public void dfs(){
		
		System.out.println("Recursive DFS :");
		Set<Map.Entry<Integer, Boolean>> entrys = vistedStatus.entrySet();
		
		Iterator<Entry<Integer, Boolean>> it = entrys.iterator();
		
		while(it.hasNext())
		{
			Map.Entry<Integer, Boolean> entry = it.next();
			boolean isVisited=entry.getValue();
			if(!isVisited){
				dfsUtil(entry.getKey());	
			}
		}
	}

	public void dfsUtil(int vertex){
		//Get neighbours 
		List <Integer> list = adjList.get(vertex) ;

		//mark visit status
		vistedStatus.put(vertex, true) ;
		
		System.out.println(vertex + "\t");
		
		for(Integer c : list){
			
			if(!vistedStatus.get(c))
				dfsUtil(c);
		}
	}
	
	public static void main(String[] args) {
		DFS g=new DFS(6);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(1, 3);

		g.dfs();
		//g.dfsUtil(0);

	}
}
