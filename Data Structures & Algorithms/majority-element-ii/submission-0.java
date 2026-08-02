class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);

        List<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > nums.length/3) result.add(entry.getKey());
        }

        return result;
    }
}