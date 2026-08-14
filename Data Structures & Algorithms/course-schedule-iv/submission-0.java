class Solution {
    private List<Integer>[] graph;
    private Map<Integer, Set<Integer>> preqMap;

    public List<Boolean> checkIfPrerequisite(int nc, int[][] preq, int[][] queries) {

        graph = new ArrayList[nc];    
        preqMap = new HashMap<>();

        for (int i = 0; i < nc; i++) graph[i] = new ArrayList<>();
        for (int[] pre : preq) graph[pre[1]].add(pre[0]);

        for (int i = 0; i < nc; i++) dfs(i);

        List<Boolean> res = new ArrayList<>();
        for (int[] q : queries) {
            res.add(preqMap.get(q[1]).contains(q[0]));
        }

        return res;
    }

    private Set<Integer> dfs(int crs) {
        if (preqMap.containsKey(crs)) return preqMap.get(crs);

        Set<Integer> preReqs = new HashSet<>();

        for (int pre : graph[crs]) {
            preReqs.addAll(dfs(pre));
        }

        preReqs.add(crs);
        preqMap.put(crs, preReqs);
        return preReqs;
    }
}