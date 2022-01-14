package tanxin;

/**
 * @date 2022-1-13 2022-1-13完成
 * @description 55. 跳跃游戏
 *
 * 每次移动取最大跳跃步数（得到最大的覆盖范围），每移动一个单位，就更新最大覆盖范围。
 *
 * 贪心算法局部最优解：每次取最大跳跃步数（取最大覆盖范围），整体最优解：最后得到整体最大覆盖范围，看是否能到终点。
 */
public class _55 {

    public boolean canJump(int[] nums) {
        //自己的想法，没想到更新for的终止条件
        /*fif(nums.length <= 1){
            return true;
        }
        for (int i = 0; i < nums.length - 1; i++) {z
            if (i + nums[i] >= nums.length - 1) {
                return true;
            }
        }
        return false;*/
        if (nums.length == 1) {
            return true;
        }
        //覆盖范围, 初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
        int coverRange = 0;
        //重点
        //在覆盖范围内更新最大的覆盖范围
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + nums[i]);
            if (coverRange >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _55 obj = new _55();
        int[] ints = {0,2,3};
        System.out.println(obj.canJump(ints));
    }
}
