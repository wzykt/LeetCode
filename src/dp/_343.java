package dp;

/**
 * @date 2022-1-18 2022-1-19完成
 * @description 343. 整数拆分
 *
 * 递推公式：dp[i] = max({dp[i], (i - j) * j, dp[i - j] * j});
 *
 * 具体参考https://programmercarl.com/0343.%E6%95%B4%E6%95%B0%E6%8B%86%E5%88%86.html#%E6%80%9D%E8%B7%AF
 * 不是很会推这个递推公式
 */
public class _343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
