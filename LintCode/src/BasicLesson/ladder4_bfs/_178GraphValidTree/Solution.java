package BasicLesson.ladder4_bfs._178GraphValidTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 只需要知道连通性就可以了
 * n个点, n-1 条边
 * @author Mr.HX
 *
 */
/**
 * @param n an integer
 * @param edges a list of undirected edges
 * @return true if it's a valid tree, or false
 */
public class Solution {
	 //其实判断的条件就2个 
	 //n个点, n-1条边
	 //全部联通.
    public boolean validTree(int n, int[][] edges) {
    	//空节点不是树
    	if (n == 0) {
    		return false;
    	}
    	//n - 1条边, n个节点
    	if (edges.length != n - 1) {
    		return false;
    	}
    	// 弧表示法 转换成 邻接表
    	Map<Integer, Set<Integer>> graph = initializeGraph(n, edges);
    	/* 
    	 * 设计一个数据结构, 既能扮演queue, 还能判断是否存在过
    	 * 就用queue 和 hash这对好基友就好了
    	 */
    	Queue<Integer> queue = new LinkedList<>();
    	Set<Integer> hash = new HashSet<>();
    	/**
    	 * 只要图不空, 那么0这个节点就一定存在
    	 */
    	queue.offer(0);
    	hash.add(0);
    	/*
    	 * bfs
    	 * 如果不空 ,那就一直弹弹弹
    	 */
    	while (!queue.isEmpty()) {
    		int node = queue.poll();
    		//graph.get(node) 之后, 就是一个集合, 集合里都是此时弹出的队列中元素的相邻元素
    		//遍历所有的node的相邻元素
    		for (Integer neighbor : graph.get(node)) {
    			//如果这个元素已经被遍历过了, 就跳过他
    			if (hash.contains(neighbor)) {
    				continue;
    			}
    			hash.add(neighbor);
    			queue.offer(neighbor);
    		}
    	}
    	//n个点, n - 1条边. 全都能遍历一遍互相连通. ok
    	return (hash.size() == n);
    }
    
    /**
     * 把  弧表示法 转换成 邻接表
     * @param n
     * @param edges
     * @return
     */
    public Map<Integer, Set<Integer>> initializeGraph(int n, int[][] edges) {
    	Map<Integer, Set<Integer>> graph = new HashMap<>();
    	/*
    	 * 初始化每一个HashSet的值
    	 */
    	for (int i = 0; i < n; i++) {
    		graph.put(i, new HashSet<Integer>());
    	}
    	/*
    	 * 遍历所有的edges数组, 在map里设置一下, 每一条边set里放入他的相邻边
    	 */
    	for (int i = 0; i < edges.length; i++) {
    		int u = edges[i][0];
    		int v = edges[i][1];
    		graph.get(u).add(v);
    		graph.get(v).add(u);
    	}
    	return graph;
    }
}
