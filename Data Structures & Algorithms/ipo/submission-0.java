class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> minCap = new PriorityQueue<>((a, b) -> capital[a] - capital[b]);
        PriorityQueue<Integer> maxP = new PriorityQueue<>((a, b) -> profits[b] - profits[a]);

        for (int i = 0; i < capital.length; i++) {
            minCap.offer(i);
        }

        for (int i = 0; i < k; i++) {
            while (!minCap.isEmpty() && capital[minCap.peek()] <= w) {
                maxP.offer(minCap.poll());
            }

            if (maxP.isEmpty()) break;

            w += profits[maxP.poll()];
        }

        return w;
    }
}