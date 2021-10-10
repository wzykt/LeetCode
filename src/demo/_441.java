package demo;

/**
 * 441. 排列硬币
 *
 * @date 2021/10/10
 * @description 使用暴力解决的
 * <p>
 * 答案：使用二分法
 * 根据等差数列求和公式可知，前k个完整阶梯行所需的硬币数量为
 * total=k×(k+1) / 2
 *
 *
 */
public class _441 {
    //    public int arrangeCoins(int n) {
//        long sum = 0;
//        int res = 0;
//
//        for (long i = 1; i <= Integer.MAX_VALUE+1; i++) {
//            sum += i;
//            if (sum > n) {
//                res = (int)i - 1;
//                break;
//            }
//            if (sum == n) {
//                res = (int)i;
//                break;
//            }
//        }
//        return res;
//    }
    public int arrangeCoins(int n) {
        int left = -1, right = n;
        if(n == 1){
            return 1;
        }
        while (left +1 != right) {
            int mid = (left + right) / 2;
            //二分解决重点就是这个公式
            if ((long) mid * (mid + 1) <= (long) 2 * n) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
}
