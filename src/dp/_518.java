package dp;

/**
 * @date 2022-2-1
 * @description 518. 零钱兑换 II
 * <p>
 * 完全背包组合问题
 * <p>
 * 1.dp[j]：凑成总金额j的货币组合数为dp[j]
 * 2.dp[j] += dp[j - coins[i]];
 * 3.dp[0]一定要为1，dp[0] = 1是 递归公式的基础。
 * 从dp[i]的含义上来讲就是，凑成总金额0的货币组合数为1。
 * 4.外层for循环遍历物品（钱币），内层for遍历背包（金钱总额）
 */
public class _518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount ; j++) {
                dp[j] =  dp[j - coins[i]] + dp[j];
            }
        }
        return dp[amount];
    }
}
