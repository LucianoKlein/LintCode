package BasicLesson.ladder4_bfs._137CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import util.graphhelper.UndirectedGraphNode;

public class Solution {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
        	return null;
        }
		//step 1 
		//第一步, 把老图里的所有的节点都找到, 放到list里边去
		Set<UndirectedGraphNode> nodes = getAllNodes(node);
		
		//step 2
		//第二步, 把所有节点都克隆一遍, 并且放入通过哈希表, 一一对应
		// old node --> new node
		Map<UndirectedGraphNode, UndirectedGraphNode> mapping = cloneNodes(nodes);
		
		//step 3, 把边结构也克隆完成
		cloneEdges(nodes, mapping);
		return mapping.get(node);
    }
	//deep copy
	private Set<UndirectedGraphNode> getAllNodes(UndirectedGraphNode node) {
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		Set<UndirectedGraphNode> hash = new HashSet<>();
		queue.offer(node);
		hash.add(node);
		/**
		 * 这边一定要判断非空 不能 queue != null, 必须调用isEmpty
		 */
		while(!queue.isEmpty()) {
			UndirectedGraphNode curr= queue.poll();
			for (UndirectedGraphNode tempNode : curr.neighbors) {
				//如果哈希表里边有这个节点, 本轮跳过
				if (hash.contains(tempNode)) {
					continue;
				}
				queue.offer(tempNode);
				hash.add(tempNode);
			}
		}
		return hash;
	}
	/**
	 * 克隆所有的节点
	 * @param nodes 
	 * @return 新老节点的映射
	 */
	private Map<UndirectedGraphNode, UndirectedGraphNode> cloneNodes(Set<UndirectedGraphNode> nodes) {
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		for (UndirectedGraphNode tempNode : nodes) {
			map.put(tempNode, new UndirectedGraphNode(tempNode.label));
		}
		return map;
	}
	/**
	 * 克隆所有的边
	 * @param nodes 所有的老节点
	 * @param mapping 老节点key, 新节点value
	 */
	private void cloneEdges(Set<UndirectedGraphNode> nodes, 
			                Map<UndirectedGraphNode, UndirectedGraphNode> mapping) {
		for (UndirectedGraphNode n : nodes) {
			ArrayList<UndirectedGraphNode> newNeighbors = new ArrayList<>();
			UndirectedGraphNode currentNewNeighborBeingProcessed = mapping.get(n);
			currentNewNeighborBeingProcessed.neighbors = newNeighbors;
			for (UndirectedGraphNode currentOldNeighborToBeCloned : n.neighbors) {
				newNeighbors.add(mapping.get(currentOldNeighborToBeCloned));
			}
		}
	}
}
