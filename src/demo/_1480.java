package demo;


/**
 * 一维数组的动态和
 * @date 2021/8/18
 * @decription
 */
public class _1480{
    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i]+result[i-1];
        }
        return result;
    }
}
