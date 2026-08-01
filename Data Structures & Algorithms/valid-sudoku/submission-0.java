class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> sq = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') continue;

                String sqKey = (i / 3) + "," + (j / 3);
                char c = board[i][j];
                if (cols.computeIfAbsent(j, val -> new HashSet<>()).contains(c) ||
                    rows.computeIfAbsent(i, val -> new HashSet<>()).contains(c) ||
                    sq.computeIfAbsent(sqKey, val -> new HashSet<>()).contains(c)) {
                        return false;
                    }

                cols.get(j).add(c);
                rows.get(i).add(c);
                sq.get(sqKey).add(c);
            }
        }

        return true;
    }
}
