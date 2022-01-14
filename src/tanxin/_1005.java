package tanxin;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @date 2022-1-13 2022-1-13完成
 * @description 1005. K 次取反后最大化的数组和
 * 贪心的思路，局部最优：让绝对值大的负数变为正数，当前数值达到最大，整体最优：整个数组和达到最大。
 * 局部最优可以推出全局最优。
 * 那么如果将负数都转变为正数了，K依然大于0，此时的问题是一个有序正整数序列，如何转变K次正负，让 数组和 达到最大。
 * 那么又是一个贪心：局部最优：只找数值最小的正整数进行反转，当前数值可以达到最大（例如正整数数组{5, 3, 1}，反转1 得到-1 比 反转5得到的-5 大多了），全局最优：整个 数组和 达到最大。
 *
 * 那么本题的解题步骤为：
 *
 * 第一步：将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
 * 第二步：从前向后遍历，遇到负数将其变为正数，同时K--
 * 第三步：如果K还大于0，那么反复转变数值最小的元素，将K用完
 * 第四步：求和
 */
public class _1005 {
    //暴力解法
    /*public int largestSumAfterKNegations(int[] nums, int k) {
        while (k >= 0) {
            Arrays.sort(nums);
            nums[0] = -nums[0];
            k--;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }*/

    //贪心解法，两次贪心
    public int largestSumAfterKNegations(int[] nums, int K) {
        // 将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //从前向后遍历，遇到负数将其变为正数，同时K--
            if (nums[i] < 0 && K > 0) {
                nums[i] = -nums[i];
                K--;
            }
        }
        // 如果K还大于0，那么反复转变数值最小的元素，将K用完

        if (K % 2 == 1) nums[len - 1] = -nums[len - 1];
        return Arrays.stream(nums).sum();
    }
}
