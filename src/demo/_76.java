package demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @date 2021/12/6
 * @description 76. 最小覆盖子串
 */
public class _76 {
    public String minWindow(String s, String t) {
        int j = 0;
        Set<Character> tSet = new HashSet<>();
        char[] chars1 = t.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            tSet.add(chars1[i]);
        }

        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(tSet.contains(chars[i])){
                set.add(chars[i]);
            }
            while(set.equals(tSet)){
                
            }
        }
        return null;
    }
}
