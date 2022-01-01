package huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @date 2021-12-31 2021-12-31完成
 * @description 47. 全排列 II
 *
 * 比46题多一个去重的操作
 */
public class _47 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        //去重要先排序
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTracking(nums, used);
        return res;
    }

    public void backTracking(int[] nums, boolean[] used) {
        if (nums.length == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue;
            if (used[i]) continue;
            used[i] = true;
            list.add(nums[i]);
            backTracking(nums, used);
            list.removeLast();
            used[i] = false;
        }
    }
}
