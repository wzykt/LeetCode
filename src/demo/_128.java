package demo;

import java.util.*;
import java.util.Arrays;

/**
 * 128. 最长连续序列
 *
 * @date 2021/8/30
 * @description 我的思路：记录两个数之间的间隔，用hash表记录，最后统计表中出现次数最多的间隔。但是没有解决两个连续的数  [0,1]
 * @result 借鉴答案：1、定义一个哈希表hash，将nums数组中的数都放入哈希表中。
 * 2、遍历哈希表hash，如果当前数x的前驱x-1不存在，我们就以当前数x为起点向后枚举。
 * 3、假设最长枚举到了数y，那么连续序列长度即为y-x+1。
 * 4、不断枚举更新答案。
 */
public class _128 {
    //错误：部分实例解决不了 如[0,1]
//    public static int longestConsecutive(int[] nums) {
//        Arrays.sort(nums);
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length - 1; i++) {
//            int t = nums[i + 1] - nums[i];
//            map.put(Math.abs(t), map.get(t) == null ? 0 : map.get(t) + 1);
//        }
//        int max = 0;
//        for (Integer i : map.keySet()) {
//            max = Math.max(max, map.get(i));
//        }
//        return max + 1;
//    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> hash = new HashSet<Integer>();
        for(int x : nums) hash.add(x);    //放入hash表中
        int res = 0;
        for(int x : hash)
        {
            if(!hash.contains(x-1))
            {
                int y = x;   //以当前数x向后枚举
                while(hash.contains(y + 1)) y++;
                res = Math.max(res, y - x + 1);  //更新答案
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,-1};
        System.out.println(longestConsecutive(nums));
    }
}
