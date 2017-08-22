package ladder4_bfs._137CloneGraph;

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
		//��һ��, ����ͼ������еĽڵ㶼�ҵ�, �ŵ�list���ȥ
		Set<UndirectedGraphNode> nodes = getAllNodes(node);
		
		//step 2
		//�ڶ���, �����нڵ㶼��¡һ��, ���ҷ���ͨ����ϣ��, һһ��Ӧ
		// old node --> new node
		Map<UndirectedGraphNode, UndirectedGraphNode> mapping = cloneNodes(nodes);
		
		//step 3, �ѱ߽ṹҲ��¡���
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
		 * ���һ��Ҫ�жϷǿ� ���� queue != null, �������isEmpty
		 */
		while(!queue.isEmpty()) {
			UndirectedGraphNode curr= queue.poll();
			for (UndirectedGraphNode tempNode : curr.neighbors) {
				//�����ϣ�����������ڵ�, ��������
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
	 * ��¡���еĽڵ�
	 * @param nodes 
	 * @return ���Ͻڵ��ӳ��
	 */
	private Map<UndirectedGraphNode, UndirectedGraphNode> cloneNodes(Set<UndirectedGraphNode> nodes) {
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		for (UndirectedGraphNode tempNode : nodes) {
			map.put(tempNode, new UndirectedGraphNode(tempNode.label));
		}
		return map;
	}
	/**
	 * ��¡���еı�
	 * @param nodes ���е��Ͻڵ�
	 * @param mapping �Ͻڵ�key, �½ڵ�value
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
