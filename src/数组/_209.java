package 数组;

/**
 * 209. 长度最小的子数组
 *
 * @date 2021/9/22  2021-12-15第二次完成
 * @description 从二分法的题目列表中，看到此题，便先想了一下二分法是否可行，感觉不太行。
 * 换成双指针试一下
 * 双指针完成，只不过是暴力完成
 *
 * 2021-12-15
 * 再次暴力
 *
 * 滑动窗口
 *
 */
public class _209 {
    public static int minSubArrayLen(int target, int[] nums) {
        //暴力方式 2021-12-15
        //时间复杂度o(n*n)
        /*int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    min = Math.min(j - i + 1, min);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min ;
         */

        //暴力方式
        //2021/9/22
       /* int b = 0;
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
        */
        //滑动窗口解决
        //时间复杂度o(n)
        int i = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int j = 0; j < nums.length; j++) {
            sum+=nums[j];
            while(sum >= target){
                minLen = Math.min(j-i+1,minLen);
                sum-=nums[i];
                i++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen ;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 11;
        int i = minSubArrayLen(target, nums);
        System.out.println(i);
    }


}

