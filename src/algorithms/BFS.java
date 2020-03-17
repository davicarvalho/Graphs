package algorithms;

import java.util.ArrayList;
import java.util.List;

import graph.Edge;
import graph.Graph;

public class BFS {

	public static final byte white = 0;
	public static final byte grey = 1;
	public static final byte black = 2;
	private int d[];
//	private int f[];
	private int parents[];
	private Graph graph;

	public BFS(Graph grafo) {
		this.graph = grafo;
		int n = this.graph.numVertices();

		this.d = new int[n];
//		this.f = new int[n];
		this.parents = new int[n];
	}

	public void search(Integer s) throws Exception {
		int cor[] = new int[this.graph.numVertices()];

		for (int u = 0; u < graph.numVertices(); u++) {
			cor[u] = white;
			this.d[u] = Integer.MAX_VALUE;
			this.parents[u] = -1;
		}
		cor[s] = grey;
		this.d[s] = 0;
		this.bfsVisit(s, cor);
	}

	private void bfsVisit(Integer u, int color[]) throws Exception {
		List<Integer> queue = new ArrayList<>();
		queue.add(u);
		while (!queue.isEmpty()) {
			u = queue.remove(0);
			if (!graph.emptyAdjecyList(u)) {
				int it = 0;
				Edge a = graph.firstElementAdjList(u);
				while (a != null) {
					Integer v = a.v2;
					if (color[v] == white) {
						queue.add(v);
						color[v] = grey;
						d[v] = d[u] + 1;
						parents[v] = u;
					}
					it++;
					a = graph.nextAdj(u, it);
				}
			}
			color[u] = black;
		}
	}
	
	public void printPath(Integer origin, Integer destiny) {
		if(origin == destiny) {
			System.out.println(origin);
		} else if(parents[destiny] == -1) {
			System.out.println("There is no path");
		}else {
			printPath(origin, parents[destiny]);
			System.out.println(destiny);
		}
	}

}
