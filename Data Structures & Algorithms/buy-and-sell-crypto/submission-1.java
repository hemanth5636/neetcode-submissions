class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int left = 0;
        int right = 1;

        while (right < prices.length) {
            while (left < right && prices[left] > prices[right]) left++;

            if (left != right) {
                result = Math.max(result, prices[right] - prices[left]);
            }
            right++;
        }

        return result;
    }
}
