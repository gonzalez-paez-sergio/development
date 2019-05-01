package graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph1 {

  public List<Integer>[] adjacentVertices;
  private int numberOfVertices;

  @SuppressWarnings("unchecked")
  public Graph1(int numberOfVertices) {
    this.numberOfVertices = numberOfVertices + 1;

    this.adjacentVertices = (List<Integer>[]) new ArrayList[this.numberOfVertices];

    for (int i = 0; i < this.numberOfVertices; i++) {
      this.adjacentVertices[i] = new ArrayList<Integer>();
    }
  }

  public Iterable<Integer> adj(int v) {
    return this.adjacentVertices[v];
  }

  void addEdge(int i, int j) {
    System.out.printf("adding vertex %d, %d, numberOfVertices: %d\n", i, j, this.numberOfVertices);
    this.adjacentVertices[i].add(j);
    this.adjacentVertices[j].add(i);
  }

  public int getNumberOfVertices() {
    return numberOfVertices;
  }
}
