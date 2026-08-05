class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result = nums.length + 1;
        int l = 0;
        int r = 0;
        int windowSum = 0;

        while (r < nums.length) {
            windowSum += nums[r];

            while (l <= r && windowSum >= target) {
                result = Math.min(result, r - l + 1);
                windowSum -= nums[l];
                l++;
            }

            r++;
        }

        return result == nums.length + 1 ? 0 : result;
    }
}