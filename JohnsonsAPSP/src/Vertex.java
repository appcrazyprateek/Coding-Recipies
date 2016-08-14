


class Vertex implements Comparable<Vertex> {

	public int vertex ;
	public int dist;

	public Vertex(int vertex, int dist) {
		this.vertex = vertex;
		this.dist = dist;
	}

	@Override
	public int hashCode() {
		return this.vertex;
	}

	@Override
	public boolean equals(Object obj) {
		return this.vertex == ((Vertex)obj).vertex;
	}

	@Override
	public int compareTo(Vertex that) {
		return this.dist - that.dist;
	}

	public String toString(){
		return "v="+this.vertex + " d="+this.dist;
	}
}

