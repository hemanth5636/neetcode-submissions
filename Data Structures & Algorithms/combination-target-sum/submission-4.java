class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        backtrack(nums, 0, target, new ArrayList<>(), 0);
        return result;
    }

    private void backtrack(int[] nums, int index, int target, List<Integer> curr, int currSum) {
        if (currSum == target) {
            result.add(new ArrayList<>(curr));
            return;
        }

        if (currSum > target) return;

        for (int i = index; i < nums.length; i++) {
            if (currSum + nums[index] > target) return;
            curr.add(nums[i]);
            backtrack(nums, i, target, curr, currSum + nums[i]);
            curr.remove(curr.size() - 1);
        }
    }
}
