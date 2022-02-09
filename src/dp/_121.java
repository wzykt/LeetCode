package dp;

/**
 * @date 2022-2-9 2022-2-9参考答案完成
 * @description 121. 买卖股票的最佳时机
 *
 * https://programmercarl.com/0121.%E4%B9%B0%E5%8D%96%E8%82%A1%E7%A5%A8%E7%9A%84%E6%9C%80%E4%BD%B3%E6%97%B6%E6%9C%BA.html#%E6%80%9D%E8%B7%AF
 */
public class _121 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 0; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
        }

        return dp[prices.length - 1][1];
    }
}
