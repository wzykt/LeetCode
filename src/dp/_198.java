package dp;

/**
 * @date 2022-2-8 2022-2-8完成
 * @description 198. 打家劫舍
 *
 * 1.确定dp数组（dp table）以及下标的含义
 * dp[i]：考虑下标i（包括i）以内的房屋，最多可以偷窃的金额为dp[i]。
 * 2.确定递推公式
 * 决定dp[i]的因素就是第i房间偷还是不偷。
 * 如果偷第i房间，那么dp[i] = dp[i - 2] + nums[i] ，即：第i-1房一定是不考虑的，找出 下标i-2（包括i-2）以内的房屋，最多可以偷窃的金额为dp[i-2] 加上第i房间偷到的钱。
 * 如果不偷第i房间，那么dp[i] = dp[i - 1]，即考虑i-1房，（注意这里是考虑，并不是一定要偷i-1房，这是很多同学容易混淆的点）
 * 然后dp[i]取最大值，即dp[i] = max(dp[i - 2] + nums[i], dp[i - 1]);
 * 3.dp数组如何初始化
 * dp[0] 一定是 nums[0]，dp[1]就是nums[0]和nums[1]的最大值
 * 4.确定遍历顺序
 * 从前到后遍历
 */
public class _198 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
