class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        backtrack(nums, 0, target, new ArrayList<>(), 0);
        return result;
    }

    private void backtrack(int[] nums, int index, int target, List<Integer> curr, int sum) {
        if (sum == target) {
            result.add(new ArrayList<>(curr));
            return;
        }

        if (sum > target) return;

        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) continue;
            if (sum + nums[i] > target) return;
            curr.add(nums[i]);
            backtrack(nums, i + 1, target, curr, sum + nums[i]);
            curr.remove(curr.size() - 1);
        }
    }
}
