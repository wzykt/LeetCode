package tree;

import util.TreeNode;

/**
 * @date 2022-1-10 2022-1-10完成
 * @description 669. 修剪二叉搜索树
 */
public class _669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {

        return process(root, low, high);
        /**/
    }

    public TreeNode process(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            root = process(root.right, low, high);
        } else if (root.val > high) {
            root = process(root.left, low, high);
        } else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }
        return root;
    }
}
