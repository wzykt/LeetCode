package tree;

import util.TreeNode;

/**
 * @date 2022-1-4 2022-1-8完成
 * @description 617.合并二叉树
 *
 * 难点就在确定终止条件：
 * 因为是传入了两个树，那么就有两个树遍历的节点t1 和 t2，如果t1 == NULL 了，两个树合并就应该是 t2 了啊（如果t2也为NULL也无所谓，合并之后就是NULL）。
 * 反过来如果t2 == NULL，那么两个数合并就是t1（如果t1也为NULL也无所谓，合并之后就是NULL）。
 */
public class _617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return build(root1, root2);
    }

    public TreeNode build(TreeNode root1, TreeNode root2) {
        TreeNode node = new TreeNode();
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 != null && root2 != null) {
            node = new TreeNode(root1.val + root2.val);
            node.left = build(root1.left, root2.left);
            node.right = build(root1.right, root2.right);
        } else if (root1 == null && root2 != null) {
            node = new TreeNode(root2.val);
            node.left = build(null, root2.left);
            node.right = build(null, root2.right);
        } else if (root1 != null && root2 == null) {
            node = new TreeNode(root1.val);
            node.left = build(root1.left, null);
            node.right = build(root1.right, null);
        }
        return node;
    }

    //答案
    // 递归
/*    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        TreeNode newRoot = new TreeNode(root1.val + root2.val);
        newRoot.left = mergeTrees(root1.left,root2.left);
        newRoot.right = mergeTrees(root1.right,root2.right);
        return newRoot;
    }*/
}
