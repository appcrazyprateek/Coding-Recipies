package blog.dijktra;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import blog.api.edge.DirectedEdge;
import blog.api.graph.WeightedDiGraphAPI;
import blog.api.misc.Vertex;

/**
 * @author Prateek Rathore
 */
public class Dijkstra extends WeightedDiGraphAPI{

	public static final int P_INFINITY =  99999;
	public Map<Integer,Integer> distTo= new HashMap<Integer,Integer>();
	public Map<Integer,DirectedEdge> edgeTo = new HashMap<Integer,DirectedEdge>();
	public Queue<Vertex> pq ;
	public Dijkstra() {

	}

	public Dijkstra(int V, int E) {
		super(V,E);
	}

	public Map<Integer, DirectedEdge> DijkstraSP(WeightedDiGraphAPI graph, int src){
		for(Integer vertex : graph.mVertexList)
			distTo.put(vertex,P_INFINITY);

		distTo.put(src,0);

		pq = new PriorityQueue<Vertex>();

		pq.offer(new Vertex(src , 0));
		while(!pq.isEmpty()){
			Vertex minVetex = pq.poll();
			//System.out.println(minVetex.vertex);
			List<DirectedEdge> list= adjList.get(minVetex.vertex);

			if(list!=null){
				for(DirectedEdge edge:list)
					relax(edge);
			}
		}

		//printdistTo();
		return edgeTo;
	}

	public void relax(DirectedEdge edge){
		int src=edge.from();
		int dest= edge.to();
		int weight = edge.weight;

		if(distTo.get(dest) > distTo.get(src) + weight){
			distTo.put(dest, distTo.get(src) + weight);
			edgeTo.put(dest, edge);

			Vertex v = new Vertex(dest,distTo.get(src) + weight);
			if(pq.contains(v))
			{   //decrease key
				pq.remove(v);
				pq.offer(v);
			}
			else
			{   // add to heap
				pq.offer(v);
			}
		}
	}

	public void printEdgetTo(){
		Set<Map.Entry<Integer,DirectedEdge>> entries =  edgeTo.entrySet();
		for(Map.Entry<Integer, DirectedEdge> entry:entries)
		{
			System.out.println(entry.getKey() + "      " + entry.getValue());	
		}
	}

	public void printdistTo(){
		Set<Map.Entry<Integer,Integer>> entries =  distTo.entrySet();
		for(Map.Entry<Integer, Integer> entry:entries)
		{
			System.out.println(entry.getKey() + "--->      " + entry.getValue());	
		}
		System.out.println("----------");
	}

	public static void main(String[] args) {
		int V=8;
		int E=15;
		Dijkstra graph = new Dijkstra(V,E);

		graph.addEdge(new DirectedEdge(0, 1, 5));
		graph.addEdge(new DirectedEdge(0, 7, 8));
		graph.addEdge(new DirectedEdge(0, 4, 9));
		graph.addEdge(new DirectedEdge(1, 7, 4));
		graph.addEdge(new DirectedEdge(1, 3, 15));
		graph.addEdge(new DirectedEdge(1, 2, 12));
		graph.addEdge(new DirectedEdge(2, 3, 3));
		graph.addEdge(new DirectedEdge(7, 2, 7));
		graph.addEdge(new DirectedEdge(4, 7, 5));
		graph.addEdge(new DirectedEdge(7, 5, 6));
		graph.addEdge(new DirectedEdge(4, 5, 4));
		graph.addEdge(new DirectedEdge(5, 2, 1));
		graph.addEdge(new DirectedEdge(3, 6, 9));
		graph.addEdge(new DirectedEdge(2, 6, 11));
		graph.addEdge(new DirectedEdge(4, 6, 20));

		graph.DijkstraSP(graph, 0);
	}
}
