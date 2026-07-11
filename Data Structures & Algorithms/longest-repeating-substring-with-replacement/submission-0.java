class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        
        int left = 0;
        int right = 0;
        int result = 0;
        int maxF = 0;
        while (right < s.length()) {
            char c  = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxF = Math.max(maxF, map.get(c));

            while (right - left + 1 - maxF > k) {
                char lc = s.charAt(left);
                map.put(lc, map.get(lc) - 1);
                left++;
            }

            result = Math.max(result, right - left + 1);
            right++;
        }

        return result;
    }
}
