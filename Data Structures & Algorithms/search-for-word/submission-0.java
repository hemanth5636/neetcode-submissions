class Solution {
    char[][] board;
    String word;
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board[0].length; col++)
                if (dfs(0, row, col)) return true;
        return false;
    }

    private boolean dfs(int i, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) return false;
        if (board[row][col] != word.charAt(i)) return false;   // covers '#' too
        if (i == word.length() - 1) return true;

        char c = board[row][col];
        board[row][col] = '#';                    // choose
        for (int[] d : dirs)
            if (dfs(i + 1, row + d[0], col + d[1])) {
                board[row][col] = c;              // restore before returning!
                return true;
            }
        board[row][col] = c;                      // un-choose
        return false;
    }
}