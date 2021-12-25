package tree;

import util.TreeNode;

import java.util.*;

/**
 * @date 2021-12-25 2021-12-25完成
 * @description 94. 二叉树的中序遍历
 */
public class _94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
        //这里思路对了，但是没有写出来
        /*stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.peek();
            if(t.left!=null){
                stack.push(t.left);
            }else {
                TreeNode pop = stack.pop();
                res.add(pop.val);
                if (!stack.isEmpty()&&pop.right != null) {
                    TreeNode pop1 = stack.pop();
                    res.add(pop1.val);
                    stack.push(pop1.right);
                }
            }
        }
        return res;*/
    }
}
