package util.graphhelper;

import java.util.ArrayList;

public class DirectedGraphNode {
	int label;
	public ArrayList<DirectedGraphNode> neighbors;
	public DirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<DirectedGraphNode>();
	}
}
