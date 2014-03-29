

class DirectedEdge implements Comparable<DirectedEdge> {

	public static final int P_INFINITY = Integer.MAX_VALUE;
	
	public int src;
	public int dest;
	public int weight;
	
	//Used for Johnson's Algo
	public int jSrc;
	public int jDest;
	

	public DirectedEdge(int src, int dest , int weight) {
		this.src=src;
		this.dest = dest ;
		this.weight = weight ;
	}
	
	public DirectedEdge(int src, int dest ) {
		this.src=src;
		this.dest = dest ;
		this.weight = P_INFINITY ;
	}

	public int to(){
		return dest;
	}

	public int from(){
		return src;
	}

	@Override
	public String toString() {
		return "e: "+src + "-->" + dest + ", w:" + weight ;
	}

	@Override
	public int compareTo(DirectedEdge that) {
		return this.weight - that.weight ;
	}
}
