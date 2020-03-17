package algorithms;

import graph.Edge;
import graph.Graph;

public class DFS {
	
	public static final byte white = 0;
	public static final byte grey = 1;
	public static final byte black = 2;
	private int d[];
	private int f[];
	private int parents[];
	private Graph graph;

	public DFS(Graph graph) {
		this.graph = graph;
		int n = this.graph.numVertices();

		this.d = new int[n];
		this.f = new int[n];
		this.parents = new int[n];
	}
	
	public void dfsSerarch() {
		Integer time= 0;
		int color[] = new int[graph.numVertices()];
		for(int u=0; u<graph.numVertices(); u++) {
			color[u] = white;
			parents[u] = -1;
		}
		for(int u=0; u<graph.numVertices(); u++) {
			if( color[u] == white) {
				time = dfsVisit(u, time, color);
			}
		}
	}

	private Integer dfsVisit(int u, Integer time, int[] color) {
		color[u] = grey;
		d[u] = ++time;
		if(!graph.emptyAdjecyList(u)) {
			Integer aux = 0;
			Edge e = graph.firstElementAdjList(u);
			while(e !=null) {
				Integer v = e.v2;
				if(color[v] == white) {
					parents[v] = u;
					time = dfsVisit(v, time, color);
				}
				aux ++;
				e = graph.nextAdj(v, aux);
			}
		}
		color[u] = black;
		f[u] = ++ time;
		return time;
	}

}
