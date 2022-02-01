package dp;

/**
 * @date 2022-1-23 2022-1-23完成
 * @description 494. 目标和
 * <p>
 * 本题要如何使表达式结果为target，
 * 既然为target，那么就一定有 left组合 - right组合 = target。
 * left + right等于sum，而sum是固定的。
 * 公式来了， left - (sum - left) = target -> left = (target + sum)/2 。
 * target是固定的，sum是固定的，left就可以求出来。
 * 此时问题就是在集合nums中找出和为left的组合。
 * <p>
 * 此时问题就转化为，装满容量为left背包，有几种方法。
 * 1、dp[j] 表示：填满j（包括j）这么大容积的包，有dp[j]种方法
 * 2、递推公式：状态转移方程dp[j] += dp[j - nums[i]]
 * 3、dp[0] = 1，理论上也很好解释，装满容量为0的背包，有1种方法，就是装0件物品。
 * 4、nums放在外循环，target在内循环，且内循环倒序。
 *
 * 递推公式也是模板，组合模板
 * <p>
 * 将此题和1049，416一起看
 */
public class _494 {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 此时没有方案
        if ((sum + target) % 2 == 1) {
            return 0;
        }
        //target 大于数组之和，是没有结果的
        if (Math.abs(target) > sum) return 0;

        int[] dp = new int[(sum + target) / 2 + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = (sum + target) / 2; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }

        return dp[(sum + target) / 2];
    }

    //深搜
    /*public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0, 0);
    }

    public int dfs(int[] nums, int target, int index, int sum) {
        if (index == nums.length && sum == target) {
            return 1;
        }
        if (index == nums.length) {
            return 0;
        }
        return dfs(nums, target, index + 1, sum + nums[index]) + dfs(nums, target, index + 1, sum - nums[index]);
    }*/
}
