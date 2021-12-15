package 数组;

/**
 * @date 2021-12-14
 * @description 27. 移除元素
 * 根据题意，我们可以将数组分成「前后」两段：
 * 前半段是有效部分，存储的是不等于 val 的元素。
 * 后半段是无效部分，存储的是等于 val 的元素。
 */
public class _27 {
    public int removeElement(int[] nums, int val) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] == val) {
                swap(nums,l,r);
                l--;
                r--;
            }
            l++;

        }
        return r+1;
    }
    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
