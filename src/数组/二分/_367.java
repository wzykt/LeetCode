package 数组.二分;

/**
 * @date 2021/12/13 2021/12/13完成
 * @description 367. 有效的完全平方数
 */
public class _367 {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        long l = -1;
        long r = num;
        while (l + 1 != r) {
            long m = (l + r) / 2;
            if ((m * m) < num) {
                l = m;
            } else if((m * m) > num){
                r = m;
            }else {
                return true;
            }
        }
        return false;
    }
}
