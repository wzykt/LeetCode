package huisu;

import java.util.*;

/**
 * @date 2021-12-29 2021-12-29完成
 * @description 40. 组合总和 II
 * <p>
 * 比39题多一个去重操作
 *
 * 重点：这题属于“树枝去重”
 */
public class _40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        //要想去重，要先实现排序
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        ArrayDeque<Integer> path = new ArrayDeque<>();
        //记录数组中的数据是否被使用了
        boolean[] flag = new boolean[candidates.length];
        dfs(candidates, 0, len, target, path, res, flag);
        return res;
    }

    private void dfs(int[] candidates, int begin, int len, int target, ArrayDeque<Integer> path, List<List<Integer>> res, boolean[] flag) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            //判断相同的数字是否被用过
            if (i > 0 && candidates[i] == candidates[i - 1] && !flag[i - 1]) {
                continue;
            }
            path.addLast(candidates[i]);
            flag[i] = true;
            dfs(candidates, i + 1, len, target - candidates[i], path, res, flag);
            path.removeLast();
            flag[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        _40 t = new _40();
        List<List<Integer>> list = t.combinationSum2(nums, target);
        System.out.println(list);
    }

    //超时
/*    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        Set<ArrayList<Integer>> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        LinkedList<Integer> path = new LinkedList<>();
        dfs(candidates, 0, len, target, path, set);
        for (List<Integer> l : set) {
            res.add(l);
        }
        return res;
    }

    private void dfs(int[] candidates, int begin, int len, int target, LinkedList<Integer> path, Set<ArrayList<Integer>> set) {
        // target 为负数和 0 的时候不再产生新的孩子结点
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ArrayList<Integer> integers = new ArrayList<>(path);
            Collections.sort(integers);
            set.add(integers);
            return;
        }

        // 重点理解这里从 begin 开始搜索的语意
        for (int i = begin; i < len; i++) {
            path.addLast(candidates[i]);

            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(candidates, i + 1, len, target - candidates[i], path, set);
            // 状态重置
            path.removeLast();
        }
    }*/
}
