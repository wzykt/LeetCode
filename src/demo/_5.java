package demo;

/**
 * 5. 最长回文子串
 *
 * @date 2021/8/3 2021/11/26完成
 * @decription1:首先想到的思路是双指针，回文字符串，翻转前后仍相同
 * @result:未通过，超时，思路正确。 答案：动态规划解决
 * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
 *
 * 解决方法：从每一个字符串开始向两边延展，判断两边的字母是否相同
 *
 *
 */
public class _5 {
    /*public static String longestPalindrome(String s) {
        if(s.isEmpty()){
            return null;
        }
        if(s.length() == 1){
            return s;
        }
        int begin = 0, end = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i; j--) {
                StringBuffer tem = new StringBuffer(s.substring(i, j));
                if (tem.reverse().toString().equals(s.substring(i, j))) {
                    int t = j - i;
                    if (maxLen < t) {
                        maxLen = t;
                        begin = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(begin, end);
    }*/
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        int maxLen = 1;
        int start = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && right < len && s.substring(left, left + 1).equals(s.substring(right, right + 1))) {
                if (right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    start = left;
                }
                left--;
                right++;
            }

            left = i;
            right = i + 1;
            while (left >= 0 && right < len && s.substring(left, left + 1).equals(s.substring(right, right + 1))) {
                if (right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    start = left;
                }
                left--;
                right++;
            }
        }
        return s.substring(start, start + maxLen);
    }


    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }

}
