package demo;

import java.util.Arrays;

/**
 * @date 2021/11/22
 * @description 238. 除自身以外数组的乘积
 * 想法一：先算出整个数组的乘积，再除以下标对应的值，就是输出数组的值    失败，没有考虑0的问题
 * <p>
 * 参考视频完成：https://www.bilibili.com/video/BV1wA411b7qZ?p=37
 * 视频想法1：借助两个数组，分别记录左右两边的乘积，但是题目要求常数时间复杂度完成
 * 视频想法2：对想法1进行优化，不需要记录过多的内容，只要利用上到上一个数的乘积即可，左右各一遍
 */
public class _238 {
    public static int[] productExceptSelf(int[] nums) {
        int product = 1;
        int result[] = new int[nums.length];
        //主要用到下面两个式子
        //result[i] = result[i] * product
        //product = product * nums[i]
        for (int i = 0; i < nums.length; i++) {
            result[i] = 1;
        }
        //左边乘积
        for (int i = 0; i < nums.length; i++) {
            result[i] *= product;
            product = nums[i] * product;
        }
        //以下面这个数组为例，此时result={1,1,2,6}
        //          观察对比原数组nums={1,2,3,4}
        System.out.println(Arrays.toString(result));
        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= product;
            product = nums[i] * product;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums= {1,2,3,4};
        int[] ints = productExceptSelf(nums);
        System.out.println(Arrays.toString(ints));
    }
}
