package graphs;

public class DepthFirstSearch {
  private boolean[] marked;
  private int count;

  public DepthFirstSearch(Graph G, int s) {
    marked = new boolean[G.V()];
    dfs(G, s);
  }

  private void dfs(Graph G, int v) {
    marked[v] = true;
    count++;
    for (int w : G.adj(v))
      // we can use this because we are indexing que vortex with numbers,
      // so we only need to visit once every vertex
      if (!marked[w]) {
        dfs(G, w);
      }
  }

  public boolean marked(int w) {
    return marked[w];
  }

  public int count() {
    return count;
  }
}
