package huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @date 2021-12-30
 * @description 491. 递增子序列
 */
public class _491 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums, 0);
        return res;
    }

    public void backTracking(int[] nums, int index) {
        if (index >= nums.length) {
            if (list.size() >= 2) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] > nums[i]) {
                list.addLast(nums[i]);
                backTracking(nums, i + 1);
                list.removeLast();
            } else {
                continue;
            }
        }
    }

}
