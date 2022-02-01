package dp;

/**
 * @date 2022-1-22
 * @description 1049. 最后一块石头的重量 II
 * 难点在于看出这是背包问题
 * <p>
 * 问题转化为：把一堆石头分成两堆,求两堆石头重量差最小值
 * 进一步分析：要让差值小,两堆石头的重量都要接近sum/2;我们假设两堆分别为A,B,A < sum/2,B > sum/2,若A更接近sum/2,B也相应更接近sum/2
 * 进一步转化：将一堆stone放进最大容量为sum/2的背包,求放进去的石头的最大重量MaxWeight,最终答案即为sum-2*MaxWeight;
 * <p>
 * 可以直接参考模板，readme.md中
 * 套用最值模板
 */
public class _1049 {
    public int lastStoneWeightII(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        int sum = 0;
        for (int s : stones) {
            sum += s;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[target] * 2;
    }
}
