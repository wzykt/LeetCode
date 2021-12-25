package tree;

import util.TreeNode;

import java.util.*;

/**
 * @date 2021-12-25 2021-12-25完成
 * @description 144. 二叉树的前序遍历
 * <p>
 * 使用栈来完成
 * 右子树先入栈，左子树再入栈
 */
public class _144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            res.add(t.val);
            if (t.right != null) {
                stack.add(t.right);
            }
            if (t.left != null) {
                stack.add(t.left);
            }
        }
        return res;
    }
}
