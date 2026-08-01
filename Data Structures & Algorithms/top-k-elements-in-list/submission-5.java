class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // System.out.println(freq);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[1] == b[1]) return b[0] - a[0];
                return a[1] - b[1];
            }
        );

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (pq.size() < k) {
                pq.offer(new int[]{entry.getKey(), entry.getValue()});
            } else if (pq.size() == k && pq.peek()[1] < entry.getValue()) {
                pq.poll();
                pq.offer(new int[]{entry.getKey(), entry.getValue()});
            }
        }

        int[] result = new int[k];
        // System.out.println(pq.size());
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll()[0];
        }

        return result;
    }
}
