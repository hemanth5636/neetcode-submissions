class Solution {
    int m, n;
    int[][] grid;

    public int swimInWater(int[][] grid) {
        int r = Integer.MIN_VALUE;
        int l = Integer.MAX_VALUE;
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                l = Math.min(l, grid[i][j]);
                r = Math.max(r, grid[i][j]);
            }
        }
        
        boolean[][] visited = new boolean[m][n];
        int result = r;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (dfs(0, 0, m, visited)) {
                r = m;
            } else {
                l = m + 1;
            }

            for (int i = 0; i < n; i++) {
                Arrays.fill(visited[i], false);
            }
        }

        return r;
    }

    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private boolean dfs(int row, int col, int maxDiff, boolean[][] visited) {
        if (!isValid(row, col) || visited[row][col] || grid[row][col] > maxDiff)
            return false;
        
        if (row == m - 1 && col == n - 1) return true;

        visited[row][col] = true;

        return dfs(row + 1, col, maxDiff, visited) ||
        dfs(row, col + 1, maxDiff, visited) ||
        dfs(row, col - 1, maxDiff, visited) ||
        dfs(row - 1, col, maxDiff, visited);
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && col >= 0 && row < m && col < n;
    }
}
