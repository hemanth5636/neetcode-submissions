class Solution {
    // dp(n) = max(dp(n - 2) + nums[n], dp(n - 1))
    int[] dp;
    public int rob(int[] nums) {
        
                int prev2 = 0, prev1 = 0;  // dp[i-2], dp[i-1]

        for (int num : nums) {
            int curr = Math.max(prev2 + num, prev1);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;

        // if (nums.length == 1) return nums[0];

        // dp = new int[nums.length];
        // Arrays.fill(dp, -1);
        // return dp(nums.length - 1, nums);
    }

    private int dp(int index, int[] nums) {
        if (dp[index] != -1) return dp[index];
        if (index == 0) return nums[0];
        if (index == 1) return Math.max(nums[0], nums[1]);

        dp[index] = Math.max(dp(index - 2, nums) + nums[index], dp(index - 1, nums));

        return dp[index];
    }
}
// 5, 1, 7, 11, 13, 13, 20, 22, 23, 23
