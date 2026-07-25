class Solution {
    Set<String> dict;
    Boolean[] mem;
    int maxLen = 0;
    String s;

    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        mem = new Boolean[s.length()];
        dict = new HashSet<>(wordDict);
        for (String ss : wordDict) maxLen = Math.max(maxLen, ss.length());

        return dp(0);
    }

    private boolean dp(int index) {
        if (index >= s.length()) return true;

        if (mem[index] != null) return mem[index];

        for (int i = index; i < s.length() && index - i + 1 <= maxLen; i++) {
            if (dict.contains(s.substring(index, i + 1)) && dp(i + 1)) {
                mem[index] = true;
                return true;
            }
        }

        mem[index] = false;
        return false;
    }
}
