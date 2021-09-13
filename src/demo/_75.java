package demo;

import java.util.Arrays;

/**
 * 75. 颜色分类
 *
 * @date 2021/9/13
 * @description 对数组进行partition
 * https://blog.csdn.net/SunnyYoona/article/details/43488481
 */
public class _75 {
    public static void sortColors(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int begin = 0;
        int end = nums.length;
        int index = begin;

        while (index < end) {
            if (nums[index] == 0) {
                swap(nums, begin, index);
                index++;
                begin++;
            } else if (nums[index] == 1) {
                index++;
            } else {
                end--;
                swap(nums, end, index);
            }
        }
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    /*
    错的代码
        public void sortColors(int[] nums) {
if(nums.length == 1){
            return;
        }
        int begin = 0;
        int end = nums.length - 1;
        int index = begin;

        while (index < end) {
            if (nums[index] < 1) {
                int t = nums[begin];
                nums[begin] = nums[index];
                nums[index] = t;
                index++;
                begin++;
            }
            if (nums[index] > 1) {
                int t = nums[end];
                nums[end] = nums[index];
                nums[index] = t;
                end--;
            }
            if (nums[index] == 1) {
                index++;
            }
        }
    }
     */
}
