package ladder4_bfs._611KnightShortestPath;

import java.util.LinkedList;
import java.util.Queue;

import util.pointhelper.Point;

public class Solution {
	int[] dx = { 1, 1, -1, -1, 2, 2, -2, -2 };
	int[] dy = { 2, -2, 2, -2, 1, -1, 1, -1 };
	private final int DIRECTION_NUM = 8;

	public int shortestPath(boolean[][] grid, Point source, Point destination) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		Queue<Point> bfsQueue = new LinkedList<>();

		bfsQueue.offer(source);
		grid[source.x][source.y] = true;
		int stepNumber = 0;
		while (!bfsQueue.isEmpty()) {
			int size = bfsQueue.size();
			for (int i = 0; i < size; i++) {
				Point currPoint = bfsQueue.poll();
				if (currPoint.x == destination.x && currPoint.y == destination.y) {
					return stepNumber;
				}
				
				for (int direct = 0; direct < DIRECTION_NUM; direct++) {
					int nextX = dx[direct] + currPoint.x;
					int nextY = dy[direct] + currPoint.y;
					if (accessible(nextX, nextY, grid)) {
						if (!visited[nextX][nextY]) {
							Point nextPoint = new Point(nextX, nextY);
							bfsQueue.offer(nextPoint);
							grid[nextX][nextY] = true;
						}
					}
				}
			}
			stepNumber++;
		}
		return -1;
	}

	private boolean accessible(int x, int y, boolean[][] grid) {
		if (x < 0 || x >= grid.length) {
			return false;
		}
		if (y < 0 || y >= grid[0].length) {
			return false;
		}
		if (grid[x][y] == true) {
			return false;
		}
		return true;
	}

}
