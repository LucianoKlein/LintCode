package BasicLesson.ladder4_bfs._616CourseScheduleII;

import java.util.Arrays;

import org.junit.Test;

public class testCourse {
	@Test
	public void testMethod() {
		Solution1 s = new Solution1();
		int [][] prerequisites= new int[][] {{0, 1}};
		String res = Arrays.toString(s.findOrder(2, prerequisites));
		//System.out.println(prerequisites[2] == prerequisites[5]);
		System.out.println(res);
	}
	@Test
	public void testSolution() {
		Solution s = new Solution();
		int [][] prerequisites = new int[][] {{0,1},{1,2},{2,3},{0,1}};
		String res =Arrays.toString(s.findOrder(4, prerequisites));
		System.out.println(res);
	}
}
