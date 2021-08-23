package demo;

import java.util.Arrays;

/**
 * @date 2021/8/20
 * <p>
 * 345. 反转字符串中的元音字母
 */
public class _345 {
    public static String reverseVowels(String s) {
        char[] Vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        int x = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (isContain(chars[i], Vowels)) {
                x = i;
                break;
            }
        }
        System.out.println(x);
        int y = x + 1;
        while (y < chars.length) {
            if (isContain(chars[y], Vowels)) {
                swap(x, y, chars);
                x = y;
                y++;
            } else {
                y++;
            }
        }

        String result = "";
        for (int i = 0; i < chars.length; i++) {
            result+=chars[i];
        }
        return result;
    }

    public static boolean isContain(char c, char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (c == chars[i]) {
                return true;
            }
        }
        return false;
    }

    public static void swap(int c1, int c2, char[] chars) {
        char t = chars[c1];
        chars[c1] = chars[c2];
        chars[c2] = t;
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reverseVowels(s));
    }
}
