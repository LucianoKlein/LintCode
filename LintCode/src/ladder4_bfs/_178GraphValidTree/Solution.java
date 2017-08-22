package ladder4_bfs._178GraphValidTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * ֻ��Ҫ֪����ͨ�ԾͿ�����
 * n����, n-1 ����
 * @author Mr.HX
 *
 */
/**
 * @param n an integer
 * @param edges a list of undirected edges
 * @return true if it's a valid tree, or false
 */
public class Solution {
	 //��ʵ�жϵ�������2�� 
	 //n����, n-1����
	 //ȫ����ͨ.
    public boolean validTree(int n, int[][] edges) {
    	//�սڵ㲻����
    	if (n == 0) {
    		return false;
    	}
    	//n - 1����, n���ڵ�
    	if (edges.length != n - 1) {
    		return false;
    	}
    	// ����ʾ�� ת���� �ڽӱ�
    	Map<Integer, Set<Integer>> graph = initializeGraph(n, edges);
    	/* 
    	 * ���һ�����ݽṹ, ���ܰ���queue, �����ж��Ƿ���ڹ�
    	 * ����queue �� hash��Ժû��Ѿͺ���
    	 */
    	Queue<Integer> queue = new LinkedList<>();
    	Set<Integer> hash = new HashSet<>();
    	/**
    	 * ֻҪͼ����, ��ô0����ڵ��һ������
    	 */
    	queue.offer(0);
    	hash.add(0);
    	/*
    	 * bfs
    	 * ������� ,�Ǿ�һֱ������
    	 */
    	while (!queue.isEmpty()) {
    		int node = queue.poll();
    		//graph.get(node) ֮��, ����һ������, �����ﶼ�Ǵ�ʱ�����Ķ�����Ԫ�ص�����Ԫ��
    		//�������е�node������Ԫ��
    		for (Integer neighbor : graph.get(node)) {
    			//������Ԫ���Ѿ�����������, ��������
    			if (hash.contains(neighbor)) {
    				continue;
    			}
    			hash.add(neighbor);
    			queue.offer(neighbor);
    		}
    	}
    	//n����, n - 1����. ȫ���ܱ���һ�黥����ͨ. ok
    	return (hash.size() == n);
    }
    
    /**
     * ��  ����ʾ�� ת���� �ڽӱ�
     * @param n
     * @param edges
     * @return
     */
    public Map<Integer, Set<Integer>> initializeGraph(int n, int[][] edges) {
    	Map<Integer, Set<Integer>> graph = new HashMap<>();
    	/*
    	 * ��ʼ��ÿһ��HashSet��ֵ
    	 */
    	for (int i = 0; i < n; i++) {
    		graph.put(i, new HashSet<Integer>());
    	}
    	/*
    	 * �������е�edges����, ��map������һ��, ÿһ����set������������ڱ�
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
