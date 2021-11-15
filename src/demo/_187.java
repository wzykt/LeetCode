package demo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @date 2021/11/15 2021/11/15完成
 * @description 187. 重复的DNA序列
 */
public class _187 {
    //借助一个map来记录数据出现次数，map很好的作用就是用来去重
/*    public static List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        String tem = null;
        int cow = 0;
        List<String> res = new ArrayList<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            tem = s.substring(i, i + 10);
            if (map.containsKey(tem)) {
                cow = map.get(tem) + 1;
                map.put(tem, cow);
            } else {
                map.put(tem, 1);
            }
        }
        for (String t : map.keySet()) {
            if (map.get(t) > 1) {
                res.add(t);
                System.out.println(t);
            }
        }
        return res;
    }*/
    //还可以用set
    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> result = new HashSet<>();
        String tem = null;
        List<String> res = new ArrayList<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            tem = s.substring(i, i + 10);
            if (set.contains(tem)) {
                result.add(tem);
            } else {
                set.add(tem);
            }
        }
        //set转为list即可
        //不知道有没有其他快捷的方法
        //这里用了流
        res = result.stream().collect(Collectors.toList());
        return res;
    }

    public static void main(String[] args) {
        String s = "AAAAAAAAAAA";
        List<String> repeatedDnaSequences = findRepeatedDnaSequences(s);
        System.out.println(repeatedDnaSequences.toString());
    }
}
