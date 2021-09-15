package demo;

import java.util.*;

/**
 * 22. 括号生成
 *
 * @date 2021/9/15
 * @description 回溯，采用树的形式来遍历（及dfs），所有的结果满足一颗满二叉树，将不满足条件的二叉树枝干修剪掉
 */
public class _22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        dfs(n, "", res, 0, 0);
        return res;
    }

    private void dfs(int n, String path, List<String> res, int open, int close) {
        if (open > n || close > open) return;

        if (path.length() == 2 * n) {
            res.add(path);
            return;
        }

        //dfs深度优先遍历
        dfs(n, path + "(", res, open + 1, close);
        dfs(n, path + ")", res, open, close + 1);
    }
}
