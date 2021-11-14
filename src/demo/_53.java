package demo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @date 2021/11/13  2021/11/14完成
 * @description 属于动态规划
 * 参考视频完成：https://www.bilibili.com/video/BV1wA411b7qZ?p=11
 */
public class _53 {

    public int maxSubArray(int[] nums) {
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
    }

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
}
