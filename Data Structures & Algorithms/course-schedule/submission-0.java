class Solution {
    public boolean canFinish(int nc, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        HashSet<Integer> visiting = new HashSet<>();
        for (int i = 0; i < nc; i++) graph.put(i, new ArrayList<>());
        for (int[] pre : prerequisites) {
            graph.get(pre[0]).add(pre[1]);
        }

        for (int i = 0; i < nc; i++) {
            if (isCycle(i, graph, visiting))
                return false;
        }

        return true;
    }

    private boolean isCycle(int node, Map<Integer, List<Integer>> graph, Set<Integer> visiting) {
        if (visiting.contains(node)) return true;

        if (graph.get(node).isEmpty()) return false;

        visiting.add(node);

        for (int pre : graph.get(node)) {
            if (isCycle(pre, graph, visiting))
                return true;
        }

        visiting.remove(node);
        graph.put(node, new ArrayList<>());
        return false;
    }
}
