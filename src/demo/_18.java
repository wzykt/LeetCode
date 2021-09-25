package demo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 18. 四数之和
 *
 * @date 2021/9/24
 * @description 自己的代码没有跑出结果。
 * 2021/9/25修改了res.add(new ArrayList<>(list));
 * 加了排序和去重
 * 但是超时了，这是没想到的
 * <p>
 * 答案是双指针完成，比较麻烦
 */
public class _18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
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
    }

    public static void main(String[] args) {
        int[] nums = {-497,-494,-484,-477,-453,-453,-444,-442,-428,-420,-401,-393,-392,-381,-357,-357,-327,-323,-306,-285,-284,-263,-262,-254,-243,-234,-208,-170,-166,-162,-158,-136,-133,-130,-119,-114,-101,-100,-86,-66,-65,-6,1,3,4,11,69,77,78,107,108,108,121,123,136,137,151,153,155,166,170,175,179,211,230,251,255,266,288,306,308,310,314,321,322,331,333,334,347,349,356,357,360,361,361,367,375,378,387,387,408,414,421,435,439,440,441,470,492};
        int target = 1682;
        _18 t = new _18();
        List<List<Integer>> list = t.fourSum(nums, target);
        System.out.println(list);
    }
}