class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n < 2) {
            for (int i = 0; i < n; i++) {
                result.add(i);
            }

            return result;
        }
        List<Integer>[] adjList = new ArrayList[n];

        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            adjList[src].add(dest);
            adjList[dest].add(src);
        }

        for (int i = 0; i < n; i++) {
            if (adjList[i].size() == 1) result.add(i);
        }

        int remaining = n;

        while (remaining > 2) {
            remaining -= result.size();
            List<Integer> nn = new ArrayList<>();

            for (Integer leaf : result) {
                int parent = adjList[leaf].get(0);
                adjList[parent].remove(leaf);
                if (adjList[parent].size() == 1) nn.add(parent);
            }

            result = nn;
        }

        return result;
    }
}