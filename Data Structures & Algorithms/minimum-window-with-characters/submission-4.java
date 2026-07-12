class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tFreq = new HashMap<>();

        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> sFreq = new HashMap<>();

        int remain = t.length();

        int left = 0;
        int right = 0;
        int resultLen = Integer.MAX_VALUE;

        String result = "";

        while (right < s.length()) {
            char currChar = s.charAt(right);

            if (tFreq.containsKey(currChar)) {
                sFreq.put(currChar, sFreq.getOrDefault(currChar, 0) + 1);

                if (tFreq.get(currChar) >= sFreq.get(currChar)) {
                    remain--;
                }

                while (left <= right && remain == 0) {
                    int wl = right - left + 1;
                    if (remain == 0 && wl < resultLen) {
                        resultLen = wl;
                        result = s.substring(left, right + 1);
                    }
                    char lc = s.charAt(left++);
                    if (tFreq.containsKey(lc)) {
                        sFreq.put(lc, sFreq.get(lc) - 1);
                        if (tFreq.get(lc) > sFreq.get(lc)) {
                            remain++;
                        }
                    }
                }
            }    

            right++;
        }

        return result;
    }
}
