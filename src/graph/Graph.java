package graph;
import java.util.ArrayList;

public class Graph {

	private ArrayList<ArrayList<Vertex>> adj;
	private int numVerteces;

	public Graph(int numVertices) {

		this.adj = new ArrayList<ArrayList<Vertex>>();

		this.numVerteces = numVertices;

		for (int i = 0; i < this.numVerteces; i++) {
			this.adj.add(new ArrayList<Vertex>());
		}

	}
	
	public ArrayList<Edge> neighborhoodSet(int v) {
		ArrayList<Edge> neighboors = new ArrayList<Edge>();
		if (!this.emptyAdjecyList(v)) {
			int aux = 0;
			Edge edge = this.firstElementAdjList(v);
			neighboors.add(edge);

			while (edge != null) {
				aux++;
				edge = this.nextAdj(v, aux);
				if(edge != null) {
					neighboors.add(edge);
				}
			}
		}
		return neighboors;
	}


	public boolean existsEdge(int v1, int v2) {
		Vertex item = new Vertex(v2, 0);
		return adj.get(v1).contains(item);
	}

	public void addEdge(int v1, int v2, int weight) {
		Vertex item = new Vertex(v2, weight);
		this.adj.get(v1).add(item);
	}

	public boolean emptyAdjecyList(int v) {
		return this.adj.get(v).isEmpty();
	}

	public Edge firstElementAdjList(int v) {
		if(emptyAdjecyList(v)) {
			return null;
		}
		Vertex item = this.adj.get(v).get(0);
		return new Edge(v, item.vertice, item.weight);
	}

	public Edge nextAdj(int v, int it) {
		ArrayList<Vertex> aux = this.adj.get(v);
		if(aux.size() <= it) {
			return null;
		}
		Vertex item = this.adj.get(v).get(it);
		return new Edge(v, item.vertice, item.weight);
	}

	public void removeEdge(int v1, int v2) throws Exception {
		Vertex key = new Vertex(v2, 0);
		this.adj.get(v1).remove(key);
	}

	public int numVertices() {
		return this.numVerteces;
	}
	
	@Override
	public String toString() {
		 String s = "";
		for (int i = 0; i < this.numVerteces; i++) {
			s += "v"+i+": ";
			ArrayList<Edge> neighboors = neighborhoodSet(i);
			int aux = 1;
			for (Edge edge : neighboors) {
				if(edge!=null){
					s+= edge.v2 + "(weight: "+edge.weight+")";
				}
				if(neighboors.size() != aux) {
					s+=", ";
				}
				aux ++;
			}
			
			s+="\n";
		}
		return s;
	}

}