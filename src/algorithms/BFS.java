package algorithms;

import java.util.ArrayList;
import java.util.List;

import graph.Edge;
import graph.Graph;

public class BFS {

	public static final byte branco = 0;
	public static final byte cinza = 1;
	public static final byte preto = 2;
	private int d[];
//	private int f[];
	private int antecessor[];
	private Graph grafo;

	public BFS(Graph grafo) {
		this.grafo = grafo;
		int n = this.grafo.numVertices();

		this.d = new int[n];
//		this.f = new int[n];
		this.antecessor = new int[n];
	}

	public void buscaEmLargura(Integer s) throws Exception {
		int cor[] = new int[this.grafo.numVertices()];

		for (int u = 0; u < grafo.numVertices(); u++) {
			cor[u] = branco;
			this.d[u] = Integer.MAX_VALUE;
			this.antecessor[u] = -1;
		}
		cor[s] = cinza;
		this.d[s] = 0;
		this.visitaBfs(s, cor);
	}

	private void visitaBfs(Integer u, int cor[]) throws Exception {
		List<Integer> queue = new ArrayList<>();
		queue.add(u);
		while (!queue.isEmpty()) {
			u = queue.remove(0);
			if (!grafo.emptyAdjecyList(u)) {
				int it = 0;
				Edge a = grafo.firstElementAdjList(u);
				while (a != null) {
					Integer v = a.v2;
					if (cor[v] == branco) {
						queue.add(v);
						cor[v] = cinza;
						d[v] = d[u] + 1;
						antecessor[v] = u;
					}
					it++;
					a = grafo.nextAdj(u, it);
				}
			}
			cor[u] = preto;
		}
	}
	
	public void imprimeCaminho(Integer origem, Integer destino) {
		if(origem == destino) {
			System.out.println(origem);
		} else if(antecessor[destino] == -1) {
			System.out.println("Nao existe caminho");
		}else {
			imprimeCaminho(origem, antecessor[destino]);
			System.out.println(destino);
		}
	}

}
