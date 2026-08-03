class Solution {
    public int characterReplacement(String s, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int l = 0;
        int r = 0;

        int result = 0;
        int maxF = 0;

        while (r < s.length()) {
            int key = s.charAt(r);
            freq.put(key, freq.getOrDefault(key, 0) + 1);
            maxF = Math.max(maxF, freq.get(key));

            while (r - l + 1 - maxF > k) {
                int lc = s.charAt(l);
                freq.put(lc, freq.get(lc) - 1);
                l++;
            }

            result = Math.max(result, r - l + 1);
            r++;
        }

        return result;
    }
}
