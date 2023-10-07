package lab2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSTreeSearchAIGo implements ISearchAlgo {

	@Override
		public Node execute(Node root, String goal) {
			Queue<Node> frontier = new LinkedList<Node>();
			frontier.add(root);
			while (!frontier.isEmpty()) {
				Node curent = frontier.poll();
				if (curent.getLabel().equals(goal)) {
					return curent;

				} else {
					java.util.List<Node> children = curent.getChildrenNodes();
					for (Node child : children) {
						if (!frontier.contains(child)) {
							frontier.add(child);
							child.setParent(curent);

						}
					}
				}

			}
			return null;
		}

	@Override
	public Node execute(Node root, String start, String goal) {
		Node n = execute(root, start);
		n.setParent(null);
		Node node = execute(n, goal);
		return node;
	}
public static void main(String[] args) {
	BFSGraphsearchAIGo go = new BFSGraphsearchAIGo();
	Node nS = new Node("S");
	Node nA = new Node("A");
	Node nB = new Node("B");
	Node nC = new Node("C");
	Node nD = new Node("D");
	Node nE = new Node("E");
	Node nF = new Node("F");
	Node nG = new Node("G");
	Node nH = new Node("H");
	nS.addEdge(nA, 5);
	nS.addEdge(nB, 2);
	nS.addEdge(nC, 4);
	nA.addEdge(nD, 9);
	nA.addEdge(nE, 4);
	nB.addEdge(nG, 6);
	nC.addEdge(nF, 2);
	nD.addEdge(nH, 7);
	nE.addEdge(nG, 6);
	nF.addEdge(nG, 1);
	Node node = go.execute(nS, "G");
	NodeUtils n1 = new NodeUtils();
	System.out.println(n1.printPath(node));
	Node node1 = go.execute(nS, "C", "G");
	System.out.println(n1.printPath(node1));
}
}
