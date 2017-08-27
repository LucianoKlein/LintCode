package BasicLesson.ladder4_bfs._618SearchGraphNodes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import util.graphhelper.UndirectedGraphNode;

public class Solution {
	public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
										  Map<UndirectedGraphNode, Integer> values,
										  UndirectedGraphNode node,
										  int target) {
		//新建一个队列, 用来做bfs
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		//新建一个hash, 用来记录该节点是否被访问过
		Set<UndirectedGraphNode> hash = new HashSet<UndirectedGraphNode>();
		
		queue.offer(node);
		hash.add(node);
		
		while (!queue.isEmpty()) {
			UndirectedGraphNode head = queue.poll();
			if (values.get(head) == target) {
				return head;
			}
			//遍历这个节点的邻居
			for (UndirectedGraphNode nei : head.neighbors) {
				//这个邻居已经被访问过了, 就跳过这个
				if (!hash.contains(nei)) {
					queue.offer(nei);
					hash.add(nei);
				}
			}
		}
		return null;
	}
}
