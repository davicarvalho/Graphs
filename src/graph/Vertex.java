package graph;

public class Vertex {
	int vertice, weight;

	public Vertex(int v, int p) {
		this.vertice = v;
		this.weight = p;
	}

	public boolean equals(Object obj) {
		Vertex item = (Vertex) obj;
		return (this.vertice == item.vertice);
	}
}
