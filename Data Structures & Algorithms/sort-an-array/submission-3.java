class Solution {
    public int[] sortArray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int n = max - min;
        int[] freq = new int[n + 1];

        for (int num : nums) {
            freq[num - min]++;
        }

        int l = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                for (int j = 0; j < freq[i]; j++) {
                    nums[l++] = i + min;
                }
            }
        }

        return nums;
    }
}