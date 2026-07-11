class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];

        if (s.length() != t.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            int sIndex = s.charAt(i) - 'a';
            int tIndex = t.charAt(i) - 'a';
            freq[sIndex]++;
            freq[tIndex]--;
        }

        for (int count : freq) {
            if (count != 0) return false;
        }

        return true;
    }
}
