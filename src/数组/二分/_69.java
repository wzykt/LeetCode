package 数组.二分;

/**
 * @date 2021/12/13 2021/12/13完成
 * @description 69. Sqrt(x)
 */
public class _69 {
    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        long l = -1;
        long r = x;
        while (l + 1 != r) {
            long m = (l + r) / 2;
            if ((m * m) <= x) {
                l = m;
            } else {
                r = m;
            }
        }
        return (int)l;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(100001));
    }
}
