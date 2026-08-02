class Solution {
    public int maxArea(int[] h) {
        int result = 0;
        int l = 0;
        int r = h.length - 1;

        while (l < r) {
            int cur = Math.min(h[l], h[r]) * (r - l);
            result = Math.max(result, cur);

            if (h[l] < h[r]) l++;
            else r--;
        }

        return result;
    }
}
