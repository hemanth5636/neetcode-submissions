class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] tmp = Arrays.copyOf(dist, n);
            for (int[] flight : flights) {
                int s = flight[0];
                int d = flight[1];
                int p = flight[2];

                if (dist[s] != Integer.MAX_VALUE) {
                    tmp[d] = Math.min(tmp[d], dist[s] + p);
                }
            }

            dist = tmp;
        }
        if (dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}
