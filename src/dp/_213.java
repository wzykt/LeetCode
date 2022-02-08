package dp;

import java.util.Arrays;

/**
 * @date 2022-2-8 2022-2-8完成
 * @description 213. 打家劫舍 II
 * <p>
 * 以把此环状排列房间问题约化为两个单排排列房间子问题
 * 1.不偷窃第一个房子的情况
 * 2.不偷窃最后一个房子的情况下
 * 3.综合偷窃最大金额： 为以上两种情况的较大值
 *
 * dp[n]dp[n] 只与 dp[n-1]dp[n−1] 和 dp[n-2]dp[n−2] 有关系，因此我们可以设两个变量 cur和 pre 交替记录，将空间复杂度降到 O(1)O(1) 。
 *
 */
public class _213 {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }
    private int myRob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for(int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }
}
