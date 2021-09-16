package demo;

/**
 * 33. 搜索旋转排序数组
 *
 * @date 2021/9/16
 * @description 对于有序数组，首先想到二分，但是反转之后，就不是排序好的了，而是部分排序好的，没想到还可以使用二分
 * <p>
 * 将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
 * 此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
 */
public class _33 {
    //    public int search(int[] nums, int target) {
//        int res = -1;
//        if (nums[0] > target) {
//            for (int i = 0; i < nums.length; i++) {
//                if (nums[i] == target) {
//                    return i;
//                }
//            }
//        } else {
//            for (int i = nums.length; i >= 0; i--) {
//                if (nums[i] == target) {
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
