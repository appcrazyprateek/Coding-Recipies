package blog.api.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * BFS in a Undirected Graph, Connected Graph
 * @author Prateek
 */
class UndirectedGraphAPI {

	private int numVertices;
	private int numEdges;
	
	//Map to maintain adjacency List
	private Map<Integer,ArrayList<Integer>> adjList;
	// Map to maintain visit status
	private Map<Integer, Boolean> vistedStatus;

	/*
	 * Constructor when number of vertices are not known
	 */
	public UndirectedGraphAPI() {
		this.adjList = new HashMap<Integer,ArrayList<Integer>>();
		this.vistedStatus = new HashMap<Integer, Boolean>() ; 
	}

	/*
	 * Constructor when number of vertices are known
	 */
	public UndirectedGraphAPI(int V) {
		this.numVertices = V;
		this.adjList = new HashMap<Integer,ArrayList<Integer>>(V);
		this.vistedStatus = new HashMap<Integer, Boolean>(V) ; 
	}

   /**
    * Edge in a un-directed graph
    */
	protected void addEdge(int src, int dest) {

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
		List <Integer> list = adjList.get(vertex) ;

		vistedStatus.put(vertex, true) ;
		System.out.println(vertex + "\t");
		int size = list.size();
		for(int i = 0;i < size ; i++){
			int v=list.get(i);
			if(!vistedStatus.get(v))
				dfsUtil(v);
		}
	}


	//	procedure DFS(Graph,source):
	//	      create a stack S
	//	      push source onto S
	//	      mark source
	//	      while S is not empty:
	//	          pop an item from S into v
	//	          for each edge e incident on v in Graph:
	//	              let w be the other end of e
	//	              if w is not marked:
	//	                 mark w
	//	                 push w onto S


	/**
	 * Procedure for Iterative DFS using Stack
	 */
	public void dfsIterative(int startNode){
		System.out.println("Iterative DFS : ");
		Stack<Integer> stack = new Stack<Integer>();

				stack.push(startNode);
				vistedStatus.put(startNode, true);

				while(!stack.empty()){

					int item=stack.pop();
					
					System.out.println("Poped Item : "+ item);
					
					List<Integer> list = adjList.get(item);
					int size= list.size();

					for(int j=0; j<size ;j++){
						int dest=list.get(j);

						if(!vistedStatus.get(dest)){
							vistedStatus.put(dest, true);
							stack.push(dest);
						}
					}
				}
	}

	

	/////======== BREADTH FIRST SEARCH  ========/////////
	/**
	 * Desc: Breadth First Search: using queue to visit to all nodes in a connected graph  
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
	
	public List<Integer> adj(int vertex){
		return adjList.get(vertex);
	}
	
	public static void main(String[] args) {
		UndirectedGraphAPI g=new UndirectedGraphAPI(4);

		// use for bfs and dfs
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(1, 3);

		//g.bfs(0);
		//g.dfsIterative(0);
		g.dfs();

	}
}
