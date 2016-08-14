package blog.mst.krushkal;

import blog.api.edge.UndirectedEdge;
import blog.api.graph.WeightedUndirectedGraphAPI;
import blog.api.unionfind.UnionFind;

/**
 * Krushkal MST (Using Greedy Approach)
 * @author Prateek
 */
public class KrushkalMST extends WeightedUndirectedGraphAPI{

	public KrushkalMST(int V , int E) {
		super(V, E);
	}

	public KrushkalMST() {
	}

	public void krushkalMST(){

		mNumVertices = mVertexList.size();
		UnionFind uf= new UnionFind(mNumVertices);

		for(int i=0;i<mNumVertices;i++){
			//Edge edge=mEdgeList.get(i);
			UndirectedEdge edge =	mEdgeList.poll();
			
			int p1=uf.Find(edge.src);	 //parent1 of cluster having src
			int p2=uf.Find(edge.dest);	//parent2 of cluster having dest

			if(p1!=p2){
				mMSTedgeList.add(edge);
				uf.Union(p1, p2);
			}
		}
		
		printMST();
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

		WeightedUndirectedGraphAPI graph=new KrushkalMST(7, 11);

		graph.addEdge(new UndirectedEdge(0, 1, 2));
		graph.addEdge(new UndirectedEdge(0, 5, 3));

		graph.addEdge(new UndirectedEdge(1, 2, 11));
		graph.addEdge(new UndirectedEdge(1, 6, 12));

		graph.addEdge(new UndirectedEdge(2, 6, 1));
		graph.addEdge(new UndirectedEdge(2, 3, 9));

		graph.addEdge(new UndirectedEdge(3, 6, 4));
		graph.addEdge(new UndirectedEdge(3, 4, 6));

		graph.addEdge(new UndirectedEdge(4, 6, 13));
		graph.addEdge(new UndirectedEdge(4, 5, 5));

		graph.addEdge(new UndirectedEdge(5, 6, 7));

		((KrushkalMST) graph).krushkalMST();
	}
}
