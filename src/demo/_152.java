package demo;

/**
 * @date 2021/11/13 2021/11/14完成
 * @description 152. 乘积最大子数组
 * 参考视频完成：https://www.bilibili.com/video/BV1wA411b7qZ?p=28
 * 此题目可以参考leetcode 53，可以作为延申
 * 乘法存在负负得正的情况，所以不仅要记录最大值，还要记录最小值，一定是最小值
 */
public class _152 {
    public int maxProduct(int[] nums) {
        int minProduct[] = new int[nums.length];
        int maxProduct[] = new int[nums.length];
        minProduct[0] = nums[0];
        maxProduct[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxProduct[i] = Math.max(Math.max(nums[i], maxProduct[i - 1] * nums[i]), Math.max(nums[i], minProduct[i - 1] * nums[i]));
            minProduct[i] = Math.min(Math.min(nums[i], maxProduct[i - 1] * nums[i]), Math.min(nums[i], minProduct[i - 1] * nums[i]));
            res = Math.max(res, maxProduct[i]);
        }
        return res;
    }
}
