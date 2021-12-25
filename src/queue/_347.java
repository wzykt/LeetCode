package queue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @date 2021-12-24 2021-12-24完成
 * @description 347. 前 K 个高频元素
 */
public class _347 {
    public int[] topKFrequent(int[] nums, int k) {
        //map统计出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                Integer integer = map.get(nums[i]);
                integer++;
                map.put(nums[i], integer);
            } else {
                map.put(nums[i], 1);
            }
        }

        int[] res = new int[k];
        //构架最大堆
        //Map中的Entry是键值对的集合
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<Integer,Integer> s : map.entrySet()) {
            queue.add(s);
        }

        for (int i = 0; i < k; i++) {
            res[i] = queue.poll().getKey();
        }
        return res;
    }
}
