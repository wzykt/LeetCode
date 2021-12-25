package tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @date 2021-12-25 2021-12-25完成
 * @description 145. 二叉树的后序遍历
 *
 * 再来看后序遍历，先序遍历是中左右，后续遍历是左右中，那么我们只需要调整一下先序遍历的代码顺序，就变成中右左的遍历顺序，然后在反转result数组，输出的结果顺序就是左右中了
 */
public class _145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.peek();
            if (t.left != null) {
                stack.push(t.left);
            } else {
                if (t.right != null) {
                    stack.push(t.right);
                }
                res.add(stack.pop().val);
            }
        }
        return res;
    }
}
