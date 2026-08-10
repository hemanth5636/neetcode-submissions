class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> curr) {
        result.add(new ArrayList<>(curr));
        if (index == nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }

            curr.add(nums[i]);
            backtrack(nums, i + 1, curr);
            curr.remove(curr.size() - 1);
        }

    }
}
