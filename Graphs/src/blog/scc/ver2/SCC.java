package blog.scc.ver2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
/**
 * Directed Graph API
 * @author Prateek
 */
 class DiGraph {

	protected int numVertices;
	protected int numEdges;

	//Map to maintain adjacency List
	protected Map<Integer,List<Integer>> adjList;
	// Map to maintain visit status
	protected Map<Integer, Boolean> vistedStatus;

	/*
	 * Constructor when number of vertices are not known
	 */
	public DiGraph() {
		this.adjList = new HashMap<Integer,List<Integer>>();
		this.vistedStatus = new HashMap<Integer, Boolean>() ; 
	}

	/*
	 * Constructor when number of vertices are known
	 */
	public DiGraph(int V) {
		this.numVertices = V;
		this.adjList = new HashMap<Integer,List<Integer>>(V);
		this.vistedStatus = new HashMap<Integer, Boolean>(V) ; 
	}

	/**
	 * Edge in a directed graph
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

	/**
	 * DFS run on a given vertex
	 * @param vertex
	 */
	protected void dfsUtil(int vertex){
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
//------------------------------------------------------------------------------------
/**
 * SCC for a direceted Graph
 * @author Prateek
 */
 class SCC extends DiGraph{

	//Stack to hold finishing times i.e reverse post-order of DFS
	private Stack<Integer> stack = new Stack<Integer>();
	
	//Adjacency List to hold transpose Graph
	private Map<Integer,List<Integer>> reverseAdjList;
	
	/**Contructor
	 * If number of vertices is not given
	 */
	public SCC() {
		this.reverseAdjList = new HashMap<Integer,List<Integer>>(numVertices) ; 
	}
	
	/**
	 * Constructor: If number of vertices is given
	 */
	public SCC(int numVertices) {
		super(numVertices);
		this.reverseAdjList = new HashMap<Integer,List<Integer>>(numVertices) ; 
	}


	/*=========Computes SCC Starts===================*/
	/**
	 * Computes SCC, performs Kosaraju's Steps
	 */
	private void computeSCC(SCC g){
		
		//Step1: Reverse Graph
		//Transpose Graph
		transpose(g);
		
		Set<Map.Entry<Integer,Boolean>> set= vistedStatus.entrySet();
		Iterator<Map.Entry<Integer, Boolean>> it= set.iterator();
		
		//Step 2 : Fill Stack
		 //1st DFS on Reversed Graph
		//Calcating Reverse Post order
		while(it.hasNext()){
			Map.Entry<Integer, Boolean> entry=it.next();
			int vertex= entry.getKey();
			boolean isVisited= entry.getValue();
			if(!isVisited){
				fillOrderStackDFS(vertex);
			}
		}
		
		//Reset Visit Status
		resetVisitStatus();
		
		
		System.out.println("SCCs of Digraph: ");
		
		//Step 3: Run DFS using the Stack
		//2nd DFS on Original Graph
		while(!stack.isEmpty()){
		
			int poped=stack.pop();
			if(!vistedStatus.get(poped))
			{
				System.out.println("===========================");
				dfsUtil(poped);
				System.out.println();
			}
			
		}
		System.out.println("===========================");
	}

	/*=============Reversing of Graph Starts================== */
	/**
	 * Transpose given Graph, ie. reverse all the edges
	 * @param g
	 */
	private void transpose(SCC g){

		Set<Map.Entry<Integer, Boolean>> set=vistedStatus.entrySet();	
		Iterator<Map.Entry<Integer, Boolean>> iterator=set.iterator();
		
		while(iterator.hasNext())
		{
			Map.Entry<Integer,Boolean> node= iterator.next();
			int vertex=node.getKey();
			List<Integer> list=adjList.get(vertex);

			if(list!=null)
			{
				int size=list.size();
				for(int i=0;i <size; ++i)
				{
					int adjNode=list.get(i);
					g.addReverseEdge(vertex,adjNode);
				}
			}
		}
	}
	
	/**
	 * Adding reverse edge compared to original graph, 
	 * edge(dest-->src)
	 */
	private void addReverseEdge(int src, int dest) {
		List<Integer> list=reverseAdjList.get(dest);
		
		if(list==null)	
			list=new ArrayList<Integer>();
		
		list.add(src);
		reverseAdjList.put(dest,list);
	}

	/*=============Reversing of Graph Ends================== */
	
	/* ============= Filling The Stack Starts ===============*/
	/**
	 * Fill the stack to form reverse post-order using DFS
	 * @param vertex
	 */
	private void fillOrderStackDFS(int vertex){

		vistedStatus.put(vertex, true);
		List<Integer> list=reverseAdjList.get(vertex);

		if(list!=null){
			int size=list.size();
			
			for(int i=0;i<size;i++){
				int adjNode= list.get(i);
				boolean isVisited = vistedStatus.get(adjNode);
				
				if(!isVisited)
					fillOrderStackDFS(adjNode);
			}
		}
		stack.push(vertex); //Push the vertex when all connecting links processed
	}
	
	/* ============= Filling The Stack Ends ===============*/
	
	/**
	 * Reset Visit Status of all vertices
	 */
	private void resetVisitStatus(){
		for (Map.Entry<Integer, Boolean> entry : vistedStatus.entrySet()) 
		    entry.setValue(false);
	}
	
	public static void main(String[] args) {
		//Test Case1: 
		/*int numVertices = 5;
		SCC g=new SCC(numVertices);
		g.addEdge(1, 0);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(0, 3);
		g.addEdge(3, 4);
		g.computeSCC(g);*/
		
		//Test Case2: 
		int numVertices = 11;
		SCC g=new SCC(numVertices);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		g.addEdge(3, 4);
		g.addEdge(3, 7);
		g.addEdge(7, 4);
		g.addEdge(4, 6);
		g.addEdge(6, 7);
		g.addEdge(4, 5);
		g.addEdge(5, 6);
		g.addEdge(4, 9);
		g.addEdge(5, 8);
		g.addEdge(8, 9);
		g.addEdge(9, 10);
		g.addEdge(10, 8);
		g.addEdge(11, 10);
		g.addEdge(11, 9);
		g.addEdge(2, 11);
		g.computeSCC(g);
		
		
	}
}

