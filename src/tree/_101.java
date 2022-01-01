package tree;

import sun.reflect.generics.tree.Tree;
import util.TreeNode;

/**
 * @date 2021-12-26 2021-12-26完成
 * @description 101. 对称二叉树
 */
public class _101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return process(root.left, root.right);
    }

    public boolean process(TreeNode left, TreeNode right) {
        boolean isTrue = false;
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return isTrue;
        }
        if (left.val == right.val) {
            isTrue = true;
        }

        return isTrue && process(left.left, right.right) && process(left.right, right.left);
    }
}
