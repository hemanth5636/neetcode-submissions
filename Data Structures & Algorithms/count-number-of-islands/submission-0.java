class Solution {
    int islands = 0;
    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    islands++;
                }
            }
        }

        return islands;
    }

    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private void dfs(int row, int col, char[][] grid) {
        grid[row][col] = '0';

        for (int[] dir : dirs) {
            int nRow = row + dir[0];
            int nCol = col + dir[1];

            if (nRow < 0 || nCol < 0 || nRow >= grid.length || nCol >= grid[0].length || 
                grid[nRow][nCol] == '0') {
                    continue;
                }
            dfs(nRow, nCol, grid);
        }
    }
}
