package demo;

import util.TreeNode;

/**
 * 104. 二叉树的最大深度
 *
 * @date 2021/10/12
 */
public class _104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return depth(root);
    }

    public int depth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(depth(root.left) +1, depth(root.right)+1);
    }
}

