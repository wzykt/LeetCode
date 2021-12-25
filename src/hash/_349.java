package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @date 2021-12-18  2021-12-18完成
 * @description 349. 两个数组的交集
 */
public class _349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> s = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                s.add(nums2[i]);
            }
        }
        int[] res = new int[s.size()];
        int index = 0;
        for (Integer i : s) {
            res[index++] = i;
        }
        return res;
/*        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.computeIfAbsent(nums1[i],(v)->{
                return v++;
            });
        }
        for (int i = 0; i < nums2.length; i++) {
            map.computeIfAbsent(nums2[i],(v)->{
                return v--;
            });
        }
        System.out.println(map.toString());
        List<Integer> list = new ArrayList<>();
        for (Integer i:map.keySet()) {
            if(map.get(i)<0){
                list.add(map.get(i));
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;*/
    }
}
