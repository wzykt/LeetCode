package demo;

/**
 * 209. 长度最小的子数组
 *
 * @date 2021/9/22
 * @description 从二分法的题目列表中，看到此题，便先想了一下二分法是否可行，感觉不太行。
 * 换成双指针试一下
 *
 * 双指针完成
 */
public class _209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int b = 0;
        int res = 1000;
        while (b < nums.length) {
            int sum = 0;
            for (int i = b; i < nums.length; i++) {
                sum += nums[i];
                if (sum >= target) {
                    res = Math.min(res, i - b + 1);
                    break;
                }
                if (sum < target) {
                    continue;
                }
            }
            b++;
        }
        return res == 1000 ? 0 : res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int target = 11;
        int i = minSubArrayLen(target, nums);
        System.out.println(i);
    }
}
