package demo;


/**
 * 73. 矩阵置零
 *
 * @date 2021/10/11开始，2021/10/12完成
 * @description 第一次未考虑到，一行可能同时存在多个0，所以目前所想就是先记录，再处理
 *
 */
public class _73 {
    /*
 时间复杂度：O(mn)O(mn)，其中 mm 是矩阵的行数，nn 是矩阵的列数。我们至多只需要遍历该矩阵两次。
 空间复杂度：O(m+n)O(m+n)，其中 mm 是矩阵的行数，nn 是矩阵的列数。我们需要分别记录每一行或每一列是否有零出现。
     */
    public void setZeroes(int[][] matrix) {
        boolean[] useL = new boolean[matrix.length];
        boolean[] useC = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (useL[i] || useC[j]) {
                    continue;
                }
                if (matrix[i][j] == 0) {
                    useC[j] = true;
                    useL[i] = true;
                }
            }
        }

        //列置0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (useC[j] || useL[i]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}

