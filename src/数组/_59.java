package 数组;

/**
 * @date 2021-12-16  2021-12-16完成
 * @description 59. 螺旋矩阵 II
 */
public class _59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int c = 0;
        int l = 0;
        int i = 1;
        while (i < n * n) {
            //上
            for (int j = l; j < n - l; j++) {
                res[c][j] = i++;
            }
            c++;
            //右
            for (int j = c; j < n - c; j++) {
                res[j][n - l - 1] = i++;
            }

            //下
            for (int j = n - 1 - c; j >= l; j--) {
                res[n - c][j] = i++;
            }
            l++;
            //左
            for (int j = n - 1 - l; j >= c; j--) {
                res[j][l - 1] = i++;
            }

        }

        if (n % 2 == 1) {
            res[n / 2][n / 2] = n * n;
        }
        return res;
    }
}
