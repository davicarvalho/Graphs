package main;
import algorithms.BFS;
import graph.Graph;

public class App {
	
	public static void main(String[] args) throws Exception {
		Graph g = new Graph(6);
		
		g.addEdge(0, 1, 1);
		g.addEdge(0, 2, 1);
		g.addEdge(0, 3, 1);
		
		g.addEdge(1, 4, 1);
		
		g.addEdge(2, 4, 1);
		g.addEdge(2, 5, 1);
		
		g.addEdge(3, 5, 1);
		
		System.out.println(g.toString());
		
		BFS bfs = new BFS(g);
		bfs.search(0);
		bfs.printPath(0, 4);
	}
}
