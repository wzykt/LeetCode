package demo;

/**
 * 162. 寻找峰值
 *
 * @date 2021/9/22
 * @description
 */
public class _162 {
    public static int findPeakElement(int[] nums) {
        int left = -1, right = nums.length;
        while (left + 1 != right) {
            int m = (left + right) / 2;
            //注意边界
            if (m+1 < nums.length && nums[m] < nums[m + 1]) {
                left = m;
            } else {
                right = m;
            }
        }
        return right;
    }
    public static void main(String[] args) {
        int nums[] = {1,2};
        System.out.println(findPeakElement(nums));

    }
}
