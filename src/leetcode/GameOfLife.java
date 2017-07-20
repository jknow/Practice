package leetcode;

public class GameOfLife {
	
    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = lifeSumInfinity(i, j, board, m, n);
                if (live < 2 || live > 3) board[i][j] &= 1;
                else if (live == 3 || ((board[i][j] & 1) == 1 && live == 2)) board[i][j] |= 2;
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }
    
    public static int lifeSumInfinity(int i, int j, int[][] board, int m, int n) {
        int neighborSum = 0;
        for (int k = -1; k < 2; k++) {
            for (int l = -1; l < 2; l += (++l | k) == 0 ? 2 : 1) {
                neighborSum += board[((i + k) + m) % m][((j + l) + n) % n] & 1;
            }
        }
        return neighborSum;
    }
    
    public int lifeSum(int i, int j, int[][] board, int m, int n) {
        int neighborSum = 0;
        for (int k = -1; k < 2; k++) {
            if (i + k >= 0 && i + k < m) {
                for (int l = -1; l < 2; l += (++l | k) == 0 ? 2 : 1) {
                    if (j + l >= 0 && j + l < n) {
                        neighborSum += board[i + k][j + l] & 1;
                    }
                }
            }
        }
        return neighborSum;
    }

}
