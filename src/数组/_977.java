package 数组;

import java.util.Arrays;

/**
 * @date 2021-12-14
 * @description 977. 有序数组的平方
 * 此时可以考虑双指针法了，i指向起始位置，j指向终止位置。
 * 定义一个新数组result，和A数组一样的大小，让k指向result数组终止位置。
 * 如果A[i] * A[i] < A[j] * A[j] 那么result[k--] = A[j] * A[j]; 。
 * 如果A[i] * A[i] >= A[j] * A[j] 那么result[k--] = A[i] * A[i]; 。
 */
public class _977 {
    public int[] sortedSquares(int[] nums) {
        int j = nums.length - 1;
        int i = 0;
        int[] res = new int[j + 1];

        for (int k = j; k >= 0; k--) {
            if (nums[i] * nums[i] <= nums[j] * nums[j]) {
                res[k] = nums[j] * nums[j];
                j--;
            } else {
                res[k] = nums[i] * nums[i];
                i++;
            }
        }
        return res;
    }
}
//暴力解法
        /*for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            nums[i] = t * t;
        }
        Arrays.sort(nums);
        return nums;*/