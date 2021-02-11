package blog.mst.prims;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import blog.api.edge.UndirectedEdge;
import blog.api.graph.WeightedUndirectedGraphAPI;
import blog.api.misc.Vertex;

public class EarlyPrim extends WeightedUndirectedGraphAPI {

	public static final int P_INFINITY =  99999;
	public Map<Integer,Integer> distTo = new HashMap<Integer,Integer>();
	public Map<Integer,UndirectedEdge> edgeTo = new HashMap<Integer,UndirectedEdge>();
	public Queue<Vertex> pq ;

	public EarlyPrim(int V , int E) {
		super(V, E);
	}

	public EarlyPrim() {
	}


	public void PrimsMST(WeightedUndirectedGraphAPI graph,int src){
		for(Integer vertex : mVertexList)
			distTo.put(vertex,P_INFINITY);

		distTo.put(src, 0);
		pq = new PriorityQueue<Vertex>();
		pq.offer(new Vertex(src , 0));

		while(!pq.isEmpty()){
			Vertex minVetex = pq.poll();
			//System.out.println(minVetex.vertex);
			List<UndirectedEdge> list= adjList.get(minVetex.vertex);

			if(list!=null){
				for(UndirectedEdge edge:list)
					relax(edge);
			}
		}
		printEdgetTo();
	}


	public void printEdgetTo(){
		Set<Map.Entry<Integer,UndirectedEdge>> entries =  edgeTo.entrySet();
		int sum=0;
		for(Map.Entry<Integer, UndirectedEdge> entry:entries)
		{
			System.out.println(entry.getKey() + "      " + entry.getValue());	
			sum = sum + entry.getValue().weight;
		}
		System.out.println("Sum: "+sum);
	}
	
	public void relax(UndirectedEdge edge){
		int src=edge.either();
		int dest= edge.other(src);
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

		if(distTo.get(src) > distTo.get(dest) + weight){
			distTo.put(src, distTo.get(dest) + weight);
			edgeTo.put(src, edge);

			Vertex v = new Vertex(src,distTo.get(dest) + weight);
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


	public static void main(String[] args) {
		int V=9;
		int E=14;
		EarlyPrim graph = new EarlyPrim(V,E);

		/*graph.addEdge(new Edge(0, 7, 5));
		graph.addEdge(new Edge(0, 7, 8));
		graph.addEdge(new Edge(0, 4, 9));
		graph.addEdge(new Edge(1, 7, 4));
		graph.addEdge(new Edge(1, 3, 15));
		graph.addEdge(new Edge(1, 2, 12));
		graph.addEdge(new Edge(2, 3, 3));
		graph.addEdge(new Edge(7, 2, 7));
		graph.addEdge(new Edge(4, 7, 5));
		graph.addEdge(new Edge(7, 5, 6));
		graph.addEdge(new Edge(4, 5, 4));
		graph.addEdge(new Edge(5, 2, 1));
		graph.addEdge(new Edge(3, 6, 9));
		graph.addEdge(new Edge(2, 6, 11));
		graph.addEdge(new Edge(4, 6, 20));*/

		graph.addEdge(new UndirectedEdge( 0, 1, 4));
		graph.addEdge(new UndirectedEdge( 0, 7, 8));
		graph.addEdge(new UndirectedEdge( 1, 2, 8));
		graph.addEdge(new UndirectedEdge( 1, 7, 11));
		graph.addEdge(new UndirectedEdge( 2, 3, 7));
		graph.addEdge(new UndirectedEdge( 2, 8, 2));
		graph.addEdge(new UndirectedEdge( 2, 5, 4));
		graph.addEdge(new UndirectedEdge(3, 4, 9));
		graph.addEdge(new UndirectedEdge( 3, 5, 14));
		graph.addEdge(new UndirectedEdge(  4, 5, 10));
		graph.addEdge(new UndirectedEdge(  5, 6, 2));
		graph.addEdge(new UndirectedEdge( 6, 7, 1));
		graph.addEdge(new UndirectedEdge( 6, 8, 6));
		graph.addEdge(new UndirectedEdge( 7, 8, 7));

		graph.PrimsMST(graph,0);
	}

}
