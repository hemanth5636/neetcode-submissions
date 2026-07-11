class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) count.merge(num, 1, Integer::sum);

        List<Integer>[] buckets = new List[nums.length + 1];  // index = frequency
        for (var e : count.entrySet()) {
            int f = e.getValue();
            if (buckets[f] == null) buckets[f] = new ArrayList<>();
            buckets[f].add(e.getKey());
        }

        int[] result = new int[k];
        int idx = 0;
        for (int f = nums.length; f >= 1 && idx < k; f--) {
            if (buckets[f] == null) continue;
            for (int val : buckets[f]) {
                result[idx++] = val;
                if (idx == k) break;
            }
        }
        return result;
    }
}