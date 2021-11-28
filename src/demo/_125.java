package demo;

import java.util.Arrays;

/**
 * @date 2021/11/26 2021/11/26完成
 * @description 125. 验证回文串
 *
 * 1.借助reverse方法
 * 2.双指针
 */
public class _125 {
    public boolean isPalindrome(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
        return sgood.toString().equals(sgood_rev.toString());
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
    }
}
