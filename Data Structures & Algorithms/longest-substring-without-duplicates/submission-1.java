class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastSeenIndex = new int[128];

        int left = 0;
        int right = 0;
        int result = 0;

        Arrays.fill(lastSeenIndex, -1);

        while (right < s.length()) {
            int curChar = s.charAt(right);

            if (lastSeenIndex[curChar] != -1 && left <= lastSeenIndex[curChar]) {
                left = lastSeenIndex[curChar] + 1;
            }

            lastSeenIndex[curChar] = right;

            
            result = Math.max(result, right - left + 1);
            // System.out.println(left + " " + right + " " + result);
            right++;
        }

        return result;
    }
}
