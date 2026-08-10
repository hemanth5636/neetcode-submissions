class Solution {
    List<List<Integer>> result = new ArrayList<>();
    boolean[] seen;
    public List<List<Integer>> permute(int[] nums) {
        seen = new boolean[nums.length];
        backtrack(nums, new ArrayList<>());

        return result;
    }

    private void backtrack(int[] nums, List<Integer> curr) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!seen[i]) {
                curr.add(nums[i]);
                seen[i] = true;
                backtrack(nums, curr);
                curr.remove(curr.size() - 1);
                seen[i] = false;
            }
        }
    }
}
