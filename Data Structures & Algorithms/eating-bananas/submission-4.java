class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;
        for (int p : piles) r = Math.max(r, p);

        while (l < r) {
            int m = l + (r - l) / 2;
            long hours = 0;
            for (int p : piles) {
                hours += p / m;
                if (p % m != 0) hours++;
                if (hours > h) break;
            }
            if (hours <= h) r = m;
            else l = m + 1;
        }
        return l;
    }
}