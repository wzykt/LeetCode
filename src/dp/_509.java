package dp;

/**
 * 509斐波那契数
 *
 * @date 2021/8/23
 * @description 动态规划去做，不使用暴力递归
 *
 * 1、dp[i]表示第i个数对应的斐波那契数
 * 2、递推公式，状态转移方程 dp[i] = dp[i - 1] + dp[i - 2];
 * 3、数组初始化 dp[0]=0,dp[1]=1;
 * 4、遍历顺序
 * 从递归公式dp[i] = dp[i - 1] + dp[i - 2];中可以看出，dp[i]是依赖 dp[i - 1] 和 dp[i - 2]，那么遍历的顺序一定是从前到后遍历的
 */
public class _509 {
    public static int fib(int n) {

        if (n < 2) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
        //暴力递归
//        if(n == 1){
//            return 1;
//        }
//        if(n == 0){
//            return 0;
//        }
//        return fib(n-1)+fib(n-2);
    }

    public static void main(String[] args) {
        System.out.println(fib(4));
    }
}
