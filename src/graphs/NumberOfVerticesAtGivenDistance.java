package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * write a program that takes 2 integers N and D and a tree of exactly N
 * vertices and n-1 edges. Your program should ouput the number of vertices that
 * are at a distance of exactly D from the vertex 1
 * 
 * Note: the integer N adn D will be given in the firt line (each separated by a
 * single space) and the tree will be given in the next N-1 lines. Each of the
 * next N-1 lines will contain exactly 2 integers A and B (each separated by a
 * single space), meaning that there's a bidirectional connection between vertex
 * A and vertex B
 * 
 * Note: A graph is a undirected acyclic graph in which any two vertices are
 * connected by exactly one path
 * 
 * example
 * 
 * <pre>
 * case 1
 * input
 * 		4 1
 * 		1 2
 * 		1 3
 * 		1 4 
 * output
 * 		3
 * vertices 2, 3, 4 are exactly one distance from the  vertex 1
 * 
 * case 1
 * input
 * 		4 2
 * 		1 2
 * 		2 3
 * 		3 4 
 * output
 * 		1
 * vertice 3 is exactly  2 distance from the vertex 1
 * 
 * </pre>
 * 
 * @author sergiogp
 *
 */
public class NumberOfVerticesAtGivenDistance {
	private boolean[] marked;

	public NumberOfVerticesAtGivenDistance(Graph graph, int i) {
		this.marked = new boolean[graph.getNumberOfVertices()];
	}

	public static void main(String[] string) {

		Graph graph = new Graph(4);

		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);

		System.out.println("entrando a DFS");
		NumberOfVerticesAtGivenDistance d = new NumberOfVerticesAtGivenDistance(graph, 2);

		System.out.printf("result : %d\n", d.test(graph, 1));

		graph = new Graph(4);

		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		d = new NumberOfVerticesAtGivenDistance(graph, 2);

		System.out.println("entrando a DFS");

		System.out.printf("result : %d\n", d.test(graph, 2));

	}

	private int test(Graph graph, int i) {

		Queue<Integer> queue = new LinkedList<Integer>();
		// for every element contained
		// we start with the first element in the graph, which is 1
		// int currentV = 1;
		Iterable<Integer> currentAdjacent = null;
		queue.add(1);
		int queueSize = queue.size();
		int counter = 0;

		int deeph = 0;

		while (deeph < i) {
			counter = 0;
			queueSize = queue.size();

			while (counter++ < queueSize) {
				System.out.printf("counter:%d, queueSize:%d \n", counter, queueSize);
				Integer currentV = queue.poll();
				currentAdjacent = graph.adj(currentV);
				marked[currentV] = true;
				// add every adjacent element to the queue
				for (int currentW : currentAdjacent) {
					if (!this.marked[currentW]) {
						queue.add(currentW);
					}
				}

			}

			System.out.printf("queue:%s\n", queue);

			deeph++;
		}

		return queue.size();
	}
}