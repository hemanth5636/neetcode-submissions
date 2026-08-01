class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];

        int maxLen = Integer.MAX_VALUE;

        for (String s : strs) {
            maxLen = Math.min(maxLen, s.length());
        }

        String a = strs[0];
        // System.out.println(maxLen);
        for (int i = 1; i < strs.length; i++) {
            for (int index = 0; index < maxLen; index++) {
                if (a.charAt(index) != strs[i].charAt(index)) {
                    maxLen = index;
                    break;
                }
            }
        }

        if (maxLen == -1) return "";
        // System.out.println(maxLen);
        return a.substring(0, maxLen);
    }
}