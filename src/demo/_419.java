package demo;

/**
 * @date 2021/11/24
 * @description 419. 甲板上的战舰
 * 和200题目一样
 *
 * 怎么说呢，看错题了
 */
public class _419 {
    public int countBattleships(char[][] board) {
        int sum = 0;
        int weight = board[0].length;
        int height = board.length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < weight; j++) {
                if (board[i][j] == 'X') {
                    sum++;
                    dfs(board, i, j, height, weight);
                }
            }
        }
        return sum;
    }
    //每一次dfs的过程都会让符合条件的岛屿 ‘1’ 变为 ‘0’，理解为下沉的过程
    //所以下次进行dfs时，又是符合条件的
    public void dfs(char[][] grid, int i, int j, int weight, int height) {
        if (i < 0 || j < 0 || i > weight - 1 || j > height - 1 || grid[i][j] != 'X') {
            return;
        }
        grid[i][j] = '.';
        //依次从下，右，上，左依次下沉
        dfs(grid, i + 1, j, weight, height);
        dfs(grid, i, j + 1, weight, height);
        dfs(grid, i - 1, j, weight, height);
        dfs(grid, i, j - 1, weight, height);
    }
}
