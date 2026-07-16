class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);   
        }

        boolean[] seen = new boolean[n];

        if (isCycle(0, -1, graph, seen)) return false;

        for (boolean s : seen)
            if (!s) return false;
        
        return true;
    }

    private boolean isCycle(int node, int parent, List<Integer>[] graph, boolean[] seen) {
        seen[node] = true;
        
        for (int ne : graph[node]) {
            if (ne == parent) continue;
            if (seen[ne]) return true;
            if (isCycle(ne, node, graph, seen)) return true;
        }

        return false;
    }
}
