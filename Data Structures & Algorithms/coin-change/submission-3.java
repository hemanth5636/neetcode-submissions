class Solution {
    // state : dp(i) = min numbers of coins to reach i amount
    // RR : dp(i) = for all coins min (1 + dp(i - coin))
    // base case dp(0) = 0;
    Integer[] dp;
    Integer inf;
    public int coinChange(int[] coins, int amount) {
        dp = new Integer[amount + 1];
        inf = amount + 1;
        int res = dp(coins, amount);
        return res == inf ? -1 : res;
    }

    private Integer dp(int[] coins, Integer remaing) {
        if (remaing == 0) return 0;
        
        if (dp[remaing] != null) return dp[remaing];

        Integer count = inf;

        for (int coin : coins) {
            if (remaing >= coin) {
                count = Math.min(count, dp(coins, remaing - coin) + 1);
            }
        }
        dp[remaing] = count;
        return count;
    }
}
