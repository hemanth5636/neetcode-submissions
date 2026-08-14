class Solution {
    public boolean canFinish(int nc, int[][] pre) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < nc; i++) graph.put(i, new ArrayList<>());

        for (int[] p : pre) {
            graph.get(p[0]).add(p[1]);
        }

        for (int i = 0; i < nc; i++) {
            if (isCycle(i, graph, seen)) return false;
        }

        return true;
    }

    private boolean isCycle(int node, Map<Integer, List<Integer>> graph, Set<Integer> seen) {
        if (seen.contains(node)) return true;
        if (graph.get(node).isEmpty()) return false;

        seen.add(node);

        for (int pre : graph.get(node)) {
            if (isCycle(pre, graph, seen)) return true;
        }

        seen.remove(node);
        graph.put(node, new ArrayList<>());
        return false;
    }
}
