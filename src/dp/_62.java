package dp;

/**
 * @date 2022-1-18
 * @description 62. 不同路径
 * <p>
 * 1、dp[i][j] ：表示从（0 ，0）出发，到(i, j) 有dp[i][j]条不同的路径。
 * 2、想要求dp[i][j]，只能有两个方向来推导出来，即dp[i - 1][j] 和 dp[i][j - 1]。
 * dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
 * 3、首先dp[i][0]一定都是1，因为从(0, 0)的位置到(i, 0)的路径只有一条，那么dp[0][j]也同理
 * for (int i = 0; i < m; i++) dp[i][0] = 1;
 * for (int j = 0; j < n; j++) dp[0][j] = 1;
 * 4、从左到右一层一层遍历
 */
public class _62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
