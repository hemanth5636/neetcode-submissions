class Solution {
    int[] mem;
    String s;
    public int numDecodings(String s) {
        this.mem = new int[s.length()];
        this.s = s;
        Arrays.fill(mem, -1);

        return dp(0);
    }

    private int dp(int index) {
        if (index == s.length()) return 1;
        if (s.charAt(index) == '0') return 0;

        if (mem[index] != -1) return mem[index];

        int total = dp(index + 1);

        if (index + 1 < s.length()) {
            int twoDigits = (s.charAt(index) - '0') * 10 + (s.charAt(index + 1) - '0');
            if (twoDigits <= 26)
                total += dp(index + 2);
        }

        mem[index] = total;
        return total;
    }
}
