package demo;

/**
 * 153. 寻找旋转排序数组中的最小值
 * @date 2021/9/22
 * @description 完成
 */
public class _153 {
    public static int findMin(int[] nums) {
        int mark = nums[0];

        int left = -1,right = nums.length;
        while(left + 1 != right){
            int m = (left + right) /2;
            if(mark <= nums[m]){
                left = m;
            }else {
                right = m;
            }
        }
        //红蓝边界无法解决完全拍好序的，加一个特殊处理即可
        if(nums.length == right){
            return nums[0];
        }
        return nums[right];
    }

    public static void main(String[] args) {
        int nums[] = {4,5,6,7,0,1,2};
        System.out.println(findMin(nums));

    }
}
