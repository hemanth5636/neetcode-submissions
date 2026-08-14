class Solution {
    List<Integer> result = new ArrayList<>();
    public int[] findOrder(int nc, int[][] pre) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> cycle = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        
        for (int i = 0; i < nc; i++) graph.put(i, new ArrayList<>());

        for (int[] p : pre) {
            graph.get(p[0]).add(p[1]);
        }

        for (int i = 0; i < nc; i++) {
            if (isCycle(i, graph, seen, cycle)) return new int[]{};
        }

        int[] r = new int[nc];
        for (int i = 0; i < nc; i++) {
            r[i] = result.get(i);
        }

        return r;
    }

    private boolean isCycle(int node, Map<Integer, List<Integer>> graph, Set<Integer> seen, Set<Integer> cycle) {
        if (cycle.contains(node)) return true;
        if (seen.contains(node)) return false;

        cycle.add(node);

        for (int pre : graph.get(node)) {
            if (isCycle(pre, graph, seen, cycle)) return true;
        }

        cycle.remove(node);
        seen.add(node);
        result.add(node);
        return false;
    }
}
