package lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSGraphSearchAIGo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Stack<Node> frotiner = new Stack<>();
		frotiner.push(root);
		ArrayList<Node> ex = new ArrayList<>();
		while (!frotiner.isEmpty()) {
			Node current = frotiner.pop();
			if (current.getLabel().equals(goal)) {
				return current;
			} else {
				ex.add(current);
				List<Node> children = current.getChildrenNodes();
				for (int i = children.size() - 1; i >= 0; i--) {
					Node child = children.get(i);
					if (!frotiner.contains(child) && !ex.contains(child)) {
						frotiner.push(child);
						child.setParent(current);
						
					}
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		Node n = execute(root, start);
		n.setParent(null);
		Node node = execute(n, goal);
		return node;
	}

	public static void main(String[] args) {
		DFSGraphSearchAIGo go = new DFSGraphSearchAIGo();
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
		NodeUtils n = new NodeUtils();
		System.out.println(n.printPath(node));
		Node node2 = go.execute(nS, "A", "G");
		System.out.println(n.printPath(node2));
	}
}
