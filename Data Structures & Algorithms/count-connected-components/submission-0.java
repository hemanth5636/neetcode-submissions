class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] seen = new boolean[n];
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                result++;
                dfs(i, graph, seen);
            }
        }

        return result;
    }

    private void dfs(int node, List<Integer>[] graph, boolean[] seen) {
        seen[node] = true;

        for (int ne : graph[node]) {
            if (!seen[ne]) dfs(ne, graph, seen);
        }
    }
}
