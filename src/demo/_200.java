package demo;

/**
 * @date 2021/11/21 2021/11/21完成
 * @description 200. 岛屿数量
 * 参考视频完成：https://www.bilibili.com/video/BV1wA411b7qZ?p=33
 *
 * dfs+沉没
 */
public class _200 {
    public int numIslands(char[][] grid) {
        int sum = 0;
        int weight = grid[0].length;
        int height = grid.length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < weight; j++) {
                if (grid[i][j] == '1') {
                    sum++;
                    dfs(grid, i, j, height, weight);
                }
            }
        }
        return sum;
    }
    //每一次dfs的过程都会让符合条件的岛屿 ‘1’ 变为 ‘0’，理解为下沉的过程
    //所以下次进行dfs时，又是符合条件的
    public void dfs(char[][] grid, int i, int j, int weight, int height) {
        if (i < 0 || j < 0 || i > weight - 1 || j > height - 1 || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        //依次从下，右，上，左依次下沉
        dfs(grid, i + 1, j, weight, height);
        dfs(grid, i, j + 1, weight, height);
        dfs(grid, i - 1, j, weight, height);
        dfs(grid, i, j - 1, weight, height);
    }
}
