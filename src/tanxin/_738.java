package tanxin;

/**
 * @date 2022-1-17
 * @description 738. 单调递增的数字
 *
 * 局部最优：遇到strNum[i - 1] > strNum[i]的情况，让strNum[i - 1]--，然后strNum[i]给为9，可以保证这两位变成最大单调递增整数。
 *
 * 全局最优：遇到strNum[i - 1] > strNum[i]的情况，让strNum[i - 1]--，记录开始为9的位置i，最后得到小于等于N的最大单调递增的整数。
 */
public class _738 {
    public int monotoneIncreasingDigits(int N) {
        String[] strings = (N + "").split("");
        //用一个start来标记从哪里开始赋值9。
        int start = strings.length;
        for (int i = strings.length - 1; i > 0; i--) {
            if (Integer.parseInt(strings[i]) < Integer.parseInt(strings[i - 1])) {
                strings[i - 1] = (Integer.parseInt(strings[i - 1]) - 1) + "";
                start = i;
            }
        }
        for (int i = start; i < strings.length; i++) {
            strings[i] = "9";
        }
        return Integer.parseInt(String.join("",strings));
    }

    //暴力，超时
    /*public int monotoneIncreasingDigits(int n) {
        for (int i = n; i >= 0; i--) {
            if(isTrue(i)){
                return i;
            }
        }
        return n;
    }

    public boolean isTrue(int n){
        int t = 10;
        while (n > 0){
            if(t < n % 10){
                return false;
            }
            t = n % 10;
            n = n / 10;
        }
        return true;
    }*/
}
