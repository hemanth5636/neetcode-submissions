class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Integer, Integer> freq = new HashMap<>();
        int l = 0;
        int r = 0;

        for (int i = 0; i < s1.length(); i++) {
            int index = s1.charAt(i);
            freq.put(index, freq.getOrDefault(index, 0) + 1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        int charCount = s1.length();

        while (r < s2.length()) {
            int curChar = s2.charAt(r);

            if (!freq.containsKey(curChar)) {
                map.clear();
                l = r + 1;
            } else if (freq.get(curChar) < map.getOrDefault(curChar, 0) + 1) {
                // System.out.println("a " + l + " " + r);
                int lIndex = s2.charAt(l);
                while (l < r) {
                    map.put(lIndex, map.get(lIndex) - 1);
                    l++;
                    if (lIndex == curChar) break;
                }
                map.put(curChar, map.getOrDefault(curChar, 0) + 1);
                // System.out.println("a " + l + " " + r);
            } else {
                // System.out.println(map.size());

                map.put(curChar, map.getOrDefault(curChar, 0) + 1);
                if (r - l + 1 == s1.length()) {
                    // System.out.println(l + " " + r);
                    return true;
                }
            }
            r++;
        }

        return false;
    }
}
