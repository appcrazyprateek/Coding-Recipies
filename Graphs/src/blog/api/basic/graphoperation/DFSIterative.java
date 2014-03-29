package blog.api.basic.graphoperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * DFS traversal in a undirected Graph using Stack
 * @author Prateek
 *
 */
public class DFSIterative {

	private int numVertices;
	private int numEdges;

	// Map to maintain adjacency List
	private Map<Integer, ArrayList<Integer>> adjList;
	// Map to maintain visit status
	private Map<Integer, Boolean> vistedStatus;

	/*
	 * Constructor when number of vertices are not known
	 */
	public DFSIterative() {
		this.adjList = new HashMap<Integer, ArrayList<Integer>>();
		this.vistedStatus = new HashMap<Integer, Boolean>();
	}

	/*
	 * Constructor when number of vertices are known
	 */
	public DFSIterative(int V) {
		this.numVertices = V;
		this.adjList = new HashMap<Integer, ArrayList<Integer>>(V);
		this.vistedStatus = new HashMap<Integer, Boolean>(V);
	}

	/**
	 * Edge in a un-directed graph
	 */
	private void addEdge(int src, int dest) {

		/* Forward Edge */
		ArrayList<Integer> list = adjList.get(src);
		if (list == null)
			list = new ArrayList<Integer>();

		list.add(dest);
		adjList.put(src, list);
		vistedStatus.put(src, false); // visit status set to false

		/* Reverse Edge */
		list = adjList.get(dest);
		if (list == null)
			list = new ArrayList<Integer>();

		list.add(src);
		adjList.put(dest, list);
		vistedStatus.put(dest, false); // visit status set to false

	}

	/**
	 * Procedure for Iterative DFS using Stack
	 */
	public void dfsIterative(int startNode) {
		System.out.println("Iterative DFS : ");
		Stack<Integer> stack = new Stack<Integer>();

		stack.push(startNode);
		vistedStatus.put(startNode, true);

		while (!stack.empty()) {

			int item = stack.pop();

			System.out.println("Poped Item : " + item);

			List<Integer> list = adjList.get(item);
			int size = list.size();

			for (int j = 0; j < size; j++) {
				int dest = list.get(j);

				if (!vistedStatus.get(dest)) {
					vistedStatus.put(dest, true);
					stack.push(dest);
				}
			}
		}
	}

	public static void main(String[] args) {
		DFSIterative g = new DFSIterative(6);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(1, 3);

		g.dfsIterative(0);

	}
}
