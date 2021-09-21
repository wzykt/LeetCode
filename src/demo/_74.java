package demo;

/**
 * 74. 搜索二维矩阵
 *
 * @date 2021/9/21
 * @description 红蓝区域方法很有用
 */
public class _74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int left = -1, right = matrix[i].length;
            while (left + 1 != right) {
                int m = (left + right) / 2;
                //注意红蓝边界的变化
                if (matrix[i][m] > target) {
                    right = m;
                } else {
                    left = m;
                }
            }
//条件浓缩无法判断[[1]]，1的情况，所有条件拆开
//
//            if (left >= 0 && right < matrix[i].length && (matrix[i][left] == target || matrix[i][right] == target)) {
//                return true;
//            }
            if (left >= 0 && matrix[i][left] == target) {
                return true;
            }
            if (right < matrix[i].length && matrix[i][right] == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] matrix = {{1, 2}};
        int target = 1;
        boolean b = searchMatrix(matrix, target);
        System.out.println(b);
    }
}
