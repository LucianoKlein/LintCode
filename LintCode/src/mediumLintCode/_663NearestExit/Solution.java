package mediumLintCode._663NearestExit;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private static final int WALL = -1;
    private static final int GATE = 0;
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int INF = Integer.MAX_VALUE;
    
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    
    
    
    class Coordinate {
        int x;
        int y;
        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    /**
     * @param rooms m x n 2D grid
     * @return nothing
     */
    public void wallsAndGates(int[][] rooms) {
        // Write your code here
        if (rooms == null) {
            return;
        }
        
        int n = rooms.length;
        
        if (n == 0 || rooms[0].length == 0) {
            return;
        }
        
        int m = rooms[0].length;
        
        if (m == 0) {
            return;
        }
        
        Queue<Coordinate> coorQ = new LinkedList<>();
        //放入所有的门节点
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rooms[i][j] == GATE) {
                    coorQ.offer(new Coordinate(i, j));
                }
            }
        }
        
        
        while (!coorQ.isEmpty()) {
            Coordinate curPoint = coorQ.poll();
            
            for (int direct = 0; direct < 4; direct++) {
                int nx = curPoint.x + dx[direct];
                int ny = curPoint.y + dy[direct];
                
                if (0 <= nx && nx < n 
                        && 0 <= ny && ny < m 
                        && rooms[nx][ny] == INF) {
                    coorQ.offer(new Coordinate(nx, ny));
                    rooms[nx][ny] = rooms[curPoint.x][curPoint.y] + 1;
                }
            }
        }
        
    }
}
