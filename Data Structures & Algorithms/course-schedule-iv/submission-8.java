class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] adj = new boolean[numCourses][numCourses];
        List<Boolean> result = new ArrayList<>();

        for (int[] pre : prerequisites) {
            adj[pre[0]][pre[1]] = true;
        }

        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    adj[i][j] = adj[i][j] || (adj[i][k] && adj[k][j]);
                }
            }
        }

        for (int[] q : queries) {
            result.add(adj[q[0]][q[1]]);
        }

        return result;
    }
}