class Solution {
    private boolean[] seen;
    private List<Integer>[] graph;
    private Set<Integer> cycle;
    private int cycleStart;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        seen = new boolean[n + 1];
        cycle = new HashSet<>();

        cycleStart = -1;
        dfs(1, -1);

        for (int i = edges.length - 1; i>= 0; i--) {
            int u = edges[i][0], v = edges[i][1];
            if (cycle.contains(u) && cycle.contains(v)) {
                return new int[]{u, v};
            }
        }

        return new int[0];
    }

    private boolean dfs(int node, int parent) {
        if (seen[node]) {
            cycleStart = node;
            return true;
        }

        seen[node] = true;
        for (int ne : graph[node]) {
            if (ne == parent) continue;
            if (dfs(ne, node)) {
                if (cycleStart != -1) cycle.add(node);
                if (node == cycleStart) cycleStart = -1;
                return true;
            }
        }
        return false;
    }
}
