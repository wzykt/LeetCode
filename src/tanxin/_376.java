package tanxin;

/**
 * @date 2022-1-10
 * @description 376. 摆动序列
 */
public class _376 {

    //有问题，没有解决[3,3,3,2,5]这种情况
   /* public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return 1;
        }
        boolean b = false;
        int count = 1;
        int pre = 0;
        if(nums[1] - nums[0] >= 0){
            b = true;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (b && nums[i+1] > nums[i]) {
                count++;
                b = false;
            }
            if (!b && nums[i+1] < nums[i]) {
                count++;
                b = true;
            }
        }
        return count;
    }*/
    //答案
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums.length;
        }
        //当前差值
        int curDiff = 0;
        //上一个差值
        int preDiff = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            //得到当前差值
            curDiff = nums[i] - nums[i - 1];
            //如果当前差值和上一个差值为一正一负
            //等于0的情况表示初始时的preDiff
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }
}
