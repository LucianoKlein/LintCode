package BasicLesson.ladder4_bfs._598ZombieInMatrix;

import org.junit.Test;

public class Demo {
	@Test
	public void testing() {
		Solution s = new Solution();
		int[][] grid = {{0,1,2,0,0}, {1,0,0,2,1}, {0,1,0,0,0}};
		int res = s.zombie(grid);
		System.out.println(res);
	}
}
