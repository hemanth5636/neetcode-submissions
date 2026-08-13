class Solution {
    Set<Integer> cols = new HashSet<>();
    Set<Integer> dia = new HashSet<>();
    Set<Integer> adia = new HashSet<>();
    List<List<String>> result = new ArrayList<>();
    int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        backtrack(0, board);
        return result;
    }

    private void backtrack(int row, char[][] board) {
        if (row == n) {
            List<String> currBoard = new ArrayList<>();
            for (char[] r : board) {
                currBoard.add(new String(r));
            }
            result.add(currBoard);
            return;
        }

        for (int col = 0; col < n; col++) {
            int diagonal = row - col;
            int antiDiagonal = row + col;

            if (cols.contains(col) || dia.contains(diagonal) || adia.contains(antiDiagonal)) continue;

            cols.add(col);
            dia.add(diagonal);
            adia.add(antiDiagonal);
            board[row][col] = 'Q';

            backtrack(row + 1, board);

            cols.remove(col);
            dia.remove(diagonal);
            adia.remove(antiDiagonal);
            board[row][col] = '.';
        }
    }
}
