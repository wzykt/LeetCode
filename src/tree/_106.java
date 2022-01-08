package tree;

import util.TreeNode;

/**
 * @date 2022-1-4 2022-1-4完成
 * @description 106. 从中序与后序遍历序列构造二叉树
 *
 * 步骤如下
 * 第一步：如果数组大小为零的话，说明是空节点了。
 *
 * 第二步：如果不为空，那么取后序数组最后一个元素作为节点元素。
 *
 * 第三步：找到后序数组最后一个元素在中序数组的位置，作为切割点
 *
 * 第四步：切割中序数组，切成中序左数组和中序右数组 （顺序别搞反了，一定是先切中序数组）
 *
 * 第五步：切割后序数组，切成后序左数组和后序右数组
 *
 * 第六步：递归处理左区间和右区间
 */
public class _106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree1(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }
    public TreeNode buildTree1(int[] inorder, int inLeft, int inRight,
                               int[] postorder, int postLeft, int postRight) {
        // 没有元素了
        if (inRight - inLeft < 1) {
            return null;
        }
        // 只有一个元素了
        if (inRight - inLeft == 1) {
            return new TreeNode(inorder[inLeft]);
        }
        // 后序数组postorder里最后一个即为根结点
        int rootVal = postorder[postRight - 1];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        // 根据根结点的值找到该值在中序数组inorder里的位置
        for (int i = inLeft; i < inRight; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        // 根据rootIndex划分左右子树
        root.left = buildTree1(inorder, inLeft, rootIndex,
                postorder, postLeft, postLeft + (rootIndex - inLeft));
        root.right = buildTree1(inorder, rootIndex + 1, inRight,
                postorder, postLeft + (rootIndex - inLeft), postRight - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        _106 obj = new _106();
        obj.buildTree(inorder,postorder);
    }
}
