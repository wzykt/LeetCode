package dp;

/**
 * @date 2022-1-23 2022-2-1完成
 * @description 474. 一和零
 * <p>
 * 01背包最值问题
 * m 和 n相当于是一个背包，两个维度的背包。
 * 1.dp[i][j]：最多有i个0和j个1的strs的最大子集的大小为dp[i][j]。
 * 2.dp[i][j] 可以由前一个strs里的字符串推导出来，strs里的字符串有zeroNum个0，oneNum个1。
 * dp[i][j] 就可以是 dp[i - zeroNum][j - oneNum] + 1。
 * 然后我们在遍历的过程中，取dp[i][j]的最大值。
 * 所以递推公式：dp[i][j] = max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
 * 3.01背包的dp数组初始化为0就可以。
 * 因为物品价值不会是负数，初始为0，保证递推的时候dp[i][j]不会被初始值覆盖。
 * 4.外层for循环遍历物品，内层for循环遍历背包容量且从后向前遍历！
 */
public class _474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < strs.length; i++) {
            int zeroNum = 0;
            int oneNum = 0;
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0') {
                    oneNum++;
                } else {
                    zeroNum++;
                }
            }

            for (int j = m; j >= zeroNum; j--) {
                for (int k = n; k >= oneNum; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeroNum][k - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
