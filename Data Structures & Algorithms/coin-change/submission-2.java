class Solution {
    // dp(x) = fewest coins to make exactly x
    // RR: dp(x) = min over coins c <= x of dp(x - c) + 1
    private int[] coins;
    private Integer[] mem;   // null = not computed yet
    private int IMPOSSIBLE;

    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        this.mem = new Integer[amount + 1];
        this.IMPOSSIBLE = amount + 1;   // no real answer exceeds `amount` coins

        int result = dp(amount);
        return result == IMPOSSIBLE ? -1 : result;
    }

    private int dp(int amount) {
        if (amount == 0) return 0;
        if (mem[amount] != null) return mem[amount];

        int best = IMPOSSIBLE;
        for (int c : coins) {
            if (c <= amount) {
                best = Math.min(best, dp(amount - c) + 1);
            }
        }
        mem[amount] = best;
        return best;
    }
}