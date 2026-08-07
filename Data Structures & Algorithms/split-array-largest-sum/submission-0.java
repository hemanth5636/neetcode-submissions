class Solution {
    private int[] prefix;
    private int n;

    public int splitArray(int[] nums, int k) {
        n = nums.length;
        prefix = nums;

        int l = Integer.MIN_VALUE, r = 0;
        for (int num : nums) {
            l = Math.max(l, num);
            r += num;
        }

        int res = r;
        while ( l <= r) {
            int m = l + (r - l) / 2;
            if (canSplit(m, k)) {
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return res;
    }

    private boolean canSplit(int largest, int k) {
        int subarrays = 1, curSum = 0;
        for (int num : prefix) {
            curSum += num;
            if (curSum > largest) {
                subarrays++;
                if (subarrays > k) return false;
                curSum = num;
            }
        }
        return true;
    }
}