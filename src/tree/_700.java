package tree;

import util.TreeNode;

/**
 * @date 2022-1-8 2022-1-8完成
 * @description 700. 二叉搜索树中的搜索
 *
 * 利用一下二叉搜索树的性质即可
 */
public class _700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
