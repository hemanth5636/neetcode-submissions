class Solution {
    // state = dp(i) = Max money i can earn by robbing 0..i houses
    // RR : dp(i) = max(h[i] + mem[i - 2], dp(i - 1));
    // base cases dp(0) = h[0]; dp(1) = max(h[0], h[1])
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        return Math.max(dp(0, nums.length - 2, nums), 
        dp(1, nums.length - 1, nums));
    }

    private int dp(int left, int right, int[] nums) {
        
        int[] mem = new int[nums.length];

        mem[left] = nums[left];
        mem[left + 1] = Math.max(nums[left + 1], mem[left]);

        for (int i = left + 2; i <= right; i++) {
            mem[i] = Math.max(nums[i] + mem[i - 2], mem[i - 1]);
        }

        return mem[right];

    }
}
