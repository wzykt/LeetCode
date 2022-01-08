package tree;

import util.TreeNode;

/**
 * @date 2022-1-4 2022-1-4完成
 * @description 105. 从前序与中序遍历序列构造二叉树
 * <p>
 * 核心都在于分割中序遍历的数组
 * 难点在于如何确定是左闭右开还是左开右闭
 * <p>
 * 和106题一起看
 */
public class _105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * @param preorder
     * @param preLeft 前序遍历数组的左子树起始位置，或右子树起始位置
     * @param preRight 前序遍历数组的左子树终止位置，或右子树终止位置
     * @param inorder
     * @param inLeft 中序遍历数组的左子树起始位置，或右子树起始位置
     * @param inRight 中序遍历数组的左子树终止位置，或右子树终止位置
     * @return TreeNode
     */
    public TreeNode helper(int[] preorder, int preLeft, int preRight,
                           int[] inorder, int inLeft, int inRight) {
        // 递归终止条件
        if (inLeft > inRight || preLeft > preRight) return null;

        // val 为前序遍历第一个的值，也即是根节点的值
        // idx 为根据根节点的值来找中序遍历的下标
        int idx = inLeft, val = preorder[preLeft];
        TreeNode root = new TreeNode(val);
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == val) {
                idx = i;
                break;
            }
        }

        // 根据 idx 来递归找左右子树
        root.left = helper(preorder, preLeft + 1, preLeft + (idx - inLeft), inorder, inLeft, idx - 1);
        root.right = helper(preorder, preLeft + (idx - inLeft) + 1, preRight, inorder, idx + 1, inRight);
        return root;
    }
}
