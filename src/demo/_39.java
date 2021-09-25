package demo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 39. 组合总和
 *
 * @date 2021/9/25
 * @description 回溯，通过，但是代码效率很低
 */
public class _39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length < 1) {
            return res;
        }
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        process(candidates, target, res, list);
        for (List<Integer> list1: res) {
            Collections.sort(list1);
        }
        return res.stream().distinct().collect(Collectors.toList());
    }

    public void process(int[] candidates, int target, List<List<Integer>> res, List<Integer> list) {
        if (sum(list) > target) {
            return;
        }
        if (sum(list) == target) {
            System.out.println(list);
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            list.add(candidates[i]);
            process(candidates, target, res, list);
            list.remove(list.size() - 1);
        }
    }

    public static int sum(List<Integer> list) {
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        int target = 7;
        _39 t = new _39();
        List<List<Integer>> list = t.combinationSum(nums, target);
        System.out.println(list);
    }
}
