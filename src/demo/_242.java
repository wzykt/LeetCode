package demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 2021/11/23
 * @description 242. 有效的字母异位词
 * 借助map完成，自己第一想法是借助两个map，依次比较字母出现的次数
 * 起始可以只借助一个map来完成，串1出现字母，对应的值加一，串2出现字母，对应的值减一，最后看mao中的值是否为0即可
 *
 * 参考答案是真的简单啊
 * 排序+比较
 */
public class _242 {

    public boolean isAnagram(String s, String t) {
        //如果两个字符串长度不相同，直接返回false
        if (s.length() != t.length()) {
            return false;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String s1 = s.substring(i, i + 1);
            String t1 = t.substring(i, i + 1);
            if (map.containsKey(s1)) {
                int tem = map.get(s1) + 1;
                map.put(s1, tem);
            } else {
                map.put(s1, 1);
            }
            if (map.containsKey(t1)) {
                int tem = map.get(t1) - 1;
                map.put(t1, tem);
            } else {
                map.put(t1, -1);
            }
        }

        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                return false;
            }
        }
        return true;
    }

    /*public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }*/
}
