package mediumLintCode._573BuildPostOfficeII;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 调不通
 * @author Mr.HX
 *
 */
public class Solution {
    private static final int EMPTY = 0;
    private static final int HOUSE = 1;
    private static final int WALL = 2;
    
    private int m;
    private int n;
    
    class Coordinate {
        int x;
        int y;
        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private static final int[] dx = {-1, 0, 0, 1};
    private static final int[] dy = {0, -1, 1, 0};
    
    /*
     * @param grid: a 2D grid
     * @return: An integer
     */
    public int shortestDistance(int[][] grid) {
        if (grid == null) {
            return -1;
        }
        n = grid.length;
        if (n == 0 || grid[0] == null) {
            return -1;
        }
        
        m = grid[0].length;
        if (m == 0) {
            return -1;
        }
        
        Queue<Coordinate> houseQ = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == HOUSE) {
                    houseQ.offer(new Coordinate(i, j));
                }
            }
        }
        System.out.println(houseQ.size());
        while (!houseQ.isEmpty()) {
            Coordinate currHouse = houseQ.poll();
            //bfs
            bfsSpace(grid, currHouse);
        }
        System.out.println(Arrays.deepToString(grid));
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] < 0 && (grid[i][j] * -1) < min) {
                    min = (grid[i][j] * -1);
                }
            }
        }
        
        return min;
        
    }
    
    private void bfsSpace(int[][] grid, Coordinate startPoint) {
        Queue<Coordinate> spaceQ = new LinkedList<>();
        spaceQ.offer(startPoint);
        boolean[][] visited = new boolean[n][m];
        int step = 1;
        while(!spaceQ.isEmpty()) {
            Coordinate currCoor = spaceQ.poll();
            for (int direct = 0; direct < 4; direct++) {
                Coordinate nextCoor = new Coordinate(currCoor.x + dx[direct], currCoor.y + dy[direct]); 
                if (0 <= nextCoor.x && nextCoor.x < n 
                    && 0 <= nextCoor.y && nextCoor.y < m
                    && grid[nextCoor.x][nextCoor.y] <= EMPTY
                    && visited[nextCoor.x][nextCoor.y] == false) {
                    grid[nextCoor.x][nextCoor.y] -= step;
                    visited[nextCoor.x][nextCoor.y] = true;
                    spaceQ.offer(nextCoor);
                }
            }
            step += 1;
        }
        return;
    }
}
