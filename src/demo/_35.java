package demo;

/**
 * 35. 搜索插入位置
 * @date 2021/9/21
 * @description 红蓝区域方法很有用
 */
public class _35 {
    public int searchInsert(int[] nums, int target) {
        int left = -1;
        int right = nums.length;

        while(left + 1 != right){
            int m = (left + right)/2;
            if(target > nums[m]){
                left = m;
            }else {
                right = m;
            }
        }
        return left;
    }
}
