package BasicLesson.ladder4_bfs._616CourseScheduleII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/**
 * 做不出来, 这个输入会重复很难受
 * @author Mr.HX
 *
 */
public class Solution1 {
	/**
	 * 
	 * @param numCourses
	 * @param prerequisites
	 * [1,0] ----> 0=>1
	 * [2,0] ----> 0=>2
	 * @return
	 */
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
        	return new int[]{};
        }
        
        if (prerequisites == null || prerequisites.length == 0) {
        	return new int[]{};
        }
        
        if (prerequisites[0].length != 2) {
        	return new int[]{};
        }
		//step 1 build a Graph from prerequisites
		DirectedGraph graph = new DirectedGraph(prerequisites, numCourses);
		//step 2 topological sorting
		return graph.topoSort();
        
    }
	
	private class DirectedGraphNode {
		public Integer label;
		HashSet<DirectedGraphNode> neighbors;
		public DirectedGraphNode(int value) {
			this.label = value;
			neighbors = new HashSet<DirectedGraphNode>();
		}
	}
	
	private class DirectedGraph {
		Map<DirectedGraphNode, Integer> graphIndegreeMapping ;
		Map<Integer, DirectedGraphNode> courseMap;
		public DirectedGraph(int[][] prerequisites, int numCourses) {
			courseMap = new HashMap<Integer, DirectedGraphNode>();
			graphIndegreeMapping = new HashMap<DirectedGraphNode, Integer>();
			for (int i = 0; i < numCourses; i++) {
				courseMap.put(i, new DirectedGraphNode(i));
				graphIndegreeMapping.put(courseMap.get(i), 0);
			}
			//build indegree mapping
			for (int i = 0; i < prerequisites.length; i++) {
				DirectedGraphNode left = courseMap.get(prerequisites[i][0]);
				DirectedGraphNode right = courseMap.get(prerequisites[i][1]);
					
				graphIndegreeMapping.put(left, graphIndegreeMapping.get(left) + 1);
				graphIndegreeMapping.put(right, graphIndegreeMapping.get(right));
			}
			
		}
		public int[] topoSort() {
			ArrayList<Integer> res = new ArrayList<>();
			Queue<DirectedGraphNode> zeroDegreeQ = new LinkedList<>();
			for (DirectedGraphNode currNode : courseMap.values()) {
				if (graphIndegreeMapping.get(currNode) == 0) {
					zeroDegreeQ.offer(currNode);
				}
			}
			
			//dfs
			while (!zeroDegreeQ.isEmpty()) {
				DirectedGraphNode currGNode = zeroDegreeQ.poll();
				res.add(currGNode.label);
				for (DirectedGraphNode currNeighbor : currGNode.neighbors) {
					int currIndegree = graphIndegreeMapping.get(currNeighbor) - 1;
					graphIndegreeMapping.put(currNeighbor, currIndegree);
					if (currIndegree == 0) {
						zeroDegreeQ.offer(currNeighbor);
					}
				}
			}
			//System.out.println(res);
			
			if (res.size() == courseMap.size()) {
				int[] result = new int[res.size()];
				for (int i = 0; i < result.length; i++) {
					result[i] = res.get(i);
				}
				return result;
			}
			return new int[]{};
		}
		
	}
}
