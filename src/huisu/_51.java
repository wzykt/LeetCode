package huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @date 2022-1-1 2022-1-1完成
 * @description 51. N 皇后
 *
 * 参考答案，套用模板即可
 * 难点在判断是否合法
 *
 * 不要觉得化成数组麻烦，数组通过下标来操作，是很简单的
 */
public class _51 {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backTrack(n, 0, chessboard);
        return res;
    }


    public void backTrack(int n, int row, char[][] chessboard) {
        if (row == n) {
            res.add(Array2List(chessboard));
            return;
        }

        for (int col = 0;col < n; ++col) {
            if (isValid (row, col, n, chessboard)) {
                chessboard[row][col] = 'Q';
                backTrack(n, row+1, chessboard);
                chessboard[row][col] = '.';
            }
        }

    }


    public List Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }


    public boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列
        for (int i=0; i<row; ++i) { // 相当于剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    //自己写的，错了
    /*public List<List<String>> res = new ArrayList<>();
    LinkedList<String> list = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        boolean[] usedL = new boolean[n];
        boolean[] usedC = new boolean[n];
        backTracking(0, n, usedL, usedC);
        return res;
    }

    public void backTracking(int index, int n, boolean[] usedL, boolean[] usedC) {
        if (index == n) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = index; i < n; i++) {
            if (usedL[i] == true || usedC[index] == true) {
                continue;
            }
            usedC[i] = true;
            usedL[index] = true;
            list.addLast(string(i, n));
            backTracking(index + 1, n, usedL, usedC);
            usedC[i] = false;
            usedL[index] = false;
            list.removeLast();
        }
    }

    public String string(Integer integer, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == integer) {
                sb.append("Q");
            } else {
                sb.append(".");
            }
        }
        return sb.toString();
    }*/
}
