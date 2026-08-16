class Solution {
    public int minCostConnectPoints(int[][] points) {
        if (false) {
            return kruskals(points);
        }

        return prims(points);
    }

    private int prims(int[][] points) {
        int n = points.length;

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });

        boolean[] inMST = new boolean[n];

        heap.add(new int[]{0, 0});
        int mstCost = 0;
        int edgesUsed = 0;

        while (edgesUsed < n) {
            int[] topElement = heap.poll();

            int weight = topElement[0];
            int currNode = topElement[1];

            if (inMST[currNode]) continue;

            inMST[currNode] = true;
            mstCost += weight;
            edgesUsed++;

            for (int nextNode = 0; nextNode < n; nextNode++) {
                if (!inMST[nextNode]) {
                    int nextWeight = Math.abs(points[currNode][0] - points[nextNode][0]) +
                                     Math.abs(points[currNode][1] - points[nextNode][1]);
                    
                    heap.add(new int[]{nextWeight, nextNode});
                }
            }
        }

        return mstCost;
    }

    // Base also, first sort all edges based on their weights then process min edges one by one
    // when processing a edge, make sure there are no cycles, repeat this util n - 1 edges are 
    // formed to connect all the nodes.
    // T : (N2 * log(N))
    // S : N2
    private int kruskals(int[][] points) {
        int n = points.length;
        ArrayList<int[]> allEdges = new ArrayList<>();

        for (int currNext = 0; currNext < n; currNext++) {
            for (int nextNext = currNext + 1; nextNext < n; nextNext++) {
                int weight = Math.abs(points[currNext][0] - points[nextNext][0]) + 
                             Math.abs(points[currNext][1] - points[nextNext][1]);
                
                int[] currEdge = {weight, currNext, nextNext};
                allEdges.add(currEdge);
            }
        }

        Collections.sort(allEdges, (a, b) -> Integer.compare(a[0], b[0]));

        UnionFind uf = new UnionFind(n);
        int mstCost = 0;
        int edgesUsed = 0;

        for (int i = 0; i < allEdges.size() && edgesUsed < n - 1; i++) {
            int node1 = allEdges.get(i)[1];
            int node2 = allEdges.get(i)[2];
            int weight = allEdges.get(i)[0];

            if (uf.union(node1, node2)) {
                mstCost += weight;
                edgesUsed++;
            }
        }

        return mstCost;
    }
}

class UnionFind {
    int[] root;
    int[] rank;

    public UnionFind(int n) {
        root = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
    }

    public int find(int node) {
        if (root[node] != node) {
            root[node] = find(root[node]);
        }

        return root[node];
    }

    public boolean union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);

        if (root1 == root2) return false;

        if (rank[root1] > rank[root2]) {
            root[root2] = root1;
        } else if (rank[root2] > rank[root1]) {
            root[root1] = root2;
        } else {
            root[root2] = root1;
            rank[root1]++;
        }

        return true;
    }
}