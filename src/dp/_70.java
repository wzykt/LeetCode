package dp;

/**
 * @date 2022-1-18
 * @description 70. 爬楼梯
 *
 * 1、dp[i]： 爬到第i层楼梯，有dp[i]种方法
 * 2、递推公式，从dp[i]的定义可以看出，dp[i] 可以有两个方向推出来。
 * 首先是dp[i - 1]，上i-1层楼梯，有dp[i - 1]种方法，那么再一步跳一个台阶不就是dp[i]了么。
 * 还有就是dp[i - 2]，上i-2层楼梯，有dp[i - 2]种方法，那么再一步跳两个台阶不就是dp[i]了么。
 * 那么dp[i]就是 dp[i - 1]与dp[i - 2]之和！
 * 所以dp[i] = dp[i - 1] + dp[i - 2] 。
 * 在推导dp[i]的时候，一定要时刻想着dp[i]的定义，否则容易跑偏。
 * 3、初始化，dp[1]=1和dp[2]=2是显而易见的，就从3开始
 * 4、从递推公式dp[i] = dp[i - 1] + dp[i - 2];中可以看出，遍历顺序一定是从前向后遍历的
 */
public class _70 {
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] +dp[i-2];
        }
        return dp[n];
    }
}
