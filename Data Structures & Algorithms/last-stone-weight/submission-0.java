class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });

        for (int i = 0; i < stones.length; i++) pq.add(stones[i]);

        while (pq.size() > 1) {
            int a = pq.poll();
            // System.out.println(a);
            if (a == pq.peek()) {
                pq.poll();
            } else {
                pq.offer(a - pq.poll());
            }
        }

        return (pq.isEmpty()) ? 0 : pq.peek();
    }
}
