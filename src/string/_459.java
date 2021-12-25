package string;

/**
 * @date 2021-12-21 2021-12-21完成
 * @description 459. 重复的子字符串
 *
 * 字符串匹配
 * 但是不会KMP
 */
public class _459 {
    //暴力
    //时间复杂度o(n*n)
    public static boolean repeatedSubstringPattern(String s) {
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            String tem = s.substring(0, i + 1);
            len = i + 1;
            for (int j = i + 1; j < s.length(); j += len) {
                if (j + len - 1 >= s.length()) {
                    break;
                }
                if (!s.substring(j, j + len).equals(tem)) {
                    break;
                }
                if (s.substring(j, j + len).equals(tem) && j == (s.length() - len)) {
                    return true;
                }
            }
        }
        return false;
    }

    //很nb的思路
    /*public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }*/

    public static void main(String[] args) {
        String s = "abab";
        System.out.println(repeatedSubstringPattern(s));
    }
}
