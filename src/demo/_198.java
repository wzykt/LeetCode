package demo;

/**
 * 198. 打家劫舍
 *
 * @date 2021/11/18
 * @description 典型的dp
 *
 * 现在写的和六个月前写的还不一样，但都是暴力递归转的动态规划
 */
public class _198 {
    public int rob(int[] nums) {
        //dp
        int[] dp = new int[nums.length + 2];
        for (int i = nums.length - 1; i >= 0; i--) {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }
        return dp[0];
        //暴力返回
        //return pro(0, nums);
    }

    /*//六个月前写的
    public int rob(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N + 2];
        for (int i = N - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 2] + nums[N-i-1], dp[i + 1]);
        }
        return dp[0];
    }*/
    //暴力
    public static int pro(int index, int[] nums) {
        if (index >= nums.length) {
            return 0;
        }
        int sum = 0;
        sum = Math.max(pro(index + 2, nums) + nums[index], pro(index + 1, nums));
        return sum;
    }

}
