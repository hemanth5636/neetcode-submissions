class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[nums.length - 1] = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            res[i] = nums[i] * res[i + 1];
        }

        int prev = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            res[i] = res[i + 1] * prev;
            prev = prev * nums[i];
        }

        res[nums.length - 1] = prev;

        return res;
    }
}  
