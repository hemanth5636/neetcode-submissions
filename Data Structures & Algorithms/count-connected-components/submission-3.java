class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        int result = n;

        for (int[] edge : edges) {
            if (uf.union(edge[0], edge[1])) {
                result--;
            }
        }

        return result;
    }
}

class UnionFind {
    int[] group;
    int[] rank;

    public UnionFind(int n) {
        this.group = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n; i++) group[i] = i;
    }

    public int find(int x) {
        if (x != group[x]) {
            group[x] = find(group[x]);
        }

        return group[x];
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return false;

        if (rank[rootX] > rank[rootY]) {
            group[rootY] = rootX;
        } else if (rank[rootY] > rank[rootX]) {
            group[rootX] = rootY;
        } else {
            group[rootY] = rootX;
            rank[rootX]++;
        }

        return true;
    }
}
