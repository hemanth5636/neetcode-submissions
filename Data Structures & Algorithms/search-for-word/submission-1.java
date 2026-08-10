class Solution {
    char[][] board;
    String word;
    int rows;
    int cols;
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.rows = board.length;
        this.cols = board[0].length;
        boolean[][] seen = new boolean[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    seen[i][j] = true;
                    if (backtrack(i, j, 1, seen)) return true;
                    seen[i][j] = false;
                }
            }
        }

        return false;

    }

    private boolean isValid(int row, int col) {
        return row < rows && row >= 0 && col < cols && col >= 0;
    }

    private boolean backtrack(int row, int col, int curr, boolean[][] seen) {
        if (curr == word.length()) return true;

        for (int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];

            if (isValid(nr, nc) && !seen[nr][nc] && board[nr][nc] == word.charAt(curr)) {
                seen[nr][nc] = true;
                if (backtrack(nr, nc, curr + 1, seen)) return true;
                seen[nr][nc] = false;
            }
        }

        return false;

    }
}
