package blog.api.basic.graphoperation;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Topological Sort Using DFS with few modifications
 * NOte : applicable only for directed acyclic graphs
 * @author Prateek
 *
 */
public class TOPOSort {

	private int numVertices;
	// Map containing nodes and their connected Nodes
	private Map<Integer, List<Integer>> adjList;

	// All nodes and their visit status 
	private Map<Integer, Boolean> vistedStatusList;

	public TOPOSort(int n)	{
		this.numVertices=n;
		adjList=new HashMap<Integer, List<Integer>>(n);
		vistedStatusList=new HashMap<Integer,Boolean>(n);
	}

	/**
	 * Desc: adding edge between vertices
	 * @param src edge starts from here
	 * @param dest edge ends here
	 */
	private void addEdge(int src, int dest) {

		// add node and set visit status as false (unvisited/ unexplored nodes)
		vistedStatusList.put(src, false);
		vistedStatusList.put(dest, false);

		// get the adjacency list of a given node 
		List<Integer> list=adjList.get(src);


		if(list==null) //if adjacency list is empty
			list = new ArrayList<Integer>();

		list.add(dest);
		adjList.put(src,list);
	}

	///======== TOPOLOGICAL SORT ========/////////
	Stack<Integer> sortedVertices = new Stack<Integer>();
	public void topologicalSort()
	{

		Set<Map.Entry<Integer, Boolean>> set=vistedStatusList.entrySet();
		Iterator<Map.Entry<Integer, Boolean>> iterator=set.iterator();
		while(iterator.hasNext())
		{
			Map.Entry<Integer,Boolean> node= iterator.next();
			int key=node.getKey();
			boolean isVisited=vistedStatusList.get(key);
			if(!isVisited)
				topologicalSortUtil(key); // Call DFS for a given node , if unvisited
		}
		print();
	}

	/**
	 * Procedure Similar to DFS, unwinds when deepest node is encountered
	 * @param vertex
	 */
	public void topologicalSortUtil(int vertex)
	{
		vistedStatusList.put(vertex,true);
		List<Integer> list=adjList.get(vertex);

		if(list!=null)
		{
			int size= list.size();
			for(int i=0;i <size; ++i)
			{
				int adjNode=list.get(i);
				boolean isVisited=vistedStatusList.get(adjNode);
				if(!isVisited)
				{
					//System.out.println(adjNode + "\t");
					topologicalSortUtil(adjNode);
				}
			}	
		}
		sortedVertices.push(vertex);
	}

	private void print() {
		while(!sortedVertices.isEmpty()) {
			System.out.println(sortedVertices.pop());
		}
		
	}
	
	public static void main(String[] args) {
		int numVertices = 7;
		TOPOSort g=new TOPOSort(numVertices);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 5);
		g.addEdge(1, 4);
		g.addEdge(5, 2);
		g.addEdge(3, 2);
		g.addEdge(3, 5);
		g.addEdge(3, 4);
		g.addEdge(3, 6);
		g.addEdge(6, 4);
		g.addEdge(6, 1);

		System.out.println("Topoogical Ordering is : ");
		g.topologicalSort();

	}
}
