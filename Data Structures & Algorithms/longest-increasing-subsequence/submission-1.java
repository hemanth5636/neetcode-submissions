class Solution {
    public int lengthOfLIS(int[] nums) {
        return optimized(nums);
        // int[] dp = new int[nums.length];
        // Arrays.fill(dp, 1);

        // for (int i = 1; i < nums.length; i++) {
        //     for (int j = 0; j < i; j++) {
        //         if (nums[j] < nums[i]) {
        //             dp[i] = Math.max(dp[i], dp[j] + 1);
        //         }
        //     }
        // }

        // int result = 0;
        // for (int num : dp) result = Math.max(num, result);

        // return result;
    }

    private int optimized(int[] nums) {
        List<Integer> result = new ArrayList<>();
        result.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (result.get(result.size() - 1) < nums[i]) {
                result.add(nums[i]);
            } else {
                int l = 0;
                int r = result.size() - 1;
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if (nums[i] > result.get(mid)) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                result.set(l, nums[i]);
            }
        }

        return result.size();
    }
}
