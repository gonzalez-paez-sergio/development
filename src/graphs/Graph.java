package graphs;

import edu.princeton.cs.algs4.In;
import fundamentals.Bag;

public class Graph {

	private static final String NEWLINE = System.getProperty("line.separator");
	private final int V; // number of vertices

	private int E; // number of edges

	private Bag<Integer>[] adj; // adjacency lists

	@SuppressWarnings("unchecked")
	public Graph(int intNumberOfVertices) {
		this.V = intNumberOfVertices;
		this.E = 0;

		adj = (Bag<Integer>[]) new Bag[intNumberOfVertices]; // Create
																// array
																// of
																// lists.

		for (int v = 0; v < intNumberOfVertices; v++) { // Initialize all lists
			adj[v] = new Bag<Integer>(); // to empty.
		}
	}

	public Graph(In in) {
		this(in.readInt()); // Read intNumberOfVertices and construct this
							// graph.
		int intNumberOfEdges = in.readInt(); // Read intNumberOfEdges.
		for (int i = 0; i < intNumberOfEdges; i++) { // Add an edge.
			int v = in.readInt(); // Read a vertex,
			int w = in.readInt(); // read another vertex,
			addEdge(v, w); // and add edge connecting them.
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void addEdge(int v, int w) {
		adj[v].add(w); // Add w to v�s list.
		adj[w].add(v); // Add v to w�s list.
		E++;
	}

	/**
	 * return all the adjacent vortex for the vortex v
	 * 
	 * @param v
	 * @return
	 */
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	public int degree(int v) {
		return adj[v].size();
	}

	/**
	 * Returns a string representation of this graph.
	 *
	 * @return the number of vertices <em>intNumberOfVertices</em>, followed by
	 *         the number of edges <em>intNumberOfEdges</em>, followed by the
	 *         <em>intNumberOfVertices</em> adjacency lists
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(V + " vertices, " + E + " edges " + NEWLINE);
		for (int v = 0; v < V; v++) {
			s.append(v + ": ");
			for (int w : adj[v]) {
				s.append(w + " ");
			}
			s.append(NEWLINE);
		}
		return s.toString();
	}

}