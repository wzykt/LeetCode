package tree;

import util.TreeNode;

/**
 * @date 2021-1-3 2021-1-3完成
 * @description 112. 路径总和
 */
public class _112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        int sum = 0;
        return process(root, targetSum, sum);
    }

    public boolean process(TreeNode root, int targetSum, int sum) {
        if (root == null) {
            return false;
        }
        sum = sum + root.val;
        if (sum == targetSum && root.left == null && root.right == null) {
            return true;
        }

        return process(root.left, targetSum, sum) || process(root.right, targetSum, sum);
    }
}
