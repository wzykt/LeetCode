package demo;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * @date2021/9/16 排序好的数组，二分即可
 * @description
 * 参考视频，会有特殊的二分模板
 * https://www.bilibili.com/video/BV1d54y1q7k7
 */
public class _34 {
    public int binarySearchLeft(int[] nums, int target) {
        int left = -1, right = nums.length;
        while (left+1 != right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
    public int binarySearchRight(int[] nums, int target) {
        int left = -1, right = nums.length;
        while (left+1 != right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearchLeft(nums, target);
        int rightIdx = binarySearchRight(nums, target);
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }
}
