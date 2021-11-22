package demo;

import java.util.HashSet;

/**
 * @date 2021/11/22 2021/11/22完成
 * @description 217. 存在重复元素
 *
 * 借助一个Set完成
 */
public class _217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }else {
                return true;
            }
        }
        return false;
    }
}
