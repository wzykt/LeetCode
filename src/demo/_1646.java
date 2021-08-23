package demo;

/**
 * 1646. 获取生成数组中的最大值
 * @date 2021/8/23
 * @decription:不知道干什莫的题目
 */
public class _1646 {

    public int getMaximumGenerated(int n) {
        int N = 110;
        int[] nums = new int[N];
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 0; i < N; i++) {
            if (2 * i < N) {
                nums[2 * i] = nums[i];
            }
            if (2 * i + 1 < N) {
                nums[2 * i + 1] = nums[i] + nums[i + 1];
            }
        }
        for (int i = 0, max = 0; i < N; i++) {
            nums[i] = max = Math.max(max, nums[i]);
        }
        return nums[n];
    }

}
