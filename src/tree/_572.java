package tree;

import util.TreeNode;

/**
 * @date 2021-12-27 2021-12-27完成
 * @description 572. 另一棵树的子树
 */
public class _572 {


public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return isTrue(root, subRoot);
    }

    public boolean dfs(TreeNode node, TreeNode subNode) {
        if(node == null){
            return false;
        }
        return dfs(node.left, subNode) || dfs(node.right, subNode) || isTrue(node, subNode);
    }

    public boolean isTrue(TreeNode node, TreeNode subNode) {
        if (node == null && subNode == null) {
            return true;
        }
        if (node == null || subNode == null || node.val != subNode.val) {
            return false;
        }
        return isTrue(node.left, subNode.left) && isTrue(node.right, subNode.right);
    }


//错误的写法，把遍历和判断卸载一起，导致无法解决[1,1]  [1]的情况
/*    public boolean isTrue(TreeNode node, TreeNode subNode) {
        if (node == null && subNode == null) {
            return true;
        }
        if (node == null && subNode != null) {
            return false;
        }
        if (node != null && subNode == null) {
            return false;
        }
        boolean it = false;
        if (node.val == subNode.val) {
            it = true;
            return it && isTrue(node.left, subNode.left) && isTrue(node.right, subNode.right);
        } else {
            return isTrue(node.left, subNode) || isTrue(node.right, subNode);
        }
    }*/
}
