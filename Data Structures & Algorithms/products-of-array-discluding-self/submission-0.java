class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] right = new int[n + 1];
        right[right.length - 1] = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i];
        }

        int left = 1;

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = left * right[i + 1];
            left = left * nums[i];
        }

        return result;
    }
}  
