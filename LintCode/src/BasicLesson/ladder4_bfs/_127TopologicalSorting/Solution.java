package BasicLesson.ladder4_bfs._127TopologicalSorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import util.graphhelper.DirectedGraphNode;

public class Solution {
	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
		ArrayList<DirectedGraphNode> sortingResult = new ArrayList<>();
		if (graph == null || graph.isEmpty()) {
			return sortingResult;
		}
		//1计算 入度
		Map<DirectedGraphNode, Integer> indegreeMapping = getIndegree(graph);
		
		//2得到所有的零度节点
		ArrayList<DirectedGraphNode> nodesWithZeroDegree = getZeroDegreetNodes(indegreeMapping, graph);
		
		//3bfs拓扑排序
		sortingResult = bfs(indegreeMapping, nodesWithZeroDegree);
		
		if (sortingResult.size() == graph.size()) {
			return sortingResult;
		}
		return null;
	}
	private Map<DirectedGraphNode, Integer> getIndegree(ArrayList<DirectedGraphNode> graphToProcess) {
		Map<DirectedGraphNode, Integer> indegreeMapping = new HashMap<>();
		for (DirectedGraphNode gNode : graphToProcess) {
			indegreeMapping.put(gNode, 0);
		}
		for (DirectedGraphNode currGNode : graphToProcess) {
			for (DirectedGraphNode neighborNode : currGNode.neighbors) {
				indegreeMapping.put(neighborNode, indegreeMapping.get(neighborNode) + 1);
			}
		}
		return indegreeMapping;
	}
	
	private ArrayList<DirectedGraphNode> getZeroDegreetNodes(Map<DirectedGraphNode, Integer> indegreeMapping,  
													  ArrayList<DirectedGraphNode> graph ) {
		ArrayList<DirectedGraphNode> zeroDegreeNodesList = new ArrayList<>(); 
		for (DirectedGraphNode currGraphNode : graph) {
			if (indegreeMapping.get(currGraphNode) == 0) {
				zeroDegreeNodesList.add(currGraphNode);
			}
		}
		
		return zeroDegreeNodesList;
	}
	
	private ArrayList<DirectedGraphNode> bfs(Map<DirectedGraphNode, Integer> indegreeMapping, 
											 ArrayList<DirectedGraphNode> nodesWithZeroDegree) {
		ArrayList<DirectedGraphNode> sortingResult = new ArrayList<>();
		Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
		Iterator<DirectedGraphNode> itOfZeroDegreeNode = nodesWithZeroDegree.iterator();
		while (itOfZeroDegreeNode.hasNext()) {
			queue.offer(itOfZeroDegreeNode.next());
		}
		
		while (!queue.isEmpty()) {
			DirectedGraphNode currDirectGNode = queue.poll();
			sortingResult.add(currDirectGNode);
			for (DirectedGraphNode currNeighbor : currDirectGNode.neighbors) {
				int currIndegree = indegreeMapping.get(currNeighbor) - 1;
				indegreeMapping.put(currNeighbor, currIndegree);
				if (currIndegree == 0) {
					queue.offer(currNeighbor);
				}
			}
		}
		return sortingResult;
	}
}
