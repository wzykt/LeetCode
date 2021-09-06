package demo;

/**
 * 63. 不同路径 II
 *
 * @date 2021/8/28
 * @decription
 * @result 暴力递归解出来了，但是没有转化成动态规划
 * 2021/9/6 dp解决
 */
public class _63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            return 0;
        }
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        int dp[][] = new int[row + 1][column + 1];
        dp[row - 1][column - 1] = 1;
        for (int i = row; i >= 0; i--) {
            for (int j = column; j >= 0; j--) {
                if (i < row && j < column && obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i == row - 1 && j == column - 1) {
                    continue;
                }
                if (i < row && j < column) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
        //        int rows = obstacleGrid.length - 1;//行数
//        int columns = obstacleGrid[0].length - 1;//列数
//        int result = 0;
//        result = process(obstacleGrid, 0, 0, rows, columns);
//        return result;
    }

    //暴力递归，超时
    public static int process(int[][] obstacleGrid, int x, int y, int rows, int columns) {
        if (obstacleGrid[x][y] == 1) {
            return 0;
        }
        if (x > rows || y > columns) {
            return 0;
        }
        if (x == rows && y == columns) {
            return 1;
        }
        return process(obstacleGrid, x + 1, y, rows, columns) + process(obstacleGrid, x, y + 1, rows, columns);
    }
}
