package blog.api.edge;

/**
 * Undirected Edge 
 * @author Prateek
 */
public class UndirectedEdge implements Comparable<UndirectedEdge>{

	public static final int P_INFINITY = Integer.MAX_VALUE;
	
	public int src;
	public int dest;
	public int weight;

	public UndirectedEdge(int src, int dest ) {
		this.src=src;
		this.dest = dest ;
		this.weight = P_INFINITY ;
	}
	
	public UndirectedEdge(int src, int dest , int weight) {
		this.src=src;
		this.dest = dest ;
		this.weight = weight ;
	}

	public int either(){
		return src;
	}

	public int other(int src){
		return src == this.src ? this.dest : this.src ;  
	}

	@Override
	public String toString() {
		return src + " <==> " + dest + " = " + weight ;
	}

	@Override
	public int compareTo(UndirectedEdge that) {
		return this.weight - that.weight ;
	}
}
