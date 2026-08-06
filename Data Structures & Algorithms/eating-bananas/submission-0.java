class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if (h < piles.length) return -1;

        int l = 1;
        int r = 0;

        for (int p : piles) {
            r = Math.max(r, p);
        }

        int res = r;
        while ( l <= r) {
            int m = l + (r - l) / 2;
            int cur = 0;
            for (int p : piles) {
                cur += p / m;
                if ( p % m != 0) cur++;
                if (cur > h) break;
            }

            if (cur <= h) res = Math.min(res, m);

            if (cur > h) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return res;
    }
}
