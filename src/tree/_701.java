package tree;

import util.TreeNode;

/**
 * @date 2022-1-9 2022-1-9完成
 * @description 701. 二叉搜索树中的插入操作
 */
public class _701 {
    TreeNode pre;

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        search(root, val);
        return root;
    }

    public void search(TreeNode root, int val) {
        if (root == null) {
            build(val);
            return;
        }
        pre = root;
        if (root.val < val) {
            search(root.right, val);
        } else if (root.val > val) {
            search(root.left, val);
        }

    }

    public void build(int val) {
        if (pre.val < val) {
            pre.right = new TreeNode(val);
        } else {
            pre.left = new TreeNode(val);
        }
    }
}
