package huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @date 2021-12-30 2021-12-30完成
 * @description 78. 子集
 * 如果把 子集问题、组合问题、分割问题都抽象为一棵树的话，那么组合问题和分割问题都是收集树的叶子节点，而子集问题是找树的所有节点！
 * <p>
 * 其实子集也是一种组合问题，因为它的集合是无序的，子集{1,2} 和 子集{2,1}是一样的。
 * <p>
 * 那么既然是无序，取过的元素不会重复取，写回溯算法的时候，for就要从index开始，而不是从0开始！
 * <p>
 * 什么时候for可以从0开始呢？
 * <p>
 * 求排列问题的时候，就要从0开始，因为集合是有序的，{1, 2} 和{2, 1}是两个集合
 */
public class _78 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backTracking(0, nums);
        return res;
    }
    //求取子集问题，不需要任何剪枝！因为子集就是要遍历整棵树。
    public void backTracking(int index, int[] nums) {
        res.add(new ArrayList<>(list));
        if (index >= nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {

            list.addLast(nums[i]);
            backTracking(i + 1, nums);
            list.removeLast();
        }
    }
    //和上面结果相同，不过更好理解一些
/*    public List<List<Integer>> subsets(int[] nums) {
        backTracking(0, nums, true);
        res.add(new ArrayList<>());
        return res;
    }

    public void backTracking(int index, int[] nums, boolean b) {
        if (index >= nums.length) {
            return;
        }


        for (int i = index; i < nums.length; i++) {
            if (b == true) {
                list.addLast(nums[i]);
                backTracking(i + 1, nums, true);
                backTracking(i + 1, nums, false);
            } else {
                continue;
            }
            res.add(new ArrayList<>(list));
            list.removeLast();
        }
    }*/

    public static void main(String[] args) {
        _78 obj = new _78();
        int[] nums = {1, 2, 2};
        obj.subsets(nums);
        System.out.println(obj.res.toString());
    }
}
