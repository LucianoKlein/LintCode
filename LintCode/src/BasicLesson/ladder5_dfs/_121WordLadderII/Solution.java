package BasicLesson.ladder5_dfs._121WordLadderII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/**
 * word ladder II 中的DFS就是一个很基础的深度优先搜索，
 * 只不过之前我们用BFS处理过了最短路径，那么为了找出所有最短路径，
 * 那么必须满足搜索的路径distance.get(crt) == distance.get(next) + 1才行，
 * 如果一步相差2以上，则这条路径一定不会出现在最短路径中。
 * @author Mr.HX
 *
 */
public class Solution {
	public List<List<String>> findLadders(String start, 
										  String end, 
										  Set<String> dict) {
		//存储整个的迭代过程,中间的那些单词
		List<List<String>> ladders = new ArrayList<>();
		//
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		//存储bfs的距离, 就是当前单词距离终点的距离
		Map<String, Integer> distance = new HashMap<String, Integer>();
		
		//为了防止dict里没这两个词
		dict.add(start);
		dict.add(end);
		
		//先通过bfs来遍历一遍, 找出最短距离
		bfs(map, distance, start, end, dict);
		
		List<String> path = new ArrayList<String>();
		
		//从终点往起点走
		dfs(ladders, path, end, start, distance, map);
		
		return ladders;
		
	}

	private void dfs(List<List<String>> ladders, 
					 List<String> path, 
					 String crt, 
					 String start,
					 Map<String, Integer> distance, 
					 Map<String, List<String>> map) {
		//path表示当前的这一条路径
		path.add(crt);
		//如果crt和start相等, 说明这就是出口
		if (crt.equals(start)) {
			//把path反过来
			Collections.reverse(path);
			//把path放入这个最终结果集
			ladders.add(new ArrayList<String>(path));
			//把path再还原
			Collections.reverse(path);
		} else {
			for (String next : map.get(crt)) {
				if (distance.containsKey(next) && distance.get(crt) == distance.get(next) + 1) {
					dfs(ladders, path, next, start, distance, map);
				}
			}
		}
		path.remove(path.size() - 1);
	}

	private void bfs(Map<String, List<String>> map, 
					 Map<String, Integer> distance, 
					 String start, 
					 String end,
			         Set<String> dict) {
		//这个是bfs的队列
		Queue<String> q = new LinkedList<String>();
		//把start字符串压进去
		q.offer(start);
		//把distance map, 设置成0
		distance.put(start, 0);
		
		//把所有的字典里的字符串,都压进map里(这好大啊)
		//value 里边放的是这个字符串的当前候选词
		//这边因为map是上级传入的, 所以第一次做过之后, 这件事就不会再做了, 而且bfs也不存在递归
		for (String s : dict) {
			map.put(s, new ArrayList<String>());
		}
		
		while (!q.isEmpty()) {
			String crt = q.poll();
			//把expand的结果集, 用nextList来引用
			List<String> nextList = expand(crt, dict);
			for (String next : nextList) {
				//得到字典词, 把当前的词加到ArrayList里边
				map.get(next).add(crt);
				//如果distance 不包含 next
				//如果distance 包含next的话, 说明是重复的路线, 就不需要走了
				if (!distance.containsKey(next)) {
					//到达next这个点的距离, 是从crt这边+1走过来的
					distance.put(next, distance.get(crt) + 1);
					//在队列里加入这个点
					q.offer(next);
				}
			}
		}
	}
	//扩大
	private List<String> expand(String crt, Set<String> dict) {
		//expansion记录所有的单词
		List<String> expansion = new ArrayList<String>();
		//crt是current的缩写
		//每个单词都扫描一遍
		for (int i = 0; i < crt.length(); i++) {
			//把26个字母扫一遍
			for (char ch = 'a'; ch <= 'z'; ch++) {
				//只有不重复的字母才会进入循环体
				if (ch != crt.charAt(i)) {
					//把i之前和i之后的 与ch拼接在一起
					String expanded = crt.substring(0, i) + ch 
							+ crt.substring(i + 1);
					//如果字典里有这个单词, 那么就可以加入到结果集中
					if (dict.contains(expanded)) {
						expansion.add(expanded);
					}
				}
			}
		}
		return expansion;
	}
}
