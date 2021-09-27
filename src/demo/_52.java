package demo;

import java.util.*;

/**
 * 52. N 皇后2
 *
 * @date 2021/9/26
 */
public class _52 {
    public int solveNQueens(int n) {
        int[] record = new int[n];

        int res = process(0, record, n);
        return res;
    }

    public static int process(int i, int[] record, int n) {
        if (i == n) {
            return 1;
        }

        int res = 0;
        //每列放一个，避免了行的冲突
        for (int j = 0; j < n; j++) {
            //因为只判断0~i-1位置上的皇后，所以不用显性的恢复现场
            if (isTrue(i, j, record)) {
                record[i] = j;
                res += process(i + 1, record, n);
            }
        }
        return res;
    }

    
    public static boolean isTrue(int i, int j, int[] record) {
        for (int k = 0; k < i; k++) {
            if (record[k] == j) {
                return false;
            }
//            if (record[k] - k == j - i) {
//                return false;
//            }
            //(a,b)  (c,d) 满足 |a-c| = |b-d|时共斜线
            if (Math.abs(record[k] - j) == Math.abs(k - i)) {
                return false;
            }
        }
        return true;
    }
}
