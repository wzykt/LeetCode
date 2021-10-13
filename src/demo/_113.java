package demo;

import util.TreeNode;

import java.util.*;

/**
 * 路径总和 II
 *
 * @date 2021/10/12开始 2021/10/13完成
 */
public class _113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int tem = 0;
        process(root, targetSum, tem, list, res);
        return res;
    }

    public void process(TreeNode root, int targetSum, int tem, List<Integer> list, List<List<Integer>> res) {
        if (root.left == null && root.right == null && tem == targetSum) {
            res.add(new ArrayList<>(list));
        }
        if (root == null) {
            return;
        }
        tem += root.val;
        list.add(root.val);
        process(root.left, targetSum, tem, list, res);
        list.remove(list.size() - 1);
        process(root.right, targetSum, tem, list, res);
        list.remove(list.size() - 1);
    }

}
