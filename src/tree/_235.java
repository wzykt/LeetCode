package tree;

import util.TreeNode;

/**
 * @date 202-1-9 2022-1-9完成
 * @description 235. 二叉搜索树的最近公共祖先
 *
 * 只要从上到下遍历的时候，cur节点是数值在[p, q]区间中则说明该节点cur就是最近公共祖先了。
 */
public class _235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        if(p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}
