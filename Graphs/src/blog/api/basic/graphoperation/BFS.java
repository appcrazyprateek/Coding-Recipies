package blog.api.basic.graphoperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * BFS in a Undirected BFS, Connected BFS
 * @author Prateek
 */
public class BFS {

	private int numVertices;
	private int numEdges;
	
	//Map to maintain adjacency List
	private Map<Integer,ArrayList<Integer>> adjList;
	// Map to maintain visit status
	private Map<Integer, Boolean> vistedStatus;

	/*
	 * Constructor when number of vertices are not known
	 */
	public BFS() {
		this.adjList = new HashMap<Integer,ArrayList<Integer>>();
		this.vistedStatus = new HashMap<Integer, Boolean>() ; 
	}

	/*
	 * Constructor when number of vertices are known
	 */
	public BFS(int V) {
		this.numVertices = V;
		this.adjList = new HashMap<Integer,ArrayList<Integer>>(V);
		this.vistedStatus = new HashMap<Integer, Boolean>(V) ; 
	}

   /**
    * Edge in a un-directed BFS
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

	/////======== BREADTH FIRST SEARCH  ========/////////
	/**
	 * Desc: Breadth First Search: using queue to visit to all nodes in a connected BFS  
	 */
	public void bfs(int startNode)
	{
		Queue<Integer> bfsQueue = new LinkedList<Integer>();

		// stating node visit status set to true
		vistedStatus.put(startNode, true);

		// start node added to Queue
		bfsQueue.add(startNode);

		while(!bfsQueue.isEmpty())
		{
			// Node poped from Queue
			int node=bfsQueue.poll();
			System.out.println("Node poped is : "+node);

			// all connected node list of a give node
			List<Integer> list=adjList.get(node);

			int size=list.size();
			System.out.print("Connected Nodes are : ");
			for(int i=0;i <size; ++i)
			{
				int adjNode=list.get(i);
				System.out.print(adjNode +"   ");
				boolean isVisited=vistedStatus.get(adjNode);
				if(!isVisited)
				{
					vistedStatus.put(adjNode, true);
					bfsQueue.add(adjNode);
				}
			}
			System.out.println("\n===================");
		}
	}
	
	public static void main(String[] args) {
		BFS g=new BFS(6);

		// use for bfs and dfs
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(1, 3);

		g.bfs(0);
	}
}
