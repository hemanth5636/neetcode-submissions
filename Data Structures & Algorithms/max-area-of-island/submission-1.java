class Solution {
    int m;
    int n;
    public int maxAreaOfIsland(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    result = Math.max(result, 1 + dfs(i, j, grid));
                }
            }
        }

        return result;
    }

    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private int dfs(int row, int col, int[][] grid) {
        
        grid[row][col] = 0;

        int result = 0;

        for (int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];

            if (nr < 0 || nc < 0 || nr >= m || nc >= n || grid[nr][nc] == 0) continue;

            result += 1 + dfs(nr, nc, grid);
        }

        return result;
    }
}
