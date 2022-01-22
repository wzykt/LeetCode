package dp;

import java.util.Arrays;

/**
 * @date 2022-1-21 2022-1-22完成
 * @description 416. 分割等和子集
 * 可以直接参考模板，readme.md中
 * 背包问题
 */
public class _416 {

    public boolean canPartition(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        int sum = 0;
        for (int s : nums) {
            sum += s;
        }
        if (sum % 2 != 0) {
            return false;
        }

        int dp[] = new int[sum / 2 + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum / 2; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[sum / 2] == sum / 2 ? true : false;
    }
/*    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false;
        }

        int target = sum / 2;

        return dfs(nums, 0, 0, target);
    }*/
//暴力递归超时
/*    private boolean dfs(int[] nums, int index, int sum, int target) {
        //base case
        if (nums.length == index) {
            if (sum == target) {
                return true;
            }
            return false;
        }

        //对于任意一个数，可与选或者不选
        return dfs(nums, index + 1, sum + nums[index], target) ||
                dfs(nums, index + 1, sum, target);
    }*/


}
