package tree;

import util.TreeNode;

/**
 * @date 2021-12-27 2021-12-27完成
 * @description 111. 二叉树的最小深度
 * 注意：最小深度是从根节点到最近叶子节点的最短路径上的节点数量。注意是叶子节点。
 * 什么是叶子节点，左右孩子都为空的节点才是叶子节点！
 */
public class _111 {
    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return depth(root);
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right != null) {
            return Math.min(depth(root.left) + 1, depth(root.right) + 1);
        }
        return Math.max(depth(root.left) + 1, depth(root.right) + 1);
    }
}
