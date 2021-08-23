package demo;

/**
 * 5. 最长回文子串
 *
 * @date 2021/8/3
 * @decription1:首先想到的思路是双指针，回文字符串，翻转前后仍相同
 * @result:未通过，超时，思路正确。
 *
 * 答案：动态规划解决
 * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
 */
public class _5 {

    public static String longestPalindrome(String s) {
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
    }

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }

}
