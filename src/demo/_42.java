package demo;

/**
 * 42. 接雨水
 *
 * @date 2021/9/25
 * @description 目前想的是如果一个节点左右两边都比当前节点的值大，算一个凹陷。   没写出来
 * <p>
 * 参考答案 ：https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
 * 参考解法二:按列求，及只看当前列上是否能够存水 时间复杂度O(n²）
 */
public class _42 {
    public int trap(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int leftMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }

            int rightMax = 0;
            for (int j = i + 1; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            int min = Math.min(leftMax, rightMax);
            if (height[i] < min) {
                sum += min - height[i];
            }
        }
        return sum;
    }
//    提前维护每一列左右两侧最大，可以避免每次的遍历一次求两侧最高
//    public int trap(int[] height) {
//        int sum = 0;
//        int[] max_left = new int[height.length];
//        int[] max_right = new int[height.length];
//
//        for (int i = 1; i < height.length - 1; i++) {
//            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
//        }
//        for (int i = height.length - 2; i >= 0; i--) {
//            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
//        }
//        for (int i = 1; i < height.length - 1; i++) {
//            int min = Math.min(max_left[i], max_right[i]);
//            if (min > height[i]) {
//                sum = sum + (min - height[i]);
//            }
//        }
//        return sum;
//    }

//    作者：windliang
//    链接：https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
