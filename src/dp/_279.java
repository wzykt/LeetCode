package dp;

/**
 * @date 2022-2-3 2022-2-3完成
 * @description 279. 完全平方数
 *
 *
 */
public class _279 {
    public int numSquares(int n) {
        int bag = 0;
        bag = (int) Math.sqrt(n);
        int bags[] = new int[bag];
        for (int i = 1; i * i <= n; i++) {
            bags[i - 1] = i * i;
        }
        int dp[] = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 0; i < bags.length; i++) {
            for (int j = bags[i]; j <= n; j++) {
                if (bags[i] == n) {
                    return 1;
                }
                dp[j] = Math.min(dp[j], dp[j - bags[i]] + 1);
            }
        }
        return dp[n];
    }
}
