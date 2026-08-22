class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int min = 1, max = 1;
        int result = nums[0];
        for (int num : nums) {
            int tmp = max * num;
            max = Math.max(Math.max(num * max, num * min), num);
            min = Math.min(Math.min(tmp, num * min), num);
            result = Math.max(result, max);
        }

        return result;
    }
}
