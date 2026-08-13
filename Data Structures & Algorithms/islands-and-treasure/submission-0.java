class Solution {
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int m;
    int n;
    public void islandsAndTreasure(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        boolean[][] seen = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[]{i, j, 0});
                    seen[i][j] = true;
                } else if (grid[i][j] == -1) seen[i][j] = true;
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();

                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    if (isValid(nr, nc) && !seen[nr][nc] && grid[nr][nc] == Integer.MAX_VALUE) {
                        grid[nr][nc] = curr[2] + 1;
                        q.offer(new int[]{nr, nc, curr[2] + 1});
                    }
                }

            }
        }
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && col >= 0 && row < m && col < n;
    }
}
