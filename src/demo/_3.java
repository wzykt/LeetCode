package demo;

import java.util.HashSet;
import java.util.Set;

/**
 * @date 2021/12/3 2021/12/3完成
 * @description 3. 无重复字符的最长子串
 * <p>
 * 滑动窗口
 *
 */
public class _3 {
    public static int lengthOfLongestSubstring(String s) {
        int j = 0;
        int maxLen = 0;
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            while (set.contains(chars[i])) {
                maxLen = Math.max(maxLen, set.size());
                set.remove(chars[j]);
                j++;
            }
            set.add(chars[i]);
            System.out.println(set.toString());
        }
        return Math.max(maxLen, set.size());
    }

    public static void main(String[] args) {
        String s = " ";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
