class Solution {
    Set<Integer> cols = new HashSet<>();
    Set<Integer> dias = new HashSet<>();
    Set<Integer> adias = new HashSet<>();

    int result = 0;
    int n;

    public int totalNQueens(int n) {
        this.n = n;

        backtrack(0);
        return result;    
    }

    private void backtrack(int row) {
        if (row == n) {
            result++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int diagonal = row - col;
            int antiDiagonal = row + col;

            if (cols.contains(col) || dias.contains(diagonal) || adias.contains(antiDiagonal)) {
                continue;
            }

            cols.add(col);
            dias.add(diagonal);
            adias.add(antiDiagonal);

            backtrack(row + 1);

            cols.remove(col);
            dias.remove(diagonal);
            adias.remove(antiDiagonal);
        }
    }
}