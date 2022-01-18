package dp;

/**
 * @date 2022-1-18
 * @description 746. 使用最小花费爬楼梯
 *
 * 1、dp[i]的定义：到达第i个台阶所花费的最少体力为dp[i]。
 * 2、递推公式，状态转移方程dp[i] = min(dp[i - 1], dp[i - 2]) + cost[i];
 * 3、dp[1] = cost[0];
 *   dp[2] = cost[1];
 * 4、从前到后遍历
 */
public class _746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[1] = cost[0];
        dp[2] = cost[1];
        for (int i = 3; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i-1];
        }
        //最后一步，如果是由倒数第二步爬，则最后一步的体力花费可以不用算
        return Math.min(dp[cost.length], dp[cost.length - 1]);
    }
}
