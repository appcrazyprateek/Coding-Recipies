package blog.apsp.johnson;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import blog.api.edge.DirectedEdge;
import blog.api.graph.WeightedDiGraphAPI;
import blog.bellmanford.BellmanFord;
import blog.dijktra.Dijkstra;

/**
 * Johnson's All pair shortest path algorithm
 * @author Prateek
 */
public class JohnsonAPSP extends WeightedDiGraphAPI{

	public int V;
	public int E;
	int dummyVertex;
	// Input Edge List
	private List<DirectedEdge> edgeList;
	int dist[] ;

	public JohnsonAPSP(int V, int E) {
		this.V = V;
		this.E = E;
	}
	/**
	 * Takes care of running all The steps
	 */
	public void computeAPSP(){

		addDummyEdge();
		dist=runBellmanFord();
		if(dist!=null)
		{
			reWeightEdges(dist);
			runDijkstra();
		}
		else
			System.out.println("Negative Cycle in the graph");
	}

	//Step1
	public void addDummyEdge(){
		Set<Integer> vertices = new HashSet<>(mVertexList);
		dummyVertex= mVertexList.size();
		//System.out.println("Dummy Vertex :"+ dummyVertex);
	
		//Edges from dummy vertex to all other vertices
		for(Integer i:vertices)
			addEdge(new DirectedEdge(dummyVertex,i,0));
	}

	//Step2
	public int[] runBellmanFord(){
		edgeList= new ArrayList<>(mEdgeList);
		BellmanFord bellman = new BellmanFord(V + 1, E + V,edgeList);

		boolean hasNegativeCycle=bellman.bellmanFord(dummyVertex);

		if(hasNegativeCycle==false)
			return null;

		return bellman.dist;
	}

	//Step3
	// clean the edges, due to dummy vertex , and remove dummy vertex
	public void reWeightEdges(int[] dist){

		/* Remove Dummy Vertex starts*/
		Iterator<DirectedEdge> it=edgeList.iterator();
		while(it.hasNext())
		{
			DirectedEdge edge=it.next();
			if(edge.src == dummyVertex)
				it.remove();
		}

		it=mEdgeList.iterator();
		while(it.hasNext())
		{
			DirectedEdge edge=it.next();
			if(edge.src == dummyVertex)
				it.remove();
		}

		adjList.remove(dummyVertex);
		mVertexList.remove(dummyVertex);
		/* Remove Dummy Vertex ends*/

		/* Reweighting of Edges */
		for(DirectedEdge edge:edgeList){
			edge.weight =  dist[edge.src] - dist[edge.dest] + edge.weight ;
			//	System.out.println(edge.src+ " --> " + edge.dest + " "+ edge.weight);
		}
	}

	//Step4
	public void runDijkstra(){

		//Running for every source in the graph
		for(Integer i:mVertexList)
		{
			Dijkstra  dijkstra= new Dijkstra(V,E);
			dijkstra.mVertexList = mVertexList;
			dijkstra.adjList = adjList ;

			Map<Integer, DirectedEdge> singleSourceDistance=dijkstra.DijkstraSP(this, i);
			System.out.println("Source: " + i);
			for(Integer key : singleSourceDistance.keySet()) {
				DirectedEdge edge = singleSourceDistance.get(key);
				System.out.println(edge.src + "-->"+edge.dest +  "  Edge:"+(dist[edge.dest] - dist[edge.src]+edge.weight) );
			}
			System.out.println("================");
		}
	}
	
	
	

	public static void main(String[] args) {
		/*JohnsonAPSP obj = new JohnsonAPSP(4,5);
		obj.addEdge(new DirectedEdge(0, 1,-5));
		obj.addEdge(new DirectedEdge(1, 2, 4));
		obj.addEdge(new DirectedEdge(0, 2, 2));
		obj.addEdge(new DirectedEdge(2, 3, 1));
		obj.addEdge(new DirectedEdge(0, 3, 3));*/

		/*JohnsonAPSP obj = new JohnsonAPSP(5,6);
		obj.addEdge(new DirectedEdge(0, 1, 2));
		obj.addEdge(new DirectedEdge(0, 2, 4));
		obj.addEdge(new DirectedEdge(1, 2, 1));
		obj.addEdge(new DirectedEdge(1, 3, 2));

		obj.addEdge(new DirectedEdge(2, 4, 4));
		obj.addEdge(new DirectedEdge(3, 4, 2));*/
		
		JohnsonAPSP obj = new JohnsonAPSP(6,7);
		obj.addEdge(new DirectedEdge(0, 1, -2));
		obj.addEdge(new DirectedEdge(1, 2, -1));
		obj.addEdge(new DirectedEdge(2, 0,  4));
		obj.addEdge(new DirectedEdge(2, 4, -3));
		
		obj.addEdge(new DirectedEdge(2, 3, 2));
		obj.addEdge(new DirectedEdge(5, 4, -4));
		obj.addEdge(new DirectedEdge(5, 3, 1));

		obj.computeAPSP();
	}
}
