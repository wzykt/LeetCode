package 数组.二分;

/**
 * @date 2021/12/13 2021/12/13完成
 * @description 704. 二分查找
 *
 * 灵活套用模板
 */
public class _704 {
    public int search(int[] nums, int target) {
        int l = -1;
        int r = nums.length;
        while (l + 1 != r) {
            int m = (l + r) / 2;
            if (nums[m] < target) {
                l = m;
            } else if (nums[m] > target) {
                r = m;
            } else {
                return m;
            }
        }
        return -1;
    }
}
