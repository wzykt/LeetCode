package hash;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 18. 四数之和
 *
 * @date 2021/9/24  2021-12-22再次完成
 * @description 自己的代码没有跑出结果。
 * 2021/9/25修改了res.add(new ArrayList<>(list));
 * 加了排序和去重
 * 但是超时了，这是没想到的
 * <p>
 * 答案是双指针完成，比较麻烦
 */
public class _18 {

    /**
     * 答案写法，里层就是套用的三数之和
     * 只是需要注意如何剪枝
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        if (nums.length < 4) {
            return res;
        }

        for (int a = 0; a < nums.length; a++) {
            // 这种剪枝是错误的，这道题目target 是任意值
            // if (nums[a] > target) {
            //     return res;
            // }
            // 去重
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            for (int b = a + 1; b < nums.length; b++) {

                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                int c = b + 1;
                int d = nums.length - 1;
                while (c < d) {
                    int sum = nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum > target) {
                        d--;
                    } else if (sum < target) {
                        c++;
                    } else if (sum == target) {
                        List list = new ArrayList(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        res.add(list);
                        while (c < d && nums[c] == nums[c + 1]) c++;
                        while (c < d && nums[d] == nums[d - 1]) d--;
                        c++;
                        d--;
                    }
                }
            }
        }
        return res;
    }
    //自己的方法
/*    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 1) {
            return res;
        }
        Set<Integer> use = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        process(nums, target, list, use, res);
        for (List<Integer> list1: res) {
            Collections.sort(list1);
        }
        return res.stream().distinct().collect(Collectors.toList());
    }

    public void process(int[] nums, int target, List<Integer> list, Set<Integer> use, List<List<Integer>> res) {
        if (list.size() > 4) {
            return;
        }

        if (list.size() == 4 && sum(list) == target && !res.contains(list)) {
//            System.out.println(list);
//            Collections.sort(list);
            //暂时不知道为什么放不进去
            //res.add(list);
            //要创建对象，不然add进去的就是空的
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (use.contains(i)) {
                return;
            }
            use.add(i);
            list.add(nums[i]);
            process(nums, target, list, use, res);
            use.remove(i);
            list.remove(list.size() - 1);
        }
    }

    public static int sum(List<Integer> list) {
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        return sum;
    }*/

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        _18 t = new _18();
        List<List<Integer>> list = t.fourSum(nums, target);
        System.out.println(list);
    }
}