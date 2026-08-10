class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        List<int[]> segments = new ArrayList<>();
        for (int[] trip : trips) {
            int pass = trip[0], start = trip[1], end = trip[2];
            segments.add(new int[]{start, pass});
            segments.add(new int[]{end, -pass});
        }

        segments.sort((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int currPass = 0;
        for (int[] segment : segments) {
            currPass += segment[1];
            if (currPass > capacity) {
                return false;
            }
        }

        return true;
    }
}