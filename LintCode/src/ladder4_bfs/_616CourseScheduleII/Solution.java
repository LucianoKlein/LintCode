package ladder4_bfs._616CourseScheduleII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your code here
    	//新建一个表示边关系的List[]
        List[] edges = new ArrayList[numCourses];
        //新建一个表示度关系的int[]
        int[] degree = new int[numCourses];
        //初始化edges, 每个元素都是一个arrayList
        for (int i = 0;i < numCourses; i++) {
        	edges[i] = new ArrayList<Integer>();
        }
        //扫一遍, 度数++, degree[num] 是第num门课的入度(在第一列的数字都可以作为入度)    
        for (int i = 0; i < prerequisites.length; i++) {
            //后置课的入度+1
        	degree[prerequisites[i][0]] ++ ;
            //边  前置课 --> 后置课
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        //用来bfs的队列
        Queue queue = new LinkedList();
        for(int i = 0; i < degree.length; i++){
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        //
        int count = 0;
        //order 从0 到 numCourses-1 代表了 遍历的顺序
        int[] order = new int[numCourses];
        //当队列不空
        while(!queue.isEmpty()){
            int course = (int)queue.poll();
            order[count] = course;
            count ++;
            //n 为 edges[course]的大小, 也就是依赖 当前course的所有节点的个数
            int n = edges[course].size();
            for(int i = n - 1; i >= 0 ; i--){
            	//edges[course].get(i) 取出来了数字
                int pointer = (int)edges[course].get(i);
                //把度数 -- 
                degree[pointer]--;
                if (degree[pointer] == 0) {
                    queue.add(pointer);
                }
            }
        }
        
        if (count == numCourses)
            return order;

        return new int[0];
    }
}
