class Solution {
    int[][] dp;
    List<Integer>[] graph;

    public List<Boolean> checkIfPrerequisite(int nc, int[][] preq, int[][] qs) {
        dp = new int[nc][nc];
        graph = new ArrayList[nc];

        for (int i = 0; i < nc; i++) {
            graph[i] = new ArrayList<>();
            Arrays.fill(dp[i], -1);
        }

        for (int[] p : preq) {
            int prequ = p[0];
            int course = p[1];
            graph[course].add(prequ);
            dp[course][prequ] = 1;
        }

        List<Boolean> result = new ArrayList<>();
        for (int[] q : qs) {
            int course = q[1];
            int prequ = q[0];
            result.add(dfs(course, prequ));
        }

        return result;
    }

    private boolean dfs(int course, int prequisite) {
        if (dp[course][prequisite] != -1) {
            return dp[course][prequisite] == 1;
        }

        for (int pre : graph[course]) {
            if (pre == prequisite || dfs(pre, prequisite)) {
                dp[course][prequisite] = 1;
                return true;
            }
        }

        dp[course][prequisite] = 0;
        return false;
    }
}