package tree;

import util.TreeNode;

/**
 * @date 2022-1-9 2022-1-10完成
 * @description 450. 删除二叉搜索树中的节点
 *
 * 参考答案完成
 *
 * 最关键的逻辑就是删除一个左右孩子都不为空的节点
 * 解决上面的问题：左右孩子节点都不为空，则将删除节点的左子树头结点（左孩子）放到删除节点的右子树的最左面节点的左孩子上，返回删除节点右孩子为新的根节点。
 *
 * 而且可以用带参数的递归来实现，这样就不需要额外的去记录父节点
 */
public class _450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        root = delete(root,key);
        return root;
    }

    private TreeNode delete(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val > key) {
            root.left = delete(root.left,key);
        } else if (root.val < key) {
            root.right = delete(root.right,key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode tmp = root.right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            //这里用的是覆盖节点的值，并没有改变节点关系
            root.val = tmp.val;
            root.right = delete(root.right,tmp.val);
        }
        return root;
    }
}
