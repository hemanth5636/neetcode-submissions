class Solution {
    Map<Integer, Integer> freq = new HashMap<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        backtrack(nums, new ArrayList<>());
        return result;    
    }

    private void backtrack(int[] nums, List<Integer> curr) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int k : freq.keySet()) {
            if (freq.get(k) == 0) {
                continue;
            }

            freq.put(k, freq.get(k) - 1);
            curr.add(k);
            backtrack(nums, curr);
            curr.remove(curr.size() - 1);
            freq.put(k, freq.get(k) + 1);
        }
    }
}