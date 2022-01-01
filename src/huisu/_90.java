package huisu;

import java.util.*;

/**
 * @date 2021-12-30 2021-12-30完成
 * @description 90. 子集 II
 * <p>
 * 对比78，多了一个判重复的操作,我这里借助Set完成，效率较低
 * （注意去重需要先对集合排序）
 *
 * 重点：这题属于“树层去重”
 */
public class _90 {

    //答案写的
    List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0){
            result.add(path);
            return result;
        }
        Arrays.sort(nums);
        used = new boolean[nums.length];
        subsetsWithDupHelper(nums, 0);
        return result;
    }

    private void subsetsWithDupHelper(int[] nums, int startIndex){
        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length){
            return;
        }
        for (int i = startIndex; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            subsetsWithDupHelper(nums, i + 1);
            path.removeLast();
            used[i] = false;
        }
    }

    //自己写的，用set去重
   /* List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();

    //Set<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int[] used = new int[nums.length];

        backTracking(0, nums, used);
       *//* for (List<Integer> l:set) {
            res.add(l);
        }*//*
        return res;
    }

    public void backTracking(int index, int[] nums, int[] used) {
        //set.add(new ArrayList<>(list));
        res.add(new ArrayList<>(list));
        if (index >= nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {

            list.addLast(nums[i]);
            backTracking(i + 1, nums, used);
            list.removeLast();
        }
    }*/
}
