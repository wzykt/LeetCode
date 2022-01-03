package tree;

import util.TreeNode;

/**
 * @date 2022-1-3 2022-1-3完成
 * @description 404. 左叶子之和
 */
public class _404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val+ sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

}
