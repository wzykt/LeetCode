package tree;

import util.TreeNode;

/**
 * @date 2022-1-8 2022-1-8再次完成
 * @description 98. 验证二叉搜索树
 *
 * 参考答案完成
 */
public class _98 {
    //更简单的方法
    //利用中序遍历来实现
    //记住一个结论，对于二叉搜索树，中序遍历的结果就行排好序的，利用这个结论，就判断当前节点是否大于上一个节点即可
    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }

}
