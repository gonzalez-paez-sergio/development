package graphs;

import fundamentals.Bag;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Graph {
	
	private static final String NEWLINE = System.getProperty("line.separator");
	private final int V; // number of vertices
	
	private int E; // number of edges
	
	private Bag<Integer>[] adj; // adjacency lists

	public Graph(int V) {
		this.V = V; this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V]; // Create array of lists.
		for (int v = 0; v < V; v++) // Initialize all lists
			adj[v] = new Bag<Integer>(); // to empty.
	}

	public Graph(In in) {
		this(in.readInt()); // Read V and construct this graph.
		int E = in.readInt(); // Read E.
		for (int i = 0; i < E; i++){ // Add an edge.
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
		adj[v].add(w); // Add w to v’s list.
		adj[w].add(v); // Add v to w’s list.
		E++;
	}
	public Iterable<Integer> adj(int v) { 
		return adj[v]; 
	}


    public int degree(int v) {
        return adj[v].size();
    }

	 /**
     * Returns a string representation of this graph.
     *
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
     *         followed by the <em>V</em> adjacency lists
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