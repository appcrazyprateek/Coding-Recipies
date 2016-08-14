package blog.mst.prims;

import java.util.List;
import java.util.PriorityQueue;

import blog.api.edge.UndirectedEdge;
import blog.api.graph.WeightedUndirectedGraphAPI;

/**
 * Prims Algorithms
 * @author r.prateek
 *
 */
public class Prims extends WeightedUndirectedGraphAPI{

	private PriorityQueue<UndirectedEdge> minEdgePQ;
	public Prims(int V , int E) {
		super(V, E);
	}

	public Prims() {
	}

	public void Prims(int startVertex){
		minEdgePQ = new PriorityQueue<UndirectedEdge>();

		visit(startVertex);

		while(!minEdgePQ.isEmpty()){
			UndirectedEdge edge=minEdgePQ.poll();
			int src=edge.either();
			int dest=edge.other(src);

			if(mVisitStatus.get(src)==true && 
					mVisitStatus.get(dest)==true)
				continue;

			mMSTedgeList.add(edge);

			if(!mVisitStatus.get(src))  {visit(src);}

			if(!mVisitStatus.get(dest)) {visit(dest);}
		}

		printMST();
	}

	/**
	 * Puts all the edges to Priority Queue whose destinations are not visited, 
	 * for the given vertex on the MST
	 */
	public void visit(int vertex){
		mVisitStatus.put(vertex, true);
		List<UndirectedEdge> list= adjList.get(vertex);
		if(list!=null){
			for(UndirectedEdge e: list){
				if(!mVisitStatus.get(e.other(vertex)))
					minEdgePQ.add(e);
			}
		}
	}

	public void printMST(){
		int size=mMSTedgeList.size();
		int mstCost=0;
		for(int i=0;i<size;i++){
			System.out.println(mMSTedgeList.get(i));
			mstCost += mMSTedgeList.get(i).weight;
		}
		System.out.println("MST Cost is :" + mstCost);	
	}

	public static void main(String[] args) {

		WeightedUndirectedGraphAPI graph=new Prims(7, 11);

		/*graph.addEdge(new Edge(0, 1, 2));
		graph.addEdge(new Edge(0, 5, 3));

		graph.addEdge(new Edge(1, 2, 11));
		graph.addEdge(new Edge(1, 6, 12));

		graph.addEdge(new Edge(2, 6, 1));
		graph.addEdge(new Edge(2, 3, 9));

		graph.addEdge(new Edge(3, 6, 4));
		graph.addEdge(new Edge(3, 4, 6));

		graph.addEdge(new Edge(4, 6, 13));
		graph.addEdge(new Edge(4, 5, 5));

		graph.addEdge(new Edge(5, 6, 7));*/

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

		((Prims) graph).Prims(0);
	}
}
