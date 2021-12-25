package tree;

import util.TreeNode;

/**
 * @date 2021-12-25 2021-12-25完成
 * @description 226. 翻转二叉树
 *
 * 简单交换一下左右孩子节点即可
 */
public class _226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode res = root;
        process(root);
        return res;
    }

    public void process(TreeNode node) {
        if (node == null) {
            return;
        }

        TreeNode l = node.left;
        TreeNode r = node.right;
        node.left = r;
        node.right = l;
        process(node.left);
        process(node.right);
    }
}
