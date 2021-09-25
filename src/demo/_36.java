package demo;

/**
 * 36. 有效的数独
 *
 * @date 2021/9/25
 * @description 只想到了暴力解法
 *
 * 答案：使用哈希表完成
 */
public class _36 {
    public boolean isValidSudoku(char[][] board) {
        int x = 0, y = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                //
                //验证if
                if (board[i][j] >= '0' && board[i][j] <= '9') {
                    if (!getEffective(board, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    boolean getEffective(char[][] board, int x, int y) {
        for (int i = y + 1; i < board[x].length; i++) {
            if (board[x][y] == board[x][i]) {
                return false;
            }
        }

        for (int i = x + 1; i < board.length; i++) {
            if (board[x][y] == board[i][y]) {
                return false;
            }
        }

        int top = x / 3;
        int bottom = y / 3;
        for (int i = top * 3; i < top * 3 + 3; i++) {
            for (int j = bottom * 3; j < bottom * 3 + 3; j++) {
                if (j == y && i == x) {
                    continue;
                } else {
                    if (board[x][y] == board[i][j]) {
                        System.out.println(i);
                        System.out.println(j);
                        return false;
                    }
                }
            }
        }
        return true;
    }

//    使用二维数组作为哈希表

//    public boolean isValidSudoku(char[][] board) {
//        int [][]row  =new int[9][10];
    //    row[1][9] = 1 表示第一行出现过9，下面同理
//        int [][]col  =new int[9][10];
//        int [][]box  =new int[9][10];
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                if (board[i][j]=='.'){
//                    continue;
//                }
//                int curNum = board[i][j]-'0';
//                if (row[i][curNum]==1){
//                    return false;
//                }if (col[j][curNum]==1){
//                    return false;
//                }
//                if (box[j/3 + (i/3) * 3][curNum]==1){
//                    return false;
//                }
//                row[i][curNum]=1;
//                col[j][curNum]=1;
//                box[j/3 + (i/3) * 3][curNum]=1;
//            }
//        }
//        return true;
//    }
}