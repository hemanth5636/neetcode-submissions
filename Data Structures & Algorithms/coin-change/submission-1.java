class Solution {
    // RR : min over all coins c <= x of dp(x - c) + 1
    int[] mem;
    int[] coins;
    int max;
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        this.max = amount + 1;
        mem = new int[amount + 1];
        Arrays.fill(mem, -1);
        mem[0] = 0;
        dp(amount);

        if (mem[amount] == max) return -1;
        return mem[amount];
    }

    private int dp(int amount) {
        if (amount == 0) return 0;
        if (mem[amount] != -1) return mem[amount];

        int result = max;

        for (int c : coins) {
            if (c <= amount)
                result = Math.min(result, dp(amount - c) + 1);
        }

        mem[amount] = result;
        return result;
    }
}
