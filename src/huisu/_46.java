package huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @date 2021-12-31 2021-12-31完成
 * @description 46. 全排列
 *
 * 排列问题不需要index，因为需要多次遍历
 */
public class _46 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
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
            if (used[i]) continue;
            used[i] = true;
            list.add(nums[i]);
            backTracking(nums, used);
            list.removeLast();
            used[i] = false;
        }
    }
}
