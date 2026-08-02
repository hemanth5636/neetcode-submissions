class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            threeSum(i, nums, result, target);
        }

        return result;
    }

    private void threeSum(int i, int[] nums, List<List<Integer>> result, int target) {

        for (int j = i + 1; j < nums.length; j++) {
            if (j != i + 1 && nums[j] == nums[j - 1]) continue;
            twoSum(i, j, nums, result, target);
        }
    }

    private void twoSum(int i, int j, int[] nums, List<List<Integer>> result, int target) {
        int l = j + 1;
        int r = nums.length - 1;

        while (l < r) {
            long sum = (long)nums[i] + (long)nums[j] + (long)nums[l] + (long)nums[r];

            if (sum == target) {
                result.add(List.of(nums[i], nums[j], nums[l], nums[r]));
                l++;
                r--;
                while (l < r && nums[l] == nums[l - 1]) l++;
                while (l < r && nums[r] == nums[r + 1]) r--;
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
    }
}