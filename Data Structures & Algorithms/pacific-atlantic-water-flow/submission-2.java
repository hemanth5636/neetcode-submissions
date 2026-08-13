class Solution {
    int[][] heights;
    int m;
    int n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        this.heights = heights;

        boolean[][] pac = new boolean[m][n];
        boolean[][] alt = new boolean[m][n];

        for (int row = 0; row < m; row++) {
            dfs(row, 0, pac);
            dfs(row, n - 1, alt);
        }

        for (int col = 0; col < n; col++) {
            dfs(0, col, pac);
            dfs(m - 1, col, alt);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && alt[i][j]) result.add(List.of(i, j));
            }
        }

        return result;
    }
    
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void dfs(int row, int col, boolean[][] ocean) {
        ocean[row][col] = true;

        for (int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];

            if (isValid(nr, nc) && !ocean[nr][nc] && heights[row][col] <= heights[nr][nc]) {
                dfs(nr, nc, ocean);
            }
        }
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && col >= 0 && row < m && col < n;
    }
}
