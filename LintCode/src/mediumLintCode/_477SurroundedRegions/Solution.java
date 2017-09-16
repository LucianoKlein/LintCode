package mediumLintCode._477SurroundedRegions;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /*
     * @param board: board a 2D board containing 'X' and 'O'
     * @return: nothing
     */
    int rows, cols;
    public void surroundedRegions(char[][] board) {
        if (board == null) {
            return;
        }
        rows = board.length;
        if (rows == 0) {
            return;
        }
        cols = board[0].length;
        if (cols == 0) {
            return;
        }
        //把左右两边的平原注水
        for (int i = 0; i < rows; i++) {
            bfs(board, i ,       0);
            bfs(board, i, cols - 1);
            
        }
        
        //把上下两边的平原注水'w'
        for (int j = 0; j < cols; j++) {
            bfs(board, 0,        j);
            bfs(board, rows - 1, j);
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'W') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
        
    }
    /**
     *把所有和sx, sy相邻的盆地注水 'w'
     */
    void bfs(char[][] board, int startX, int startY) {
        if (board[startX][startY] != 'O') {
            return;
        }
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        
        qx.offer(startX);
        qy.offer(startY);
        board[startX][startY] = 'W';
        
        while (!qx.isEmpty()) {
            int cx = qx.poll();
            int cy = qy.poll();
            
            for (int direct = 0; direct < 4; direct++) {
                int nx = cx + dx[direct];
                int ny = cy + dy[direct];
                if (0 <= nx && nx < rows && 0 <= ny && ny < cols && board[nx][ny] == 'O') {
                    board[nx][ny] = 'W';
                    qx.offer(nx);
                    qy.offer(ny);
                }
                
            }
        }
    }
}
