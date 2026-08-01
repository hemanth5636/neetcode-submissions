class Solution {
    public int removeElement(int[] nums, int val) {
        int k = nums.length;
        int l = 0, r = 0;

        while (r < nums.length) {
            if (nums[r] != val) {
                nums[l++] = nums[r];
            } else {
                k--;
            }
            r++;
        }

        return k;
    }
}