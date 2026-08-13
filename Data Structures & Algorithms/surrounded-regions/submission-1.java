class Solution {

    int m;
    int n;
    char[][] board;
    
    public void solve(char[][] board) {
        this.m = board.length;
        this.n = board[0].length;
        this.board = board;

        for (int r = 0; r < m; r++) {
            if (board[r][0] == 'O') dfs(r, 0);
            if (board[r][n - 1] == 'O') dfs(r, n - 1);
        }

        for (int c = 0; c < n; c++) {
            if (board[0][c] == 'O') dfs(0, c);
            if (board[m - 1][c] == 'O') dfs(m - 1, c);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int row, int col) {
        if (row < 0 || col < 0 || row >= m || col >= n || board[row][col] != 'O') return;

        board[row][col] = 'T';
        dfs(row + 1, col);
        dfs(row, col + 1);
        dfs(row - 1, col);
        dfs(row, col - 1);
    }
}
