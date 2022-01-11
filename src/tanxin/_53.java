package tanxin;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @date 2021/11/13  2021/11/14完成
 * @description 属于动态规划
 * 参考视频完成：https://www.bilibili.com/video/BV1wA411b7qZ?p=11
 */
public class _53 {
    //dp
    /*public int maxSubArray(int[] nums) {
        int max = 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i] + dp[i - 1], dp[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }*/

    /*
    更简单的写法s
     public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum =sum + nums[i];
            if(sum < nums[i]){
                sum =nums[i];
            }
            max = Math.max(sum,max);
        }
        return max;
    }
     */

    //贪心写法
    //局部最优：当前“连续和”为负数的时候立刻放弃，从下一个元素重新计算“连续和”，因为负数加上下一个元素 “连续和”只会越来越小。
    public int maxSubArray(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int sum = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            count += nums[i];
            sum = Math.max(sum, count); // 取区间累计的最大值（相当于不断确定最大子序终止位置）
            if (count <= 0){
                count = 0; // 相当于重置最大子序起始位置，因为遇到负数一定是拉低总和
            }
        }
        return sum;
    }

}
