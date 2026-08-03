class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);

        int l = 0;
        int r = 0;
        int result = 0;

        while (r < s.length()) {
            int index = s.charAt(r);

            if (lastSeen[index] != -1 && l <= lastSeen[index]) {
                l = lastSeen[index] + 1;
            }

            lastSeen[index] = r;

            result = Math.max(result, r - l + 1);

            r++;
        }

        return result;
    }
}
