package demo;

import java.util.Arrays;
import java.util.Collections;

/**
 * 48. 旋转图像
 * @date 2021/10/5
 * @description 找到规律即可，第i行旋转之后就对应这倒数第i列
 */
public class _48 {
    public static int[][] rotate(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];
        int cow = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            int[] t = matrix[i];
            int hi = 0;
            while (hi < matrix.length){
                res[hi][cow - i - 1] = t[hi];
                hi++;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = res[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        int[][] res = rotate(matrix);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        };
    }
}
