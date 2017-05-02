package graphs;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Search {

	boolean[] intMarked;
	private int count; // number of vertices connected to s

	public Search(Graph graph, int intVertixV) {
		intMarked = new boolean[graph.V()];
		dfs(graph, intVertixV);
	}

	// depth first search from v
	public boolean intMarked(int intVertixV) {
		return intMarked[intVertixV];
	}

	// depth first search from v
	public int count() {
		return count;
	}

	// depth first search from v
	private void dfs(Graph graph, int intVertixV) {
		count++;
		intMarked[intVertixV] = true;
		for (int w : graph.adj(intVertixV)) {
			if (!intMarked[w]) {
				dfs(graph, w);
			}
		}
	}

	/**
	 * Unit tests the {@code Search} data type.
	 *
	 * @param args
	 *            the command-line arguments
	 */
	public static void main(String[] args) {
		In in = new In(args[0]);
		Graph graph = new Graph(in);
		int s = Integer.parseInt(args[1]);
		Search search = new Search(graph, s);
		for (int v = 0; v < graph.V(); v++) {
			if (search.intMarked(v)) {
				StdOut.print(v + " ");
			}
		}

		StdOut.println();
		if (search.count() != graph.V())
			System.out.printf("NOT connected, count() %d vertix %d", search.count(), graph.V());
		else
			StdOut.println("connected");
	}
}