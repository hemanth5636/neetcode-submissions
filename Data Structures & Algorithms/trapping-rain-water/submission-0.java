class Solution {
    public int trap(int[] h) {
        int result = 0;
        int l = 0;
        int r = h.length - 1;

        int leftMax = h[l];
        int rightMax = h[r];

        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, h[l]);
                result += leftMax - h[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, h[r]);
                result += rightMax - h[r];
            }
        }

        return result;
    }
}
