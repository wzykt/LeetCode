package string;

/**
 * @date 2021-12-20 2021-12-20完成
 * @description 344. 反转字符串
 *
 * 简单题我TM重拳出击
 */
public class _344 {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char tem = s[l];
            s[l] = s[r];
            s[r] = tem;
            l++;
            r--;
        }
    }
}
