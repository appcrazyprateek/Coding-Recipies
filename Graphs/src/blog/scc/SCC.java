package blog.scc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class SCC extends Graph{

	//Stack to hold finishing times i.e reverse post-order of DFS
	private Stack<Integer> stack = new Stack<Integer>();
	
	//Adjacency List to hold transpose Graph
	private Map<Integer,List<Integer>> reverseAdjList;
	
	public SCC(int numVertices) {
		super(numVertices);
		this.reverseAdjList = new HashMap<Integer,List<Integer>>(numVertices) ; 
	}

	public static void main(String[] args) {
		/*SCC g=new SCC(5);
		g.addEdge(1, 0);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(0, 3);
		g.addEdge(3, 4);*/
		
		SCC g=new SCC(10);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		g.addEdge(3, 4);
		g.addEdge(3, 7);
		
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		g.addEdge(3, 4);
		g.addEdge(3, 7);
		
		g.addEdge(7, 4);
		g.addEdge(4, 5);
		g.addEdge(5, 6);
		g.addEdge(4, 6);
		g.addEdge(6, 7);
		
		g.addEdge(4, 9);
		g.addEdge(5, 8);
		
		g.addEdge(9, 10);
		g.addEdge(8, 9);
		g.addEdge(10, 8);
		
		g.addEdge(2, 11);
		g.addEdge(11, 10);
		g.addEdge(11, 9);
		
		
		
		
		g.compute(g);
	}

	/**
	 * Computes SCC, performs Kosaraju's Steps
	 */
	public void compute(SCC g){
		
		//Step1: Reverse Graph
		//Transpose Graph
		transpose(g);
		
		Set<Map.Entry<Integer,Boolean>> set= vistedStatus.entrySet();
		Iterator<Map.Entry<Integer, Boolean>> it= set.iterator();
		
		//Step 2 : Fill Stack
		 //1st DFS
		//Calcating Reverse Post order
		while(it.hasNext()){
			Map.Entry<Integer, Boolean> entry=it.next();
			int vertex= entry.getKey();
			boolean isVisited= entry.getValue();
			if(!isVisited){
				fillOrderStackDFS(vertex);
			}
		}
		
		//transpose(g);
		//Reset Visit Status
		resetVisitStatus();
		
		
		System.out.println("SCCs are: ");
		
		//Step 3: Run DFS using the Stack
		//2nd DFS
		while(!stack.isEmpty()){
			System.out.println("===========");
			int poped=stack.pop();
			if(!vistedStatus.get(poped))
			dfsUtil(stack.pop());
			System.out.println("===========");
		}
	}

	/**
	 * Fill the stack to form reverse post-order using DFS
	 * @param vertex
	 */
	public void fillOrderStackDFS(int vertex){

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
	
	/**
	 * Reset Visit Status of all vertices
	 */
	private void resetVisitStatus(){
		for (Map.Entry<Integer, Boolean> entry : vistedStatus.entrySet()) 
		    entry.setValue(false);
	}
	
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
	public void addReverseEdge(int src, int dest) {
		List<Integer> list=reverseAdjList.get(dest);
		
		if(list==null)	
			list=new ArrayList<Integer>();
		
		list.add(src);
		reverseAdjList.put(dest,list);
	}

}
